package tests;

import Pages.Elements.Webtables;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class TryWebtables extends BaseTest{

    private final String CHENGE_TEXT = "A ИЗМЕНЕНО!!!";
    private final String PAGE1OF1 = "Page 1 of 1";
    private final String PAGE1OF2 = "Page 1 of 2";
    private final String PAGE1OF3 = "Page 1 of 3";
    private final String PAGE2OF3 = "Page 2 of 3";
    private final String PAGE3OF3 = "Page 3 of 3";

    private final String SHOW10 = "Show 10";
    private final String SHOW20 = "Show 20";
    private final String SHOW30 = "Show 30";

    private Webtables webtables;


    @BeforeEach
    void initPage() {
        webtables = new Webtables(page);
    }


    @Epic("Веб-интерфейс")
    @Feature("Авторизация")
    @Test
    public void ThyToChangeValueTest() {

        navigateTo(webtables);

        Allure.step("Редактирование и удаление строки таблицы", () -> {
            page.locator(webtables.getEditRecord()).click();
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("First Name")).fill(CHENGE_TEXT);
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Submit")).click();
            assertThat(page.locator(webtables.getCounStringsTabl())).hasCount(4);
            assertThat(page.locator(webtables.getFirstStringTable())).hasText(CHENGE_TEXT);
//            page.locator("#delete-record-3 > svg > path").click();
//              ПОНЯТЬ КАК ПРОВЕРИТЬ!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//            assertThat(page.locator("#root table tr")).hasCount(3);
        });


        Allure.step("Поиск по таблице", () -> {
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Type to search")).fill(CHENGE_TEXT);
            assertThat(page.locator(webtables.getCounStringsTabl())).hasCount(2);
            assertThat(page.locator(webtables.getFirstStringTable())).hasText(CHENGE_TEXT);
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Type to search")).clear();
        });


    }

    @Test
    public void pagination() {

        Allure.step("Проверка пагинации на странице", () -> {

            navigateTo(webtables);

            for (int i = 0; i < 20; i++) {
                webtables.createTableString();
            }
            assertThat(page.locator(webtables.getCountOfPage())).hasText(PAGE1OF3);
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")).click();
            assertThat(page.locator(webtables.getCountOfPage())).hasText(PAGE2OF3);
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Last")).click();
            assertThat(page.locator(webtables.getCountOfPage())).hasText(PAGE3OF3);
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Previous")).click();
            assertThat(page.locator(webtables.getCountOfPage())).hasText(PAGE2OF3);
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("First")).click();
            assertThat(page.locator(webtables.getCountOfPage())).hasText(PAGE1OF3);
            page.locator(webtables.getSelectFormControl()).selectOption(SHOW20);
            assertThat(page.locator(webtables.getCounStringsTabl())).hasCount(21);
            assertThat(page.locator(webtables.getCountOfPage())).hasText(PAGE1OF2);
            page.locator(webtables.getSelectFormControl()).selectOption(SHOW30);
            assertThat(page.locator(webtables.getCounStringsTabl())).hasCount(24);
            assertThat(page.locator(webtables.getCountOfPage())).hasText(PAGE1OF1);
            page.locator(webtables.getSelectFormControl()).selectOption(SHOW10);
            assertThat(page.locator(webtables.getCounStringsTabl())).hasCount(11);
            assertThat(page.locator(webtables.getCountOfPage())).hasText(PAGE1OF3);
        });

    }


}


