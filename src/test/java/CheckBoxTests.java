import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CheckBoxTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest() {
        open("/checkbox");

        $(".rct-icon-expand-all").click();
        $("#tree-node-home").click();
        $(".rct-node:nth-child(3) .rct-node:nth-child(2) .rct-checkbox > .rct-icon").click();

        $("#result").shouldHave(text("desktop notes commands documents workspace react angular veu office public private classified general wordFile"));
    }
}
