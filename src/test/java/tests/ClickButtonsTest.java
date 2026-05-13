package tests;

import Pages.Elements.ButtonsPage;
import io.qameta.allure.Allure;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ClickButtonsTest extends BaseTest {

    private final String DOUBLE_MASSEGE_TEXT = "You have done a double click";
    private final String RIGHT_MASSEGE_TEXT = "You have done a right click";
    private final String DNAMIC_MASSEGE_TEXT = "You have done a dynamic click";

    ButtonsPage buttonsPage;

    @BeforeEach
    void initPage() {
        buttonsPage = new ButtonsPage(page);
    }

    @Test
    public void testDoubleClick() {
        navigateTo(buttonsPage);
        page.setDefaultTimeout(1000);

        Allure.step("Проверяем, что кнопки на месте и отсутствуют надписи", () -> {
            assertThat(page.locator(buttonsPage.getDoubleClickButton())).isEnabled();
            assertThat(page.locator(buttonsPage.getRightClickButton())).isEnabled();
            assertThat(page.locator(buttonsPage.getClickButton())).isEnabled();
            assertThat(page.locator(buttonsPage.getDoubleClickMessege())).isHidden();
            assertThat(page.locator(buttonsPage.getRightClickMessage())).not().isVisible();
            assertThat(page.locator(buttonsPage.getClickMassege())).isHidden();

        });

        Allure.step("Кликаем по кнопке DoubleClickButton", () -> {
            page.reload();
            page.locator(buttonsPage.getDoubleClickButton()).dblclick();
            assertThat(page.locator(buttonsPage.getDoubleClickMessege())).hasText(DOUBLE_MASSEGE_TEXT);
            assertThat(page.locator(buttonsPage.getRightClickButton())).isEnabled();
            assertThat(page.locator(buttonsPage.getClickButton())).isEnabled();
            assertThat(page.locator(buttonsPage.getRightClickMessage())).not().isVisible();
            assertThat(page.locator(buttonsPage.getClickMassege())).isHidden();

        });

        Allure.step("Кликаем по кнопке RightClickButton", () -> {
            page.reload();
            page.locator(buttonsPage.getRightClickButton()).click(new Locator.ClickOptions().setButton(MouseButton.RIGHT));
            assertThat(page.locator(buttonsPage.getRightClickMessage())).hasText(RIGHT_MASSEGE_TEXT);
            assertThat(page.locator(buttonsPage.getDoubleClickMessege())).not().isVisible();
            assertThat(page.locator(buttonsPage.getClickMassege())).isHidden();
        });

        Allure.step("Кликаем по кнопке ClickButton", () -> {
            page.reload();
            page.locator(buttonsPage.getClickButton()).click();
            assertThat(page.locator(buttonsPage.getClickMassege())).hasText(DNAMIC_MASSEGE_TEXT);
            assertThat(page.locator(buttonsPage.getDoubleClickMessege())).not().isVisible();
            assertThat(page.locator(buttonsPage.getRightClickMessage())).isHidden();
        });

        Allure.step("Кликаем все 3 кнопки. Проверяем все 3 надписи", () -> {
            page.reload();
            page.locator(buttonsPage.getDoubleClickButton()).dblclick();
            page.locator(buttonsPage.getRightClickButton()).click(new Locator.ClickOptions().setButton(MouseButton.RIGHT));
            page.locator(buttonsPage.getClickButton()).click();
            assertThat(page.locator(buttonsPage.getDoubleClickMessege())).hasText(DOUBLE_MASSEGE_TEXT);
            assertThat(page.locator(buttonsPage.getRightClickMessage())).hasText(RIGHT_MASSEGE_TEXT);
            assertThat(page.locator(buttonsPage.getClickMassege())).hasText(DNAMIC_MASSEGE_TEXT);
        });


    }


}
