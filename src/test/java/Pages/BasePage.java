package Pages;

import com.microsoft.playwright.Page;

abstract public class BasePage {
    private final String url = "https://demoqa.com/";
    protected Page page;

    public String getUrl() {
        return url;
    }

    public BasePage(Page page) {
        this.page = page;
    }

}
