package tests;

import Pages.Elements.Webtables;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class TryWebtables {

    Playwright playwright = Playwright.create();
    Browser browser = playwright.chromium()
            .launch(new BrowserType
                    .LaunchOptions()
                    .setHeadless(false)
                    .setArgs(List.of("--start-maximized"))
                    .setSlowMo(150));
    BrowserContext context = browser.newContext(new Browser.NewContextOptions()
            .setViewportSize(null));

    Page page = context.newPage();
    Webtables webtables = new Webtables();

    @Epic("Веб-интерфейс")
    @Feature("Авторизация")
    @Test
    public void ThyToChangeValueTest() {
        page.navigate(webtables.getUrl(), new Page
                .NavigateOptions()
                .setWaitUntil(WaitUntilState
                        .DOMCONTENTLOADED));

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

        page.close();

    }

    @Test
    public void pagination() {

        Allure.step("Пагинация", () -> {

            page.navigate(webtables.getUrl(), new Page
                    .NavigateOptions()
                    .setWaitUntil(WaitUntilState
                            .DOMCONTENTLOADED));

            for (int i = 0; i < 20; i++) {
                createTableString();
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
            page.close();
        });
        browser.close();

    }

    public static String generateRandomString(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }
        return sb.toString();
    }

    public static String randomInt() {
        String value = Integer.toString(ThreadLocalRandom.current().nextInt(1, 1001));
        return value;
    }


    public void createTableString() {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("First Name")).fill(generateRandomString(10));
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Last Name")).fill(generateRandomString(10));
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("name@example.com")).fill(generateRandomString(3) + "@" + generateRandomString(5) + ".ru");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Age")).fill(randomInt());
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Salary")).fill(randomInt());
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Department")).fill(generateRandomString(10));
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Submit")).click();
    }
}


