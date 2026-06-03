package tests;

import Pages.BookStoreApplication.LoginPage;
import Pages.Elements.ButtonsPage;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Login extends BaseTest{

    private final String INVALIT_USERNAME = "rjnv";
    private final String INVALIT_PASSWORD = "112233";

    LoginPage loginPage;

    @BeforeEach
    void initPage() {
        loginPage = new LoginPage(page);
    }

    @Test
    public void testInvalidFill() {
        navigateTo(loginPage);

        Allure.step("Некорректный логин и пароль ", () -> {
            loginPage.userNameFill(INVALIT_USERNAME);
            loginPage.passwordFill(INVALIT_PASSWORD);
            loginPage.loginBtnClick();
            loginPage.checkResultText();
        });

    }

}
