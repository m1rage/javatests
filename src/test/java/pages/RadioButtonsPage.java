package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class RadioButtonsPage {

    private SelenideElement yesRadio = $("#yesRadio");
    private SelenideElement impressiveRadio = $("#impressiveRadio");
    private SelenideElement noRadio = $("noRadio");
    private SelenideElement textSuccess = $(".text-success");

    public void openPage () {
        open("/radio-button");
    }

    public void clickRadioButton (String value) {
        if (value = "Yes")
        {
            $(yesRadio).sibling(0).click();
        }
        else (value = "Impressive")
        {
            $(impressiveRadio).sibling(0).click();
        }
    }

    public void checkResult (String value) {
        if (value = "Yes")
        {
            $(textSuccess).shouldHave(text("Yes"));
        }
        else (value = "Impressive")
        {
            $(textSuccess).shouldHave(text("Impressive"));
        }
    }
}
