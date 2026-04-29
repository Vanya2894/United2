package Pages.Elements;

import Pages.BasePage;
import com.microsoft.playwright.Page;

public class RadioButtonPage extends BasePage {

    public RadioButtonPage(Page page) {
        super(page);
    }

    @Override
    public String getUrl() {
        return super.getUrl() + "radio-button";
    }


}
