package junit;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class Contact {

    @BeforeAll
    static void beforeAll() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "2560x1140";

    }

    @Test
    void Contact() {

        //Submission issue

        open("https://www.croxyproxy.com/");
        $(".fc-button-label").click();
        $(".form-control.input-lg.js-typeahead-domains").setValue("DAXTRA.COM/SUPPORT");

        $("#requestSubmit").click();
        sleep(2000);


        $(".wp-block-b1-header__info").shouldHave(text("Support"));
        $("#input_1_5_3").setValue("test");
        $("#input_1_5_6").setValue("test");
        $("#input_1_6").setValue("test");
        $("#input_1_7").setValue("test");
        $("#input_1_8").setValue("test");
        $("#input_1_4").uploadFromClasspath("img/1.jpg");
        $("#input_1_4").uploadFile(new File("src/test/resources/img/1.jpg"));
        $("#gform_submit_button_1").click();
        $(".gform_validation_errors.validation_error").shouldHave(text("There was a problem with your submission. Please review the fields below."));

        //Successful submussion
        open("https://www.croxyproxy.com/");
        $(".form-control.input-lg.js-typeahead-domains").setValue("DAXTRA.COM/SUPPORT");
        $("#requestSubmit").click();
        sleep(2000);
        $(".wp-block-b1-header__info").shouldHave(text("Support"));
        $("#input_1_5_3").setValue("test");
        $("#input_1_5_6").setValue("test");
        $("#input_1_6").setValue("test");
        $("#input_1_7").setValue("test@grok.com");
        $("#input_1_8").setValue("test");
        $("#input_1_3").setValue("test");
        //Issue Category
        $("#input_1_1").click();
        $("#input_1_1").selectOption("P3 – Minor – Isolated User Issues");
        //Daxtra Product Affected
        $("#input_1_2").click();
        $("#input_1_2").selectOption("Daxtra Parser (CVX)");
        //Country
        $("#input_1_10").click();
        $("#input_1_10").selectOption("United Kingdom");
        //Terms
       $("#choice_1_12_1").click();

        sleep(2000);

//Ads
        $("#hs-eu-decline-button").click();
        // Scroll to the button and click
        $("#gform_submit_button_1").shouldBe(visible).shouldBe(enabled).click();
        $("#gform_confirmation_message_1").shouldHave(text("Thank you."));


        // $("#input_1_2").click();
        //$("#input_1_2").shouldBe(Condition.visible).selectOptionContainingText("Daxtra Parser");

        //Test Issue Category
        //$("#input_1_1").click();
        //$(".medium.gfield_select").selectOption("P3 – Minor – Isolated User Issues");
        //Issue field:
        //$("#input_1_2").click();
        //$(".medium.gfield_select").selectOption("Daxtra Parser (CVX)");
       //sleep(2000);
        //Daxtra Product Affected input_1_2 Daxtra Search
        //Attached file
        //$("#input_1_4").uploadFromClasspath("img/1.jpg");
        //$("#input_1_4").uploadFile(new File("src/test/resources/img/1.jpg"));
        //input_1_4 src/test/resources/img/1.png
//







    }
}