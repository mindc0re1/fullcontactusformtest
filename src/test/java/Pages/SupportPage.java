package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class SupportPage {
private final String TITLE_TEXT = "Support";
private SelenideElement
        lastNameInput = $("#input_1_5_6"),
        firstNameInput = $("#input_1_5_3"),
        phoneInput = $("#input_1_6"),
        companyInput = $("#input_1_8");

    public void openPage() {

        //Unsucsessfull registration
    open("https://www.croxyproxy.com/");
    $(".fc-button-label").click();
    $(".form-control.input-lg.js-typeahead-domains").setValue("DAXTRA.COM/SUPPORT");
    $("#requestSubmit").click();
    //sleep(2000);
        $(".wp-block-b1-header__info").shouldHave(text(TITLE_TEXT));

}

    public void setFirstName(String value) {
        firstNameInput.setValue(value);

    }
    public void setLastName(String value) {
        lastNameInput.setValue(value);

    }

    public void setPhone(String value) {
        phoneInput.setValue(value);

    }
        public void setCompany(String value) {
            companyInput.setValue(value);

    }

//Registration is successfull
}


