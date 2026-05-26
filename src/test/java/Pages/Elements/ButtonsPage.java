package Pages.Elements;

import Pages.BasePage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.MouseButton;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ButtonsPage extends BasePage {

    // Locators
    private final String DoubleClickButton = "#doubleClickBtn";
    private final String DoubleClickMessege = "#doubleClickMessage";
    private final String RightClickButton = "#rightClickBtn";
    private final String rightClickMessage = "#rightClickMessage";
    private final String ClickButton = "button:has-text('Click Me'):not(:has-text('Double')):not(:has-text('Right'))";
    private final String ClickMassege = "#dynamicClickMessage";


    // Variables
    private final String DOUBLE_MASSEGE_TEXT = "You have done a double click";
    private final String RIGHT_MASSEGE_TEXT = "You have done a right click";
    private final String DNAMIC_MASSEGE_TEXT = "You have done a dynamic click";

    // Initialisation
    public ButtonsPage(Page page) {
        super(page);
    }

    @Override
    public String getUrl() {
        return super.getUrl() + "buttons";
    }


    // Getters
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


    // Methods
    public void onceClickOnDoubleClickButton() {
        page.locator(getDoubleClickButton()).click();
    }

    public void doubleClickOnDoubleClickButton() {
        page.locator(getDoubleClickButton()).dblclick();
    }

    public void leftClickToRighhtClickButton() {
        page.locator(getRightClickButton()).click();
    }

    public void rightClickToRighhtClickButton() {
        page.locator(getRightClickButton()).click(new Locator.ClickOptions().setButton(MouseButton.RIGHT));
    }

    public void rightClickToClickButton() {
        page.locator(getClickButton()).click(new Locator.ClickOptions().setButton(MouseButton.RIGHT));
    }

    public void clickToClickButton() {
        page.locator(getClickButton()).click();
    }


    // Asserts
    public void checkHaveNoTextAfterClick() {
        assertThat(page.locator(getDoubleClickMessege())).isHidden();
        assertThat(page.locator(getRightClickMessage())).not().isVisible();
        assertThat(page.locator(getClickMassege())).isHidden();
    }

    public void checkButtonsExistAndLabelsAbsent() {
        assertThat(page.locator(getDoubleClickButton())).isEnabled();
        assertThat(page.locator(getRightClickButton())).isEnabled();
        assertThat(page.locator(getClickButton())).isEnabled();
        assertThat(page.locator(getDoubleClickMessege())).isHidden();
        assertThat(page.locator(getRightClickMessage())).not().isVisible();
        assertThat(page.locator(getClickMassege())).isHidden();
    }

    public void checkAfterClickOnDoubleClickButton() {
        assertThat(page.locator(getDoubleClickMessege())).hasText(DOUBLE_MASSEGE_TEXT);
        assertThat(page.locator(getRightClickButton())).isEnabled();
        assertThat(page.locator(getClickButton())).isEnabled();
        assertThat(page.locator(getRightClickMessage())).not().isVisible();
        assertThat(page.locator(getClickMassege())).isHidden();
    }

    public void checkAfterClickRighhtClickButton() {
        assertThat(page.locator(getRightClickMessage())).hasText(RIGHT_MASSEGE_TEXT);
        assertThat(page.locator(getDoubleClickMessege())).not().isVisible();
        assertThat(page.locator(getClickMassege())).isHidden();
    }

    public void checkAfterClickClickButton() {
        assertThat(page.locator(getClickMassege())).hasText(DNAMIC_MASSEGE_TEXT);
        assertThat(page.locator(getDoubleClickMessege())).not().isVisible();
        assertThat(page.locator(getRightClickMessage())).isHidden();
    }
    public void checkAfterAllButtonsClick(){
        assertThat(page.locator(getDoubleClickMessege())).hasText(DOUBLE_MASSEGE_TEXT);
        assertThat(page.locator(getRightClickMessage())).hasText(RIGHT_MASSEGE_TEXT);
        assertThat(page.locator(getClickMassege())).hasText(DNAMIC_MASSEGE_TEXT);
    }

}
