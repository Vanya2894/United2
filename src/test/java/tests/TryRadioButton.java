package tests;

import Pages.Elements.RadioButtonPage;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class TryRadioButton extends BaseTest {

    private final String SELECT_YES = "You have selected Yes";
    private final String SELECT_IMPRESSIVE = "You have selected Impressive";


    private RadioButtonPage radioButton;

    @BeforeEach
    void initPage() {
        radioButton = new RadioButtonPage(page);
    }


    @Test
    public void testForClickToRadioButton() {
        navigateTo(radioButton);

        Allure.step("Провверка работы радиокнопок", () -> {
            page.click(radioButton.getYesRadioText());
            assertThat(page.locator(radioButton.getResult())).hasText(SELECT_YES);
            page.click(radioButton.getImpressiveRadioBtn());
            assertThat(page.locator(radioButton.getResult())).hasText(SELECT_IMPRESSIVE);
            page.click(radioButton.getYesRadioBtn());
            assertThat(page.locator(radioButton.getResult())).hasText(SELECT_YES);
            page.click(radioButton.getImpressiveRadioText());
            assertThat(page.locator(radioButton.getResult())).hasText(SELECT_IMPRESSIVE);
        });

    }

}
