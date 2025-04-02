package junit;

import Pages.SupportPage;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.File;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class ContactWithPageObjects {
    SupportPage supportPage = new SupportPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "2560x1140";
    }

    @Test
    void Contact() {
        // Unsuccessful submission test
        supportPage.openPage();
        //supportPage.openPageSuccess();
        supportPage.setFirstName("First Name");
        supportPage.setLastName("Last Name");
        supportPage.setPhone("Phone");
        supportPage.setCompany("Company");


        $("#input_1_4").uploadFromClasspath("img/1.jpg");
        $("#input_1_4").uploadFile(new File("src/test/resources/img/1.jpg"));
        $("#gform_submit_button_1").click();
        $(".gform_validation_errors.validation_error")
                .shouldHave(text("There was a problem with your submission. Please review the fields below."));

        // Successful submission test
        supportPage.openPageSuccess();
        supportPage.setEmail("test@grok.com");
        supportPage.setDescription("Description");
        supportPage.setFirstName("First Name");
        supportPage.setLastName("Last Name");
        supportPage.setPhone("Phone");
        supportPage.setCompany("Company");
       // $("#input_1_7").setValue("test@grok.com");
       // $("#input_1_3").setValue("Description");

        // Issue Category
        $("#input_1_1").click();
        $("#input_1_1").selectOption("P3 – Minor – Isolated User Issues");

        // Daxtra Product Affected
        $("#input_1_2").click();
        $("#input_1_2").selectOption("Daxtra Parser (CVX)");

        // Country
        $("#input_1_10").click();
        $("#input_1_10").selectOption("United Kingdom");

        // Terms
        $("#choice_1_12_1").click();

        sleep(2000);

        // Ads
        $("#hs-eu-decline-button").click();

        // Scroll to the button and click
        $("#gform_submit_button_1").shouldBe(visible).shouldBe(enabled).click();
        $("#gform_confirmation_message_1").shouldHave(text("Thank you."));
    }
}