package Pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitUntilState;

public class BasePage {
    private final String url = "https://demoqa.com/";
    protected Page page;

    public String getUrl() {
        return url;
    }

    public BasePage(Page page) {
        this.page = page;
    }

}
