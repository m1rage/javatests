package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class RadioButtonsPage {

    private SelenideElement yesRadio = $("#yesRadio");
    private SelenideElement impressiveRadio = $("#impressiveRadio");
    private SelenideElement noRadio = $("#noRadio");
    private SelenideElement textSuccess = $(".text-success");

    public void openPage () {
        open("/radio-button");
    }

    public void clickYesRadioButton () {
        yesRadio.shouldBe(enabled);
        yesRadio.sibling(0).click();
    }

    public void clickImpressiveRadioButton () {
        impressiveRadio.shouldBe(enabled);
        impressiveRadio.sibling(0).click();
    }

    public void checkClickYesRadioButton () {
        yesRadio.shouldBe(selected);
        textSuccess.shouldBe(visible);
        textSuccess.shouldHave(text("Yes"));
    }

    public void checkClickImpressiveRadioButton () {
        impressiveRadio.shouldBe(selected);
        textSuccess.shouldBe(visible);
        textSuccess.shouldHave(text("Impressive"));
    }

    public void checkNoRadioButton () {
        noRadio.shouldBe(disabled);
    }

}
