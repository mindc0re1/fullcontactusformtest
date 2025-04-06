package junit;

import Pages.SupportPage;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.File;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class ContactWithPageObjects extends TestBase {


    @Test
    void Contact() {
        // Unsuccessful submission test
        supportPage.openPage()
        //supportPage.openPageSuccess();

        .setFirstName("First Name")
        .setLastName("Last Name")
        .setPhone("Phone")
        .setCompany("Company");


        $("#input_1_4").uploadFromClasspath("img/1.jpg");
        $("#input_1_4").uploadFile(new File("src/test/resources/img/1.jpg"));
        $("#gform_submit_button_1").click();
        $(".gform_validation_errors.validation_error").shouldHave(text("There was a problem with your submission. Please review the fields below."));

        // Successful submission test
        supportPage.openPageSuccess()
        .setEmail("test@grok.com")
        .setDescription("Description")
        .setFirstName("First Name")
        .setLastName("Last Name")
        .setPhone("Phone")
        .setCompany("Company");
       // $("#input_1_7").setValue("test@grok.com");
       // $("#input_1_3").setValue("Description");
// Issue Category using DropdownComponent
        supportPage.issueCategory().selectOption("P3 – Minor – Isolated User Issues");

        // Daxtra Product Affected using DropdownComponent
        supportPage.daxtraProductAffected().selectOption("Daxtra Parser (CVX)");

        // Country using DropdownComponent
        supportPage.country().selectOption("United Kingdom");


        // Terms
        $("#choice_1_12_1").click();

        sleep(2000);

        // Ads
        $("#hs-eu-decline-button").click();

        // Scroll to the button and click
        $("#gform_submit_button_1").shouldBe(visible).shouldBe(enabled).click();

        supportPage.verifyThanksAppears ();
    }

}