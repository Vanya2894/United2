package tests;

import Pages.Elements.Webtables;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import org.junit.jupiter.api.*;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class TryWebtables {

    Playwright playwright = Playwright.create();
    Browser browser = playwright.chromium()
            .launch(new BrowserType
                    .LaunchOptions()
                    .setHeadless(false)
                    .setSlowMo(250));
    Page page = browser.newPage();
    Webtables webtables = new Webtables();


    @Test
    public void ThyToChengeValueTest() {
        page.navigate(webtables.getUrl(), new Page
                .NavigateOptions()
                .setWaitUntil(WaitUntilState
                        .DOMCONTENTLOADED));

        createTableString();





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

    public static String randomInt(){
        String value =Integer.toString(ThreadLocalRandom.current().nextInt(1, 1001));
        return value;
    }


    public void createTableString(){
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("First Name")).fill(generateRandomString(10));
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Last Name")).fill(generateRandomString(10));
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("name@example.com")).fill(generateRandomString(3) + "@" + generateRandomString(5) +".ru");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Age")).fill(randomInt());
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Salary")).fill(randomInt());
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Department")).fill(generateRandomString(10));
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Submit")).click();
    }
}


