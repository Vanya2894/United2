package Pages.Elements;

import Pages.BasePage;
import com.microsoft.playwright.Page;

public class TextBoxPage extends BasePage {
    private String userNameinput = "#userName";
    private String userEmailinput = "#userEmail";
    private String currentAddressInput = "#currentAddress";
    private String PermanentAddressInput = "#permanentAddress";
    private String submitButton = "#submit";
    public String nameResponse = "#name";
    public String emailResponse = "#email";
    public String currentAddressResponse = "p#currentAddress";
    public String permanentAddressResponse = "p#permanentAddress";

    public TextBoxPage(Page page) {
        super(page);
    }


    @Override
    public String getUrl() {
        return super.getUrl() + "text-box";
    }

    public void fillAndSubmitValueInTextBox(Page page, String userName, String userEmail, String currentAddress, String PermanentAddress) {
        page.locator(userNameinput).fill(userName);
        page.locator(userEmailinput).fill(userEmail);
        page.locator(currentAddressInput).fill(currentAddress);
        page.locator(PermanentAddressInput).fill(PermanentAddress);
        page.locator(submitButton).click();
    }


}
