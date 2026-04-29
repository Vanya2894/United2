package tests;

import Pages.Elements.Webtables;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class TryWebtables extends BaseTest{

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
            page.locator("#edit-record-1 > svg > path").click();
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("First Name")).fill("A ИЗМЕНЕНО!!!");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Submit")).click();
            assertThat(page.locator("#root table tr")).hasCount(4);
            assertThat(page.locator("#root table > tbody > tr:nth-child(1) > td:nth-child(1)")).hasText("A ИЗМЕНЕНО!!!");
//            page.locator("#delete-record-3 > svg > path").click();
//              ПОНЯТЬ КАК ПРОВЕРИТЬ!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//            assertThat(page.locator("#root table tr")).hasCount(3);
        });


        Allure.step("Поиск по таблице", () -> {
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Type to search")).fill("A ИЗМЕНЕНО!!!");
            assertThat(page.locator("#root  table tr")).hasCount(2);
            assertThat(page.locator("#root tr > td:nth-child(1)")).hasText("A ИЗМЕНЕНО!!!");
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Type to search")).clear();
        });


    }

    @Test
    public void pagination() {

        Allure.step("Пагинация", () -> {

            navigateTo(webtables);

            for (int i = 0; i < 20; i++) {
                webtables.createTableString();
            }
            assertThat(page.locator("#root div.pagination.d-flex.align-items-center.justify-content-between.mt-3 div:nth-child(2)")).hasText("Page 1 of 3");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")).click();
            assertThat(page.locator("#root div.pagination.d-flex.align-items-center.justify-content-between.mt-3 div:nth-child(2)")).hasText("Page 2 of 3");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Last")).click();
            assertThat(page.locator("#root div.pagination.d-flex.align-items-center.justify-content-between.mt-3 div:nth-child(2)")).hasText("Page 3 of 3");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Previous")).click();
            assertThat(page.locator("#root div.pagination.d-flex.align-items-center.justify-content-between.mt-3 div:nth-child(2)")).hasText("Page 2 of 3");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("First")).click();
            assertThat(page.locator("#root div.pagination.d-flex.align-items-center.justify-content-between.mt-3 div:nth-child(2)")).hasText("Page 1 of 3");
            page.locator("select.form-control").selectOption("Show 20");
            assertThat(page.locator("#root  table tr")).hasCount(21);
            assertThat(page.locator("#root div.pagination.d-flex.align-items-center.justify-content-between.mt-3 div:nth-child(2)")).hasText("Page 1 of 2");
            page.locator("select.form-control").selectOption("Show 30");
            assertThat(page.locator("#root  table tr")).hasCount(24);
            assertThat(page.locator("#root div.pagination.d-flex.align-items-center.justify-content-between.mt-3 div:nth-child(2)")).hasText("Page 1 of 1");
            page.locator("select.form-control").selectOption("Show 10");
            assertThat(page.locator("#root  table tr")).hasCount(11);
            assertThat(page.locator("#root div.pagination.d-flex.align-items-center.justify-content-between.mt-3 div:nth-child(2)")).hasText("Page 1 of 3");
        });

    }


}


