package tests;

import Pages.Elements.CheckboxPage;
import io.qameta.allure.Allure;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class CheckboxesClick extends BaseTest {

    // Variables
    private final String DESKTOP_NOTES_COMMAND_SHORT = "You have selected :" + "desktop" + "notes" + "commands";
    private final String DESKTOP_NOTES_COMMAND_MEDIUM = "You have selected :" + "desktop" + "notes" + "commands" + "documents" + "workspace" + "office" + "react" + "angular" + "veu" + "public" + "private" + "classified" + "general";
    private final String DESKTOP_NOTES_COMMAND_LONG = "You have selected :" + "desktop" + "notes" + "commands" + "documents" + "workspace" + "office" + "react" + "angular" + "veu" + "public" + "private" + "classified" + "general" + "downloads" + "wordFile" + "excelFile" + "home";

    private CheckboxPage checkboxPage;

    @BeforeEach
    void initPage() {
        checkboxPage = new CheckboxPage(page);
    }

    @Story("Проверяем работу чек-боксов")
    @Test
    public void testCheckboxesClick() {

        navigateTo(checkboxPage);
        Allure.step("Раскрываем корневой узел", () -> {
            checkboxPage.clickPlusRootBtnClose();
        });

        Allure.step("Раскрываем узел Decktop", () -> {
            page.waitForSelector(checkboxPage.getPlusDecktop());
            checkboxPage.clickPlusDecktop();
        });

        Allure.step("Раскрываем узел Documents", () -> {
            page.waitForSelector(checkboxPage.getPlusDocuments());
            checkboxPage.clickPlusDocuments();
        });

        Allure.step("Раскрываем узел WorkSpase", () -> {
            page.waitForSelector(checkboxPage.getPlusWorkSpase());
            checkboxPage.clickPlusWorkSpase();
        });

        Allure.step("Раскрываем узел Office", () -> {
            page.waitForSelector(checkboxPage.getPlusOffice());
            checkboxPage.clickPlusOffice();
        });

        Allure.step("Раскрываем узел Download", () -> {
            page.waitForSelector(checkboxPage.getPlusDownload());
            checkboxPage.clickPlusDownload();
        });

        Allure.step("Активируем чек-бокс Decktop", () -> {
            checkboxPage.clickCheckBoxDecktop();
        });

        Allure.step("Проверяем результирующий текст", () -> {
            checkboxPage.checkResultText(DESKTOP_NOTES_COMMAND_SHORT);
        });

        Allure.step("Активируем чек-бокс Documents", () -> {
            checkboxPage.clickCheckBoxDocuments();
        });

        Allure.step("Проверяем результирующий текст", () -> {
            checkboxPage.checkResultText(DESKTOP_NOTES_COMMAND_MEDIUM);
        });

        Allure.step("Активируем чек-бокс Download", () -> {
            checkboxPage.clickCheckBoxDownload();
        });

        Allure.step("Проверяем результирующий текст", () -> {
            checkboxPage.checkResultText(DESKTOP_NOTES_COMMAND_LONG);
        });

        Allure.step("Скрываем корневой узел", () -> {
            checkboxPage.clickPlusRootBtnOpen();
        });

        Allure.step("Раскрываем корневой узел", () -> {
            checkboxPage.clickPlusRootBtnClose();
        });

        Allure.step("Снимаем флаг с родительского узла", () -> {
            checkboxPage.clickCheckBoxHome();
        });

        Allure.step("Проверяем, что результирующий текст отсутствует", () -> {
            checkboxPage.checkResultTextNotPresent();
        });

    }
}
