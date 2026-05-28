package tests;

import Pages.Elements.ButtonsPage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.MouseButton;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ClickButtonsTest extends BaseTest {


    ButtonsPage buttonsPage;

    @BeforeEach
    void initPage() {
        buttonsPage = new ButtonsPage(page);
    }

    @Test
    public void testDoubleClick() {
        navigateTo(buttonsPage);

        Allure.step("Проверяем, что кнопки на месте и отсутствуют надписи", () -> {
            buttonsPage.checkButtonsExistAndLabelsAbsent();
        });

        Allure.step("Единожды кликаем по кнопке DoubleClickButton и проверяем, что текст не появился", () -> {
            page.reload();
            buttonsPage.onceClickOnDoubleClickButton();
            buttonsPage.checkHaveNoTextAfterClick();
        });

        Allure.step("Дважды кликаем по кнопке DoubleClickButton и проверяем, что появился текст", () -> {
            page.reload();
            buttonsPage.doubleClickOnDoubleClickButton();
            buttonsPage.checkAfterClickOnDoubleClickButton();
        });

        Allure.step("Кликаем по кнопке RightClickButton левой кнопкой мыши и проверяем, что текст не появился", () -> {
            page.reload();
            buttonsPage.leftClickToRighhtClickButton();
            buttonsPage.checkHaveNoTextAfterClick();
        });

        Allure.step("Кликаем по кнопке RightClickButton и проверяем, что появился текст", () -> {
            page.reload();
            buttonsPage.rightClickToRighhtClickButton();
            buttonsPage.checkAfterClickRighhtClickButton();
        });


        Allure.step("Кликаем по кнопке ClickButton правой кнопкой мыши и проверяем, что текст не появился", () -> {
            page.reload();
            buttonsPage.rightClickToClickButton();
            buttonsPage.checkHaveNoTextAfterClick();
        });


        Allure.step("Кликаем по кнопке ClickButton и проверяем, что появился текст", () -> {
            page.reload();
            buttonsPage.clickToClickButton();
            buttonsPage.checkAfterClickClickButton();
        });

        Allure.step("Кликаем все 3 кнопки. Проверяем все 3 надписи", () -> {
            page.reload();
            buttonsPage.doubleClickOnDoubleClickButton();
            buttonsPage.rightClickToRighhtClickButton();
            buttonsPage.clickToClickButton();
            buttonsPage.checkAfterAllButtonsClick();
        });


    }


}
