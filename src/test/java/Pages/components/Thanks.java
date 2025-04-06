package Pages.components;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class Thanks {
    public void verifyThanksAppears () {

        $("#gform_confirmation_message_1").shouldHave(text("Thank you."));
    }
}
