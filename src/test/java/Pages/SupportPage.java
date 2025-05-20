
package Pages;

import Pages.components.DropdownComponent;
import Pages.components.Thanks;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SupportPage {
    private final String TITLE_TEXT = "Support";
    private final String TITLE_TEXT2 = "Thank you";
    Thanks thanks = new Thanks();
    private SelenideElement
            lastNameInput = $("#input_1_5_6"),
            firstNameInput = $("#input_1_5_3"),
            phoneInput = $("#input_1_6"),
            companyInput = $("#input_1_8"),
            emailInput = $("#input_1_7"),
            descriptionInput = $("#input_1_3"),
            finalInput = $("#gform_confirmation_message_1");

    public SupportPage openPage() {
        open("https://www.croxyproxy.com/");
        $(".fc-button-label").click();
        $(".form-control.input-lg.js-typeahead-domains").setValue("DAXTRA.COM/SUPPORT");
        $("#requestSubmit").click();
        $(".wp-block-b1-header__info").shouldHave(text(TITLE_TEXT));

        return this;
    }

    public SupportPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public SupportPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public SupportPage setPhone(String value) {
        phoneInput.setValue(value);

        return this;
    }

    public SupportPage setCompany(String value) {
        companyInput.setValue(value);

        return this;
    }

    public SupportPage openPageSuccess() {
        open("https://www.croxyproxy.com/");
        //$(".fc-button-label").click();
        $(".form-control.input-lg.js-typeahead-domains").setValue("DAXTRA.COM/SUPPORT");
        $("#requestSubmit").click();
        $(".wp-block-b1-header__info").shouldHave(text(TITLE_TEXT));

        return this;
    }

    public SupportPage setEmail(String value ) {
        emailInput.setValue(value);

        return this;
    }

    public SupportPage setDescription(String value) {
        descriptionInput.setValue(value);

        return this;
    }

    public DropdownComponent issueCategory() {
        return new DropdownComponent("#input_1_1");
    }

    public DropdownComponent daxtraProductAffected() {
        return new DropdownComponent("#input_1_2");
    }

    public DropdownComponent country() {
        return new DropdownComponent("#input_1_10");
    }

    public String getTITLE_TEXT2() {
        return TITLE_TEXT2;
    }

    public SupportPage  verifyThanksAppears () {
      thanks.verifyThanksAppears();
        return this;
    }

}