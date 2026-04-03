import Pages.BasePage;
import Pages.CheckboxPage;
import Pages.TextBoxPage;
import com.microsoft.playwright.*;
import com.microsoft.playwright.assertions.LocatorAssertions;
import com.microsoft.playwright.options.*;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Tests {
    Playwright playwright = Playwright.create();
    Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(250));
    Page page = browser.newPage();
    BasePage textBoxPage = new TextBoxPage();
    BasePage checkboxPage = new CheckboxPage();

    @Test
    public void testForSetValueInInputsOnElements() {
        page.navigate(textBoxPage.getUrl(), new Page.NavigateOptions()
                .setWaitUntil(WaitUntilState.DOMCONTENTLOADED));

        assertThat(page).hasTitle("demosite");

        String userNameinput = "#userName";
        String userEmailinput = "#userEmail";
        String currentAddressInput = "#currentAddress";
        String PermanentAddressInput = "#permanentAddress";
        String submitButton = "#submit";
        String nameResponse = "#name";
        String emailResponse = "#email";
        String currentAddressResponse = "p#currentAddress";
        String permanentAddressResponse = "p#permanentAddress";

        page.locator(userNameinput).fill("Ivan Khlypalo");
        page.locator(userEmailinput).fill("Ivan-unoverse@yandex.ru");
        page.locator(currentAddressInput).fill("SPB, Krasnogo Kursanta, 25");
        page.locator(PermanentAddressInput).fill("RRRRRRRRRRRRRRRRR");
        page.locator(submitButton).click();
        assertThat(page.locator(nameResponse)).hasText("Name:Ivan Khlypalo");
        assertThat(page.locator(emailResponse)).hasText("Email:Ivan-unoverse@yandex.ru");
        assertThat(page.locator(currentAddressResponse)).hasText("Current Address :SPB, Krasnogo Kursanta, 25");
        assertThat(page.locator(permanentAddressResponse)).hasText("Permananet Address :RRRRRRRRRRRRRRRRR");

        browser.close();
    }

    @Test
    public void testCheckboxesClick(){

        page.navigate(checkboxPage.getUrl(), new Page.NavigateOptions()
                .setWaitUntil(WaitUntilState.DOMCONTENTLOADED));

        String plusRootBtnClose = "#root span.rc-tree-switcher.rc-tree-switcher_close";
        String plusRootBtnOpen = "#root  div:nth-child(1) > span.rc-tree-switcher.rc-tree-switcher_open";
        String plusDecktop = "#root div:nth-child(2) > span.rc-tree-switcher.rc-tree-switcher_close";
        String plusDocuments = "#root div:nth-child(5) > span.rc-tree-switcher.rc-tree-switcher_close";
        String plusWorkSpase = "#root div:nth-child(6) > span.rc-tree-switcher.rc-tree-switcher_close";
        String plusOffice = "#root div:nth-child(10) > span.rc-tree-switcher.rc-tree-switcher_close";
        String plusDownload = "#root div:nth-child(15) > span.rc-tree-switcher.rc-tree-switcher_close";
        String checkBoxHome = "#root div:nth-child(1) > span.rc-tree-checkbox";
        String checkBoxDecktop = "#root div:nth-child(2) > span.rc-tree-checkbox";
        String checkBoxDocuments = "#root div:nth-child(5) > span.rc-tree-checkbox";
        String checkBoxDownload = "#root  div:nth-child(15) > span.rc-tree-checkbox";
        String checkboxResult = "#result";

        page.click(plusRootBtnClose);
        page.click(plusDecktop);
        page.click(plusDocuments);
        page.click(plusWorkSpase);
        page.click(plusOffice);
        page.click(plusDownload);
        page.click(checkBoxDecktop);
        assertThat(page.locator(checkboxResult)).hasText("You have selected :" + "desktop" + "notes" + "commands");
        page.click(checkBoxDocuments);
        assertThat(page.locator(checkboxResult)).hasText("You have selected :" + "desktop" + "notes" + "commands" + "documents" + "workspace" + "office" + "react" + "angular" + "veu" + "public" + "private" + "classified" + "general");
        page.click(checkBoxDownload);
        assertThat(page.locator(checkboxResult)).hasText("You have selected :" + "desktop" + "notes" + "commands" + "documents" + "workspace" + "office" + "react" + "angular" + "veu" + "public" + "private" + "classified" + "general" + "downloads" + "wordFile" + "excelFile" + "home");
        page.click(plusRootBtnOpen);
        page.click(plusRootBtnClose);
        page.click(checkBoxHome);


        String text = page.locator("#root div.col-12.mt-4.col-md-6.col-xl-7 > div:nth-child(3)").textContent();
        assert text.isEmpty();

        browser.close();
    }


}
