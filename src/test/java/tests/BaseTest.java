package tests;

import Pages.BasePage;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.WaitUntilState;
import org.junit.jupiter.api.*;

import java.util.List;


public class BaseTest {

    protected static Playwright playwright;
    protected static Browser browser;
    protected static BrowserContext context;
    Page page;

    @BeforeAll
    static void initBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium()
                .launch(new BrowserType
                        .LaunchOptions()
                        .setHeadless(false)
                        .setArgs(List.of("--start-maximized"))
                        .setSlowMo(150));

    }

    @BeforeEach
    void setup() {
        context = browser.newContext(new Browser.NewContextOptions()
                .setViewportSize(null));
        page = context.newPage();

    }
    protected void navigateTo(BasePage pageObject) {
        page.navigate(pageObject.getUrl(), new Page.NavigateOptions()
                .setWaitUntil(WaitUntilState.DOMCONTENTLOADED));
    }

    @AfterEach
    void tearDown() {
        context.close();
    }


    @AfterAll
    static void closeAll() {
        browser.close();
        playwright.close();
    }



}
