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

public class PracticeFormTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    String firstName = RandomUtils.getRandomString(5);
    String lastName = RandomUtils.getRandomString(7);
    String email = firstName + "." + lastName + "@email.xyz";
    String gender = "Male";
    String phoneNumber = RandomUtils.getRandomPhone();
    String month = RandomUtils.getRandomMonth();
    String year = RandomUtils.getRandomYear();
    String date = RandomUtils.getRandomDate();
    String subjectsField = "English";
    String hobbies = "Music";
    String address = RandomUtils.getRandomString(10);
    String addressState = "Uttar Pradesh";
    String addressCity = "Agra";

    @Test
    public void fillForms() {
        open("/automation-practice-form");

        Selenide.executeJavaScript("$('#fixedban').remove()");
        Selenide.executeJavaScript("$('footer').remove()");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").setValue(phoneNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-dropdown-container").$(byText(month)).click();
        $(".react-datepicker__year-dropdown-container").$(byText(year)).click();
        $(".react-datepicker__month-container").$(byText(date)).click();
        $("#subjectsInput").setValue(subjectsField).pressEnter();
        $("#hobbies-checkbox-3").parent().$(byText(hobbies)).click();
        $("#uploadPicture").uploadFromClasspath("pics/1.jpeg");
        $("#currentAddress").setValue(address);
        $("#state").click();
        $("#stateCity-wrapper").$(byText(addressState)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(addressCity)).click();
        $("#submit").click();

        $(".modal-body").shouldHave(text(firstName+" "+lastName));
        $(".modal-body").shouldHave(text(email));
        $(".modal-body").shouldHave(text(gender));
        $(".modal-body").shouldHave(text(phoneNumber));
        $(".modal-body").shouldHave(text(date+" "+month+","+year));
        $(".modal-body").shouldHave(text(subjectsField));
        $(".modal-body").shouldHave(text(hobbies));
        $(".modal-body").shouldHave(text(address));
        $(".modal-body").shouldHave(text(addressState+" "+addressCity));
    }
}