package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class ButtonPage {

    private SelenideElement doubleClickMe = $("#doubleClickBtn");
    private SelenideElement rightClickMe = $("#rightClickBtn");
    private SelenideElement clickMe = $$("button.btn.btn-primary").findBy(exactText("Click Me"));

    private SelenideElement doubleClickMessage = $("#doubleClickMessage");
    private SelenideElement rightClickMeMessage = $("#rightClickMessage");
    private SelenideElement clickMeMessage = $("#dynamicClickMessage");

    public void openPage () {
        open("/buttons");
    }

    public void clickDoubleButton () {
        doubleClickMe.doubleClick();
    }

    public void clickRightClickMe () {
        rightClickMe.contextClick();
    }

    public void clickClickMe () {
        clickMe.click();
    }

    public void checkDoubleClickMessage () {
        doubleClickMessage.shouldBe(visible);
        doubleClickMessage.shouldHave(text("You have done a double click"));
    }

    public void checkRightClickMessage () {
        rightClickMeMessage.shouldBe(visible);
        rightClickMeMessage.shouldHave(text("You have done a right click"));
    }

    public void checkClickMessage () {
        clickMeMessage.shouldBe(visible);
        clickMeMessage.shouldHave(text("You have done a dynamic click"));
    }
}
