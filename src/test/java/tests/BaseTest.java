package tests;

import Pages.BasePage;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.WaitUntilState;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.api.extension.TestWatcher;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class BaseTest {

    protected static Playwright playwright;
    protected static Browser browser;
    protected static BrowserContext context;
    private Path screenshotDir;
    Video video;
    Page page;

    @BeforeAll
    static void initBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium()
                .launch(new BrowserType
                        .LaunchOptions()
                        .setHeadless(false)
                        .setArgs(List.of("--start-maximized"))
                        .setSlowMo(250));

    }

    @BeforeEach
    void setup(TestInfo testInfo) {
        screenshotDir = Paths.get("screenshots/");
        try {
            Files.createDirectories(screenshotDir);
        } catch (IOException e) {
            throw new RuntimeException("Невозможно создать папку для скриншотов", e);
        }
        context = browser.newContext(new Browser.NewContextOptions()
                .setViewportSize(null)
                .setRecordVideoDir(Paths.get("videos/")));
        page = context.newPage();
        video = page.video();

    }

    protected void navigateTo(BasePage pageObject) {
        page.navigate(pageObject.getUrl(), new Page.NavigateOptions()
                .setWaitUntil(WaitUntilState.DOMCONTENTLOADED));
    }

    @RegisterExtension
    TestWatcher watcher = new TestWatcher() {
        @Override
        public void testFailed(ExtensionContext extensionContext, Throwable cause) {
            try {
                if (page != null && !page.isClosed()) {
                    String testName = extensionContext.getDisplayName();
                    Path screenshotPath = screenshotDir.resolve(testName + ".png");
                    byte[] screenshot = page.screenshot(new Page.ScreenshotOptions()
                            .setPath(screenshotPath)
                            .setFullPage(true));
                    saveScreenshotToAllure(screenshot, testName);
                    System.out.println("Скриншот сохранен: " + screenshotPath);
                }
            } catch (Exception e) {
                System.err.println("Ошибка при создании скриншота" + e.getMessage());
            }
        }

        @Attachment(value = "Скриншот при падении: {name}", type = "image/png")
        private byte[] saveScreenshotToAllure(byte[] screenshot, String name) {
            return screenshot;
        }

    };

    @AfterEach
    void tearDown(TestInfo testInfo) throws IOException {
        if (context != null) {
            if (video != null) {
                String videoName = testInfo.getDisplayName() + ".webm";
                Path videoPath = Paths.get("videos/", videoName);
                page.close();
                video.saveAs(videoPath);
                attachVideo(videoName);
            }
            context.close();
        }
    }


    @AfterAll
    static void closeAll() {
        if (browser != null) {
            browser.close();
        }
        if (playwright != null) {
            playwright.close();
        }
    }

    @Attachment(value = "Видео теста {name}", type = "video/webm")
    private byte[] attachVideo(String name) throws IOException {
        return Files.readAllBytes(
                Paths.get("videos/" + name)
        );
    }


}
