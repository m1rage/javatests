package tests;

import org.junit.jupiter.api.Test;
import pages.ButtonPage;
import utils.TestBase;

public class ButtonsTests extends TestBase {
    ButtonPage buttonPage = new ButtonPage();

    @Test
    public void fillForms () {

    buttonPage.openPage();

    buttonPage.clickDoubleButton();
    buttonPage.checkDoubleClickMessage();

    buttonPage.clickRightClickMe();
    buttonPage.checkRightClickMessage();

    buttonPage.clickClickMe();
    buttonPage.checkClickMessage();
    }
}