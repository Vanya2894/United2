package Pages.Elements;

import Pages.BasePage;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


public class Webtables extends BasePage {
    public Webtables(Page page) {
        super(page);
    }

    @Override
    public String getUrl() {
        return super.getUrl()+ "webtables";
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
