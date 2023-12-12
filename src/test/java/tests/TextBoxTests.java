package tests;

import org.junit.jupiter.api.Test;
import utils.RandomUtils;
import pages.TextBoxPage;
import utils.TestBase;

public class TextBoxTests extends TestBase {
    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    public void fillForms () {
        String name = RandomUtils.getRandomString(6) + " " + RandomUtils.getRandomString(6);
        String email = RandomUtils.getRandomEmail();
        String currentAddress = RandomUtils.getRandomString(10);
        String permanentAddress = RandomUtils.getRandomString(12);
        String output = "Name:"+name+"\n"+"Email:"+email+"\n"+"Current Address :"+currentAddress+"\n"+"Permananet Address :"+permanentAddress;

        textBoxPage.openPage();
        textBoxPage.setUserName(name);
        textBoxPage.setEmail(email);
        textBoxPage.setCurrentAddress(currentAddress);
        textBoxPage.setPermanentAddress(permanentAddress);
        textBoxPage.clickSubmit();
        textBoxPage.checkOutput(output);
    }
}
