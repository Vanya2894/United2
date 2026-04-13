package tests;

import Pages.*;
import Pages.Elements.RadioButtonPage;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.WaitUntilState;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class TryNewTest {

    Playwright playwright = Playwright.create();
    Browser browser = playwright.chromium().launch(new BrowserType
            .LaunchOptions()
            .setHeadless(false)
            .setSlowMo(250));
    Page page = browser.newPage();
    BasePage radioButton = new RadioButtonPage();


    @Test
    public void testForClickToRadioButton() {
        page.navigate(radioButton.getUrl(), new Page
                .NavigateOptions()
                .setWaitUntil(WaitUntilState
                        .DOMCONTENTLOADED));

        String yesRadioText = "#root div:nth-child(1) > label";
        String yesRadioBtn = "#yesRadio";
        String impressiveRadioText = "#root div:nth-child(2) > label";
        String impressiveRadioBtn = "#impressiveRadio";
        String noRadioText = "#root  div:nth-child(3) > label";
        String noRadioBtn = "#noRadio";
        String result = "#root div:nth-child(2) > p";


        page.click(yesRadioText);
        assertThat(page.locator(result)).hasText("You have selected Yes");
        page.click(impressiveRadioBtn);
        assertThat(page.locator(result)).hasText("You have selected Impressive");
        page.click(yesRadioBtn);
        assertThat(page.locator(result)).hasText("You have selected Yes");
        page.click(impressiveRadioText);
        assertThat(page.locator(result)).hasText("You have selected Impressive");


        browser.close();
    }

}
