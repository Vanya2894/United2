package tests;

import com.microsoft.playwright.*;
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
        page = browser.newPage();

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
