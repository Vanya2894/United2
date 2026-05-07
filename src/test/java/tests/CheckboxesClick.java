package tests;

import Pages.BasePage;
import Pages.Elements.CheckboxPage;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CheckboxesClick extends BaseTest {

    private final String DESKTOP_NOTES_COMMAND_SHORT = "You have selected :" + "desktop" + "notes" + "commands";
    private final String DESKTOP_NOTES_COMMAND_MEDIUM = "You have selected :" + "desktop" + "notes" + "commands" + "documents" + "workspace" + "office" + "react" + "angular" + "veu" + "public" + "private" + "classified" + "general";
    private final String DESKTOP_NOTES_COMMAND_LONG = "You have selected :" + "desktop" + "notes" + "commands" + "documents" + "workspace" + "office" + "react" + "angular" + "veu" + "public" + "private" + "classified" + "general" + "downloads" + "wordFile" + "excelFile" + "home";


    private CheckboxPage checkboxPage;

    @BeforeEach
    void initPage() {
        checkboxPage = new CheckboxPage(page);
    }


    @Test
    public void testCheckboxesClick() {

        navigateTo(checkboxPage);
        Allure.step("Проверяем работу чек-боксов", () -> {
            checkboxPage.clickPlusRootBtnClose();
            checkboxPage.clickPlusDecktop();
            checkboxPage.clickPlusDocuments();
            checkboxPage.clickPlusWorkSpase();
            checkboxPage.clickPlusOffice();
            checkboxPage.clickPlusDownload();
            checkboxPage.clickCheckBoxDecktop();
            assertThat(page.locator(checkboxPage.getCheckboxResult())).hasText(DESKTOP_NOTES_COMMAND_SHORT);
            checkboxPage.clickCheckBoxDocuments();
            assertThat(page.locator(checkboxPage.getCheckboxResult())).hasText(DESKTOP_NOTES_COMMAND_MEDIUM);
            checkboxPage.clickCheckBoxDownload();
            assertThat(page.locator(checkboxPage.getCheckboxResult())).hasText(DESKTOP_NOTES_COMMAND_LONG);
            checkboxPage.clickPlusRootBtnOpen();
            checkboxPage.clickPlusRootBtnClose();
            checkboxPage.clickCheckBoxHome();
        });
    }
}
