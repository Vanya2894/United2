package tests;

import Pages.Elements.RadioButtonPage;
import org.junit.jupiter.api.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class TryNewTest extends BaseTest{

    private RadioButtonPage radioButton;

    @BeforeEach
    void initPage() {
        radioButton = new RadioButtonPage(page);
    }


    @Test
    public void testForClickToRadioButton() {
        navigateTo(radioButton);

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

    }

}
