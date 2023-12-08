import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeForm {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    public void fillForms() {
        open("/automation-practice-form");
        Selenide.executeJavaScript("$('#fixedban').remove()");
        Selenide.executeJavaScript("$('footer').remove()");

// Fill forms
        $("#firstName").setValue("Pavel");
        $("#lastName").setValue("Ptichkin");
        $("#userEmail").setValue("pavel@ptichkin.ru");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("9999999999");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-dropdown-container").$(byText("January")).click();
        $(".react-datepicker__year-dropdown-container").$(byText("1993")).click();
        $(".react-datepicker__month-container").$(byText("26")).click();
        $("#subjectsInput").setValue("English").pressEnter();
        $("#hobbies-checkbox-3").parent().$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("pics/1.jpeg");
        $("#currentAddress").setValue("Yerevan 11 22");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Panipat")).click();
        $("#submit").click();

// Result check
        $(".modal-body").shouldHave(text("Pavel Ptichkin"));
        $(".modal-body").shouldHave(text("pavel@ptichkin.ru"));
        $(".modal-body").shouldHave(text("Male"));
        $(".modal-body").shouldHave(text("9999999999"));
        $(".modal-body").shouldHave(text("26 January,1993"));
        $(".modal-body").shouldHave(text("English"));
        $(".modal-body").shouldHave(text("Music"));
        $(".modal-body").shouldHave(text("Yerevan 11 22"));
        $(".modal-body").shouldHave(text("Haryana Panipat"));
//        $("#closeLargeModal").click();

    }
}