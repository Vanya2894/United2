package Pages.BookStoreApplication;

import Pages.BasePage;
import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginPage extends BasePage {

    //Locators
    private String newUserBtn = "#newUser";
    private String loginBtn = "#login";
    private String userName = "#userName";
    private String password = "#password";
    private String firstname = "#firstname";
    private String lastname = "#lastname";
    private String registerBtn = "#register";
    private String gotologinBtn = "#gotologin";
    private String resultText = "#name";


    public LoginPage(Page page) {
        super(page);
    }

    @Override
    public String getUrl() {
        return super.getUrl() + "login";
    }

    public String getNewUserBtn() {
        return newUserBtn;
    }

    public String getLoginBtn() {
        return loginBtn;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getRegisterBtn() {
        return registerBtn;
    }

    public String getGotologinBtn() {
        return gotologinBtn;
    }

    public String getResultText() {
        return resultText;
    }

    public void userNameFill(String extendName) {
        page.locator(getUserName()).fill(extendName);
    }


    public void passwordFill(String extendPassword) {
        page.locator(getPassword()).fill(extendPassword);
    }


    public void newUserBtnClick() {
        page.locator(getNewUserBtn()).click();
    }

    public void loginBtnClick() {
        page.locator(getLoginBtn()).click();
    }




    public void checkResultText(){
        assertThat(page.locator(getResultText())).containsText("Successes");
    }


}
