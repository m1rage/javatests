package pages;

import org.junit.jupiter.api.Test;
import utils.TestBase;
import pages.RadioButtonsPage;

public class RadioButtonTest  extends TestBase {
    RadioButtonsPage radioButtonsPage = new RadioButtonsPage();

@Test
public void fillForms () {
    radioButtonsPage.openPage();

    radioButtonsPage.clickYesRadioButton();
    radioButtonsPage.checkClickYesRadioButton();

    radioButtonsPage.clickImpressiveRadioButton();
    radioButtonsPage.checkClickImpressiveRadioButton();

    radioButtonsPage.checkNoRadioButton();
}
}

