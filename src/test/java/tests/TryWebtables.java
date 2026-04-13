package tests;

import Pages.Elements.Webtables;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import org.junit.jupiter.api.*;

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



    }
}


