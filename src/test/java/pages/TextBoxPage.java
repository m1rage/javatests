package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.matchText;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxPage {
    private SelenideElement nameSelector = $("#userName");
    private SelenideElement emailSelector = $("#userEmail");
    private SelenideElement currentAddressSelector = $("#currentAddress");
    private SelenideElement permanentAddressSelector = $("#permanentAddress");
    private SelenideElement submitSelector = $("#submit");
    private SelenideElement outputSelector = $("#output");

    public void openPage () {
        open("/text-box");
    }

    public void setUserName (String value) {
        nameSelector.setValue(value);
    }

    public void setEmail (String value) {
        emailSelector.setValue(value);
    }

    public void setCurrentAddress (String value) {
        currentAddressSelector.setValue(value);
    }

    public void setPermanentAddress (String value) {
        permanentAddressSelector.setValue(value);
    }

    public void clickSubmit () {
        submitSelector.click();
    }

    public void checkOutput (String value) {
        outputSelector.shouldHave(matchText(value));
    }

}

