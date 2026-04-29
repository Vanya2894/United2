package tests;

import Pages.Elements.*;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class SetValueInInput extends BaseTest {

    private TextBoxPage textBoxPage;

    @BeforeEach
    void initPage() {
        textBoxPage = new TextBoxPage(page);
    }

    @Test
    public void testForSetValueInInputsOnElements() {
        navigateTo(textBoxPage);
        assertThat(page).hasTitle("demosite");

        Allure.step("Заполнение текстовых полей", () -> {
            textBoxPage.fillAndSubmitValueInTextBox(page,
                    "Ivan Khlypalo",
                    "Ivan-unoverse@yandex.ru",
                    "SPB, Krasnogo Kursanta, 25",
                    "RRRRRRRRRRRRRRRRR");
            assertThat(page.locator(textBoxPage.nameResponse)).hasText("Name:Ivan Khlypalo");
            assertThat(page.locator(textBoxPage.emailResponse)).hasText("Email:Ivan-unoverse@yandex.ru");
            assertThat(page.locator(textBoxPage.currentAddressResponse)).hasText("Current Address :SPB, Krasnogo Kursanta, 25");
            assertThat(page.locator(textBoxPage.permanentAddressResponse)).hasText("Permananet Address :RRRRRRRRRRRRRRRRR");
        });
    }
}

