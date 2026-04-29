package tests;

import Pages.BasePage;
import Pages.Elements.CheckboxPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CheckboxesClick extends BaseTest {

    private CheckboxPage checkboxPage;

    @BeforeEach
    void initPage() {
        checkboxPage = new CheckboxPage(page);
    }


    @Test
    public void testCheckboxesClick() {

        navigateTo(checkboxPage);

        checkboxPage.clickPlusRootBtnClose();
        checkboxPage.clickPlusDecktop();
        checkboxPage.clickPlusDocuments();
        checkboxPage.clickPlusWorkSpase();
        checkboxPage.clickPlusOffice();
        checkboxPage.clickPlusDownload();
        checkboxPage.clickCheckBoxDecktop();
        assertThat(page.locator(checkboxPage.getCheckboxResult())).hasText("You have selected :" + "desktop" + "notes" + "commands");
        checkboxPage.clickCheckBoxDocuments();
        assertThat(page.locator(checkboxPage.getCheckboxResult())).hasText("You have selected :" + "desktop" + "notes" + "commands" + "documents" + "workspace" + "office" + "react" + "angular" + "veu" + "public" + "private" + "classified" + "general");
        checkboxPage.clickCheckBoxDownload();
        assertThat(page.locator(checkboxPage.getCheckboxResult())).hasText("You have selected :" + "desktop" + "notes" + "commands" + "documents" + "workspace" + "office" + "react" + "angular" + "veu" + "public" + "private" + "classified" + "general" + "downloads" + "wordFile" + "excelFile" + "home");
        checkboxPage.clickPlusRootBtnOpen();
        checkboxPage.clickPlusRootBtnClose();
        checkboxPage.clickCheckBoxHome();

        String text = page.locator("#root div.col-12.mt-4.col-md-6.col-xl-7 > div:nth-child(3)").textContent();
        assert text.isEmpty();

    }
}
