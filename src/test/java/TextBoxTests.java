//Заполнить поле Full Name
//Заполнить поле Email
//Заполнить поле Current Address
//Заполнить поле Permanent Address
//Результат поля Output должен содержать раннее введеные значения

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import utils.RandomUtils;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }
// Set variable
    String name = RandomUtils.getRandomString(6) + " " + RandomUtils.getRandomString(6);
    String email = RandomUtils.getRandomEmail();
    String currentAddress = RandomUtils.getRandomString(10);
    String permanentAddress = RandomUtils.getRandomString(12);
    @Test
    void fillFormTest() {
        open("/text-box");
// Close popups
        Selenide.executeJavaScript("$('#fixedban').remove()");
        Selenide.executeJavaScript("$('footer').remove()");
// Fill forms
        $("#userName").setValue(name);
        $("#userEmail").setValue(email);
        $("#currentAddress").setValue(currentAddress);
        $("#permanentAddress").setValue(permanentAddress);
        $("#submit").click();
// Check results
        $("#output").shouldHave(text(name));
        $("#output").shouldHave(text(email));
        $("#output").shouldHave(text(currentAddress));
        $("#output").shouldHave(text(permanentAddress));
    }
}
