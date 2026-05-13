package tests;

import Pages.Elements.*;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class SetValueInInput extends BaseTest {

    private final String NAME = "Ivan Khlypalo";
    private final String EMAIL = "Ivan-unoverse@yandex.ru";
    private final String CURRENT_ADDRES = "SPB, Krasnogo Kursanta, 25";
    private final String PERMANENT_ADDRES = "RRRRRRRRRRRRRRRRR";


    private TextBoxPage textBoxPage;

    @BeforeEach
    void initPage() {
        textBoxPage = new TextBoxPage(page);
    }

    @Test
    public void testForSetValueInInputsOnElements() {
        navigateTo(textBoxPage);
        assertThat(page).hasTitle("demosite");

        Allure.step("Заполнение всех текстовых полей", () -> {
            textBoxPage.fillAndSubmitValueInTextBox(page, NAME, EMAIL, CURRENT_ADDRES, PERMANENT_ADDRES);
            assertThat(page.locator(textBoxPage.nameResponse)).hasText("Name:" + NAME);
            assertThat(page.locator(textBoxPage.emailResponse)).hasText("Email:" + EMAIL);
            assertThat(page.locator(textBoxPage.currentAddressResponse)).hasText("Current Address :" + CURRENT_ADDRES);
            assertThat(page.locator(textBoxPage.permanentAddressResponse)).hasText("Permananet Address :" + PERMANENT_ADDRES);
        });

        Allure.step("Заполнение только имени текстовых полей", () -> {
            page.reload();
            textBoxPage.fillAndSubmitValueInTextBox(page, NAME);
            assertThat(page.locator(textBoxPage.nameResponse)).hasText("Name:" + NAME);
            assertThat(page.locator(textBoxPage.emailResponse)).isHidden();
            assertThat(page.locator(textBoxPage.currentAddressResponse)).not().isVisible();
            assertThat(page.locator(textBoxPage.permanentAddressResponse)).not().isVisible();
        });

        Allure.step("Заполнение имени и электронной почты текстовых полей", () -> {
            page.reload();
            textBoxPage.fillAndSubmitValueInTextBox(page, NAME, EMAIL);
            assertThat(page.locator(textBoxPage.nameResponse)).hasText("Name:" + NAME);
            assertThat(page.locator(textBoxPage.emailResponse)).hasText("Email:" + EMAIL);
            assertThat(page.locator(textBoxPage.currentAddressResponse)).isHidden();
            assertThat(page.locator(textBoxPage.permanentAddressResponse)).not().isVisible();
        });

        Allure.step("Заполнение имя, электронная почта и адрес текстовых полей", () -> {
            textBoxPage.fillAndSubmitValueInTextBox(page, NAME, EMAIL, CURRENT_ADDRES);
            assertThat(page.locator(textBoxPage.nameResponse)).hasText("Name:" + NAME);
            assertThat(page.locator(textBoxPage.emailResponse)).hasText("Email:" + EMAIL);
            assertThat(page.locator(textBoxPage.currentAddressResponse)).hasText("Current Address :" + CURRENT_ADDRES);
            assertThat(page.locator(textBoxPage.permanentAddressResponse)).isHidden();
        });


    }
}

