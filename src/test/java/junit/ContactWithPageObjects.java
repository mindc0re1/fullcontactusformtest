package junit;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import java.io.File;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class ContactWithPageObjects extends TestBase {

    @Test
    @Feature("Submission function testing")
    @Owner("Roman Kursin")
    @Story("Creating the issue")
    @Severity(SeverityLevel.BLOCKER)
    void Contact() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        // Unsuccessful submission test
        step("Open Support page (unsuccessful path)", () -> {
            supportPage.openPage();
            step("Set First Name", () -> {
            });
                supportPage.setFirstName(data.firstName);

            });
        step("Set Last Name", () -> {
                supportPage.setLastName(data.lastName);
            });

        step("Set Phone Number", () -> {
                supportPage.setPhone(data.phone);
            });

        step("Set Company", () -> {
                supportPage.setCompany(data.company);
            });

        step("Upload file", () -> {
        $("#input_1_4").shouldBe(visible).uploadFromClasspath("img/1.jpg");
        $("#input_1_4").uploadFile(new File("src/test/resources/img/1.jpg"));
        $("#gform_submit_button_1").click();
            });

        step("There is a problem text", () -> {
            $(".gform_validation_errors.validation_error").shouldHave(text("There was a problem with your submission. Please review the fields below."));
            });

            // Successful submission test
        step("Open Support page (successful path)", () -> {
            supportPage.openPageSuccess(); // returns the page object
        });

        step("Set email in the form", () -> {
            supportPage.setEmail(data.userEmail);
        });


        step("Fill in description", () -> {
            supportPage.setDescription(data.address);
        });

        step("Set First Name", () -> {
        supportPage.setFirstName(data.firstName);

        });
        step("Set Last Name", () -> {
                supportPage.setLastName(data.lastName);
        });

        step("Set Phone Number", () -> {
            supportPage.setPhone(data.phone);
        });

        step("Set Company", () -> {
                supportPage.setCompany(data.company);
        });

// Issue Category using DropdownComponent
        step("Dropdown P3 – Minor – Isolated User Issues", () -> {
            supportPage.issueCategory().selectOption("P3 – Minor – Isolated User Issues");
        });

        step(" Dropdown Daxtra Parser (CVX)", () -> {

            supportPage.daxtraProductAffected().selectOption("Daxtra Parser (CVX)");
        });

        step("Dropdown United Kingdom", () -> {
            // Country using DropdownComponent
            supportPage.country().selectOption("United Kingdom");
            });

        step("Upload file", () -> {
            $("#input_1_4").shouldBe(visible).uploadFromClasspath("img/1.jpg");
            $("#input_1_4").uploadFile(new File("src/test/resources/img/1.jpg"));
           // $("#gform_submit_button_1").click();
        });

            // Terms

        step("Terms Accepted", () -> {
            $("#choice_1_12_1").click();
        });
            sleep(2000);
        step("Ads Proxy System Information", () -> {
            // Ads
            $("#hs-eu-decline-button").click();

            // Scroll to the button and click
            $("#gform_submit_button_1").shouldBe(visible).shouldBe(enabled).click();
        });
            step("Thanks appears", () -> {
            supportPage.verifyThanksAppears();
            });
            sleep(2000);
        }

    }
