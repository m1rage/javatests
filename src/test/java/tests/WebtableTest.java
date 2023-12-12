package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import utils.RandomUtils;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebtableTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
    }

    String firstName = RandomUtils.getRandomString(5);
    String lastName = RandomUtils.getRandomString(7);
    String age = String.valueOf(RandomUtils.getRandomInt(18, 90));
    String email = RandomUtils.getRandomEmail();
    String salary = String.valueOf(RandomUtils.getRandomInt(1000, 9999));
    String department = RandomUtils.getRandomDepartment();

//    public void newTableRecord(int numberOfNewRecords) {
//        for (int i = 0; i < numberOfNewRecords; i++) {
//            String firstName = RandomUtils.getRandomString(5);
//            String lastName = RandomUtils.getRandomString(7);
//            String age = String.valueOf(RandomUtils.getRandomInt(18, 90));
//            String email = RandomUtils.getRandomEmail();
//            String salary = String.valueOf(RandomUtils.getRandomInt(1000, 9999));
//            String department = RandomUtils.getRandomDepartment();
//            $("#addNewRecordButton").click();
//            $("#firstName").setValue(firstName);
//            $("#lastName").setValue(lastName);
//            $("#userEmail").setValue(email);
//            $("#age").setValue(age);
//            $("#salary").setValue(salary);
//            $("#department").setValue(department);
//            $("#submit").click();
//        }
//    }

    @Test
    public void fillForms() {
        open("/webtables");

        $("#addNewRecordButton").click();
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#age").setValue(age);
        $("#salary").setValue(salary);
        $("#department").setValue(department);
        $("#submit").click();

        $(".rt-table").shouldHave(text(firstName));
        $(".rt-table").shouldHave(text(lastName));
        $(".rt-table").shouldHave(text(email));
        $(".rt-table").shouldHave(text(age));
        $(".rt-table").shouldHave(text(salary));
        $(".rt-table").shouldHave(text(department));
    }
}