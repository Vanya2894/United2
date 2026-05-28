package Pages.Elements;

import Pages.BasePage;
import com.microsoft.playwright.Page;

import java.util.Locale;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class RadioButtonPage extends BasePage {

    // Locators
    private String yesRadioText = "#root div:nth-child(1) > label";
    private String yesRadioBtn = "#yesRadio";
    private String impressiveRadioText = "#root div:nth-child(2) > label";
    private String impressiveRadioBtn = "#impressiveRadio";
    private String noRadioText = "#root  div:nth-child(3) > label";

    private String noRadioBtn = "#noRadio";
    private String result = "#root div:nth-child(2) > p";


    // Initialisation
    public RadioButtonPage(Page page) {
        super(page);
    }

    @Override
    public String getUrl() {
        return super.getUrl() + "radio-button";
    }

    // Getters
    public String getYesRadioText() {
        return yesRadioText;
    }

    public String getYesRadioBtn() {
        return yesRadioBtn;
    }

    public String getImpressiveRadioText() {
        return impressiveRadioText;
    }

    public String getImpressiveRadioBtn() {
        return impressiveRadioBtn;
    }

    public String getNoRadioText() {
        return noRadioText;
    }

    public String getNoRadioBtn() {
        return noRadioBtn;
    }

    public String getResult() {
        return result;
    }

    // Methods

    public void clickYesRadioText() {
        page.locator(getYesRadioText()).click();
    }

    public void clickYesRadioBtn() {
        page.locator(getYesRadioBtn()).click();
    }

    public void clickImpressiveRadioBtn() {
        page.locator(getImpressiveRadioBtn()).click();
    }

    public void clickImpressiveRadioText() {
        page.locator(getImpressiveRadioText()).click();
    }


    // Asserts
    public void checkResultClick(String expectedText) {
        assertThat(page.locator(getResult())).containsText(expectedText);
    }

    public void checkNoRadioBtnIsDisabled() {
        assertThat(page.locator(getNoRadioBtn())).isDisabled();
    }

}
