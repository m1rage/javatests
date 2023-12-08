import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest() {
        open("/text-box");

        $("#userName").setValue("Pavel Ptichkin");
        $("#userEmail").setValue("pavel@ptichkin.com");
        $("#currentAddress").setValue("Some address 1");
        $("#permanentAddress").setValue("Another address 1");
        $("#submit").click();

        $("#output").shouldHave(text("Pavel Ptichkin"), text("pavel@ptichkin.com"),
                text("Some address 1"), text("Another address 1"));
    }
}
