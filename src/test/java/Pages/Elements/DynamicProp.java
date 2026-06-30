package Pages.Elements;

import Pages.BasePage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class DynamicProp extends BasePage {

    private final String enableAfterBtn = "#enableAfter";
    private final String visibleAfterBtn = "#visibleAfter";
    private final String textRandom = "//p[text()=\"This text has random Id\"]";
    private final String colorChangeBtn = "#colorChange";


    @Override
    public String getUrl() {
        return super.getUrl() + "dynamic-properties";
    }

    public DynamicProp(Page page) {
        super(page);
    }

    public String getEnableAfterBtn() {
        return enableAfterBtn;
    }

    public String getColorChangeBtn() {
        return colorChangeBtn;
    }

    public String getVisibleAfterBtn() {
        return visibleAfterBtn;
    }

    public String getTextRandom() {
        return textRandom;
    }

    public void clickEnableAfterBtn() {
        page.locator(enableAfterBtn).click();
    }

    public void clickColorChangeBtn() {
        page.locator(colorChangeBtn).click();
    }

    public void clickVisibleAfterBtn() {
        page.locator(visibleAfterBtn).click();
    }

    public void assertIsEnabledBTN(Boolean expected) {
        if (expected = false ) {
            assertThat(page.locator(enableAfterBtn)).isDisabled();
        } else if (expected = true) {
            page.waitForSelector(enableAfterBtn, new Page.WaitForSelectorOptions().setTimeout(5000));
            assertThat(page.locator(enableAfterBtn)).isEnabled();
        }
    }

    public void assertIsVisibleBTN(Boolean expected) {
        if (expected = false) {
            assertThat(page.locator(visibleAfterBtn)).not().isVisible();
        } else if (expected = true) {
            page.waitForSelector(visibleAfterBtn, new Page.WaitForSelectorOptions().setTimeout(5000));
            assertThat(page.locator(visibleAfterBtn)).isVisible();
        }
    }


    public void testButtonColorChanges() {
        Locator button = page.locator(colorChangeBtn);
        String initialColor = (String) button.evaluate("el => getComputedStyle(el).color");
        page.waitForCondition(() -> {
            String currentColor = (String) button.evaluate("el => getComputedStyle(el).color");
            return !currentColor.equals(initialColor);
        }, new Page.WaitForConditionOptions().setTimeout(6000));
        String newColor = (String) button.evaluate("el => getComputedStyle(el).color");
        assertNotEquals(initialColor, newColor, "Цвет должен измениться");
    }


}

