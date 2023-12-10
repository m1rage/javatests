import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
public class CheckBoxTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }
    @Test
    void fillFormTest() {
        open("/checkbox");
        Selenide.executeJavaScript("$('#fixedban').remove()");
        Selenide.executeJavaScript("$('footer').remove()");

        $(".rct-icon-expand-all").click();
        $x("//span[contains(text(),'Home')]").click();
        $x("//span[contains(text(),'Excel File.doc')]").click();

        $("#result").shouldHave(text("desktop"));
        $("#result").shouldHave(text("notes"));
        $("#result").shouldHave(text("commands"));
        $("#result").shouldHave(text("documents"));
        $("#result").shouldHave(text("workspace"));
        $("#result").shouldHave(text("react"));
        $("#result").shouldHave(text("angular"));
        $("#result").shouldHave(text("veu"));
        $("#result").shouldHave(text("office"));
        $("#result").shouldHave(text("public"));
        $("#result").shouldHave(text("private"));
        $("#result").shouldHave(text("classified"));
        $("#result").shouldHave(text("general"));
        $("#result").shouldHave(text("wordFile"));
    }
}
