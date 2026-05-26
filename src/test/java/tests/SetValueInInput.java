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
            textBoxPage.checkNameResponse(NAME);
            textBoxPage.checkEmailResponse(EMAIL);
            textBoxPage.checkCurrentAddressResponse(CURRENT_ADDRES);
            textBoxPage.checkPermanentAddressResponse(PERMANENT_ADDRES);
        });

        Allure.step("Заполнение только имени текстовых полей", () -> {
            page.reload();
            textBoxPage.fillAndSubmitValueInTextBox(page, NAME);
            textBoxPage.checkNameResponse(NAME);
            textBoxPage.checkHiddenEmailResponse();
            textBoxPage.checkHiddenCurrentAddressResponse();
            textBoxPage.checkHiddenPermanentAddressResponse();
        });

        Allure.step("Заполнение имени и электронной почты текстовых полей", () -> {
            page.reload();
            textBoxPage.fillAndSubmitValueInTextBox(page, NAME, EMAIL);
            textBoxPage.checkNameResponse(NAME);
            textBoxPage.checkEmailResponse(EMAIL);
            textBoxPage.checkHiddenCurrentAddressResponse();
            textBoxPage.checkHiddenPermanentAddressResponse();
        });

        Allure.step("Заполнение имя, электронная почта и адрес текстовых полей", () -> {
            textBoxPage.fillAndSubmitValueInTextBox(page, NAME, EMAIL, CURRENT_ADDRES);
            textBoxPage.checkNameResponse(NAME);
            textBoxPage.checkEmailResponse(EMAIL);
            textBoxPage.checkCurrentAddressResponse(CURRENT_ADDRES);
            textBoxPage.checkHiddenPermanentAddressResponse();
        });


    }
}

