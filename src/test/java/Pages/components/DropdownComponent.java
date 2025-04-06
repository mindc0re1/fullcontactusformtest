package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class DropdownComponent {
    private final SelenideElement dropdown;

    public DropdownComponent(String cssSelector) {
        this.dropdown = $(cssSelector);
    }

    public DropdownComponent selectOption(String value) {
        dropdown.click();
        dropdown.selectOption(value);
        return this;
    }
}