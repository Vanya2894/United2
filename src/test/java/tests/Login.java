package tests;

import Pages.BookStoreApplication.LoginPage;
import Pages.Elements.ButtonsPage;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Login extends BaseTest{


    private final String VALID_USERNAME = "rjnv";
    private final String VALID_PASSWORD = "112233";
    private final String INVALID_USERNAME = "rjnv";
    private final String INVALID_PASSWORD = "112233";

    LoginPage loginPage;

    @BeforeEach
    void initPage() {
        loginPage = new LoginPage(page);
    }

    @Test
    public void testInvalidFill() {
        navigateTo(loginPage);

        Allure.step("Некорректный логин и пароль ", () -> {
            loginPage.userNameFill(INVALID_USERNAME);
            loginPage.passwordFill(INVALID_PASSWORD);
            loginPage.loginBtnClick();
            loginPage.checkResultText();
        });

        Allure.step("Корректный логин и пароль ", () -> {
            loginPage.userNameFill(VALID_USERNAME);
            loginPage.passwordFill(VALID_PASSWORD);
            loginPage.loginBtnClick();
            loginPage.checkResultText();
        });

    }

}
