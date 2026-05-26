package Pages.Elements;

import Pages.BasePage;
import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class TextBoxPage extends BasePage {

    // Locators
    private String userNameinput = "#userName";
    private String userEmailinput = "#userEmail";
    private String currentAddressInput = "#currentAddress";
    private String PermanentAddressInput = "#permanentAddress";
    private String submitButton = "#submit";
    public String nameResponse = "#name";
    public String emailResponse = "#email";
    public String currentAddressResponse = "p#currentAddress";
    public String permanentAddressResponse = "p#permanentAddress";


    // Initialisation
    public TextBoxPage(Page page) {
        super(page);
    }

    @Override
    public String getUrl() {
        return super.getUrl() + "text-box";
    }


    // Methods
        public void fillAndSubmitValueInTextBox(Page page, String userName, String userEmail, String currentAddress, String PermanentAddress) {
        page.locator(userNameinput).fill(userName);
        page.locator(userEmailinput).fill(userEmail);
        page.locator(currentAddressInput).fill(currentAddress);
        page.locator(PermanentAddressInput).fill(PermanentAddress);
        page.locator(submitButton).click();
    }

    public void fillAndSubmitValueInTextBox(Page page, String userName, String userEmail, String currentAddress) {
        page.locator(userNameinput).fill(userName);
        page.locator(userEmailinput).fill(userEmail);
        page.locator(currentAddressInput).fill(currentAddress);
        page.locator(submitButton).click();
    }

    public void fillAndSubmitValueInTextBox(Page page, String userName, String userEmail) {
        page.locator(userNameinput).fill(userName);
        page.locator(userEmailinput).fill(userEmail);
        page.locator(submitButton).click();
    }

    public void fillAndSubmitValueInTextBox(Page page, String userName) {
        page.locator(userNameinput).fill(userName);
        page.locator(submitButton).click();
    }


    // Asserts
    public void checkNameResponse(String expectedText){
        assertThat(page.locator(nameResponse)).containsText("Name:" + expectedText);
    }
    public void checkEmailResponse(String expectedText){
        assertThat(page.locator(emailResponse)).containsText("Email:" + expectedText);
    }
        public void checkCurrentAddressResponse(String expectedText){
        assertThat(page.locator(currentAddressResponse)).containsText("Current Address :" + expectedText);
    }
        public void checkPermanentAddressResponse(String expectedText){
        assertThat(page.locator(permanentAddressResponse)).containsText("Permananet Address :" + expectedText);
    }


    public void checkHiddenNameResponse(){
        assertThat(page.locator(nameResponse)).isHidden();
    }
    public void checkHiddenEmailResponse(){
        assertThat(page.locator(emailResponse)).isHidden();
    }
    public void checkHiddenCurrentAddressResponse(){
        assertThat(page.locator(currentAddressResponse)).isHidden();
    }
    public void checkHiddenPermanentAddressResponse(){
        assertThat(page.locator(permanentAddressResponse)).isHidden();
    }






}
