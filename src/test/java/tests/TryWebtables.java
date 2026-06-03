package tests;

import Pages.Elements.Webtables;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;

public class TryWebtables extends BaseTest {

    private final String CHENGE_TEXT = "another_value";
    private final String PAGE1OF1 = "Page 1 of 1";
    private final String PAGE1OF2 = "Page 1 of 2";
    private final String PAGE1OF3 = "Page 1 of 3";
    private final String PAGE2OF3 = "Page 2 of 3";
    private final String PAGE3OF3 = "Page 3 of 3";

    private Webtables webtables;


    @BeforeEach
    void initPage() {
        webtables = new Webtables(page);
    }


    @Epic("Веб-интерфейс")
    @Test
    public void ThyToChangeValueTest() {

        navigateTo(webtables);

        Allure.step("Редактирование и удаление строки таблицы", () -> {
            webtables.createTableString();
            webtables.editRecordClick();
            webtables.firstNameValueFill(CHENGE_TEXT);
            webtables.submitBtnClick();
            webtables.checkCounStringsTabl(4);
            webtables.checkFirstStringTable(CHENGE_TEXT);
            webtables.deleteRecordSecondStringClick();
            webtables.checkCounStringsTabl(3); // Баг системы. Должно быть три строки. Но отображается 2.
        });


        Allure.step("Поиск по таблице", () -> {
            webtables.searchValueFill(CHENGE_TEXT);
            webtables.checkCounStringsTabl(1);   // Баг системы. Должна быть одна строка. Но отображается 0.
            webtables.checkFirstStringTable(CHENGE_TEXT);   // Из-за бага не отображается строка
            webtables.clearSearchValue();
        });


    }

    @Story("Проверка пагинации на странице")
    @Test
    public void pagination() {

        Allure.step("Создаем 20 записей таблицы", () -> {
            navigateTo(webtables);
            for (int i = 0; i < 20; i++) {
                webtables.createTableString();
            }
        });

        Allure.step("Переход по страницам по кнопкам Next/Last/Previous/First", () -> {
            webtables.checkCountOfPage(PAGE1OF3);
            webtables.nextButtonClick();
            webtables.checkCountOfPage(PAGE2OF3);
            webtables.lastButtonClick();
            webtables.checkCountOfPage(PAGE3OF3);
            webtables.previousButtonClick();
            webtables.checkCountOfPage(PAGE2OF3);
            webtables.firstButtonClick();
            webtables.checkCountOfPage(PAGE1OF3);
        });

        Allure.step("Меняем отображение записей на одной странице", () -> {
            webtables.selectFormControlFill(20);
            webtables.checkCounStringsTabl(20);
            webtables.checkCountOfPage(PAGE1OF2);
            webtables.selectFormControlFill(30);
            webtables.checkCounStringsTabl(23);
            webtables.checkCountOfPage(PAGE1OF1);
            webtables.selectFormControlFill(10);
            webtables.checkCounStringsTabl(10);
            webtables.checkCountOfPage(PAGE1OF3);
        });

    }


}


