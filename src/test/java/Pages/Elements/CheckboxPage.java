package Pages.Elements;

import Pages.BasePage;
import com.microsoft.playwright.Page;

public class CheckboxPage extends BasePage {

    private String plusRootBtnClose = "#root span.rc-tree-switcher.rc-tree-switcher_close";
    private String plusRootBtnOpen = "#root  div:nth-child(1) > span.rc-tree-switcher.rc-tree-switcher_open";
    private String plusDecktop = "#root div:nth-child(2) > span.rc-tree-switcher.rc-tree-switcher_close";
    private String plusDocuments = "#root div:nth-child(5) > span.rc-tree-switcher.rc-tree-switcher_close";
    private String plusWorkSpase = "#root div:nth-child(6) > span.rc-tree-switcher.rc-tree-switcher_close";
    private String plusOffice = "#root div:nth-child(10) > span.rc-tree-switcher.rc-tree-switcher_close";
    private String plusDownload = "#root div:nth-child(15) > span.rc-tree-switcher.rc-tree-switcher_close";
    private String checkBoxHome = "#root div:nth-child(1) > span.rc-tree-checkbox";
    private String checkBoxDecktop = "#root div:nth-child(2) > span.rc-tree-checkbox";
    private String checkBoxDocuments = "#root div:nth-child(5) > span.rc-tree-checkbox";
    private String checkBoxDownload = "#root  div:nth-child(15) > span.rc-tree-checkbox";
    private String checkboxResult = "#result";

    public CheckboxPage(Page page) {
        super(page);
    }

    @Override
    public String getUrl() {
        return super.getUrl() + "checkbox";
    }

    public void clickPlusRootBtnClose(){
        page.click(plusRootBtnClose);
    }

    public void clickPlusRootBtnOpen(){
        page.click(plusRootBtnOpen);
    }

    public void clickPlusDecktop(){
        page.click(plusDecktop);
    }

    public void clickPlusDocuments(){
        page.click(plusDocuments);
    }

    public void clickPlusWorkSpase(){
        page.click(plusWorkSpase);
    }

    public void clickPlusOffice(){
        page.click(plusOffice);
    }

    public void clickPlusDownload(){
        page.click(plusDownload);
    }

    public void clickCheckBoxHome(){
        page.click(checkBoxHome);
    }
    public void clickCheckBoxDecktop(){
        page.click(checkBoxDecktop);
    }
    public void clickCheckBoxDocuments(){
        page.click(checkBoxDocuments);
    }
    public void clickCheckBoxDownload(){
        page.click(checkBoxDownload);
    }

    public String getCheckboxResult() {
        return checkboxResult;
    }
}

