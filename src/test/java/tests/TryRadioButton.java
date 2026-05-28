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

        Allure.step("Клик по тексту кнопки 'Yes'", () -> {
            radioButton.clickYesRadioText();
        });

        Allure.step("Проверяем отображение текста", () -> {
            radioButton.checkResultClick(SELECT_YES);
        });

        Allure.step("Клик по кнопке 'Impressive'", () -> {
            radioButton.clickImpressiveRadioBtn();
        });

        Allure.step("Проверяем отображение текста", () -> {
            radioButton.checkResultClick(SELECT_IMPRESSIVE);
        });

        Allure.step("Клик по кнопке 'Yes'", () -> {
            radioButton.clickYesRadioBtn();
        });

        Allure.step("Проверяем отображение текста", () -> {
            radioButton.checkResultClick(SELECT_YES);
        });

        Allure.step("Клик по тексту кнопки 'Impressive'", () -> {
            radioButton.clickImpressiveRadioText();
        });

        Allure.step("Проверяем отображение текста", () -> {
            radioButton.checkResultClick(SELECT_IMPRESSIVE);
        });

        Allure.step("Проверяем что кнопка 'No' не активна", () -> {
            radioButton.checkNoRadioBtnIsDisabled();
        });
    }

}
