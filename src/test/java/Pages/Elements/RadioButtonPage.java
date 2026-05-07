package Pages.Elements;

import Pages.BasePage;
import com.microsoft.playwright.Page;

public class RadioButtonPage extends BasePage {


    private String yesRadioText = "#root div:nth-child(1) > label";
    private String yesRadioBtn = "#yesRadio";
    private String impressiveRadioText = "#root div:nth-child(2) > label";
    private String impressiveRadioBtn = "#impressiveRadio";
    private String noRadioText = "#root  div:nth-child(3) > label";

    public String getYesRadioText() {
        return yesRadioText;
    }

    public String getYesRadioBtn() {
        return yesRadioBtn;
    }

    public String getImpressiveRadioText() {
        return impressiveRadioText;
    }

    public String getImpressiveRadioBtn() {
        return impressiveRadioBtn;
    }

    public String getNoRadioText() {
        return noRadioText;
    }

    public String getNoRadioBtn() {
        return noRadioBtn;
    }

    public String getResult() {
        return result;
    }

    private String noRadioBtn = "#noRadio";
    private String result = "#root div:nth-child(2) > p";


    public RadioButtonPage(Page page) {
        super(page);
    }

    @Override
    public String getUrl() {
        return super.getUrl() + "radio-button";
    }


}
