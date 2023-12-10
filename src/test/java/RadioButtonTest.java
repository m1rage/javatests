//Кликнуть радиобаттон "Yes", результат должен содержать "Yes"
//Кликнуть радиобаттон "Impressive", результат должен содержать "Impressive"
//Радиобаттон "No" должен быть некликабельным

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.disabled;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class RadioButtonTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest() {
        open("/radio-button");
// Close ads
        Selenide.executeJavaScript("$('#fixedban').remove()");
        Selenide.executeJavaScript("$('footer').remove()");
// Check "Yes" button
        $("#yesRadio").sibling(0).click();
        $(".text-success").shouldHave(text("Yes"));
// Check "Impressive" button
        $("#impressiveRadio").sibling(0).click();
        $(".text-success").shouldHave(text("Impressive"));
// Check "No" button
        $("#noRadio").shouldBe(disabled);
    }
}
