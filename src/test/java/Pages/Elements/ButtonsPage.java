package Pages.Elements;

import Pages.BasePage;
import com.microsoft.playwright.Page;

public class ButtonsPage extends BasePage {

    private final String DoubleClickButton = "#doubleClickBtn";
    private final String DoubleClickMessege = "#doubleClickMessage";
    private final String RightClickButton = "#rightClickBtn";
    private final String rightClickMessage = "#rightClickMessage";
    private final String ClickButton = "button:has-text('Click Me'):not(:has-text('Double')):not(:has-text('Right'))";
    private final String ClickMassege = "#dynamicClickMessage";


    public String getDoubleClickMessege() {
        return DoubleClickMessege;
    }

    public String getRightClickMessage() {
        return rightClickMessage;
    }

    public String getClickMassege() {
        return ClickMassege;
    }

    public String getDoubleClickButton() {
        return DoubleClickButton;
    }

    public String getRightClickButton() {
        return RightClickButton;
    }

    public String getClickButton() {
        return ClickButton;
    }

    @Override
    public String getUrl() {
        return super.getUrl() + "buttons";
    }

    public ButtonsPage(Page page) {
        super(page);
    }


}
