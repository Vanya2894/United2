package Pages.Elements;

import Pages.BasePage;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


public class Webtables extends BasePage {


    // Locators
    private String counStringsTabl = "#root table tbody tr";
    private String firstStringTable = "#root table > tbody > tr:nth-child(1) > td:nth-child(1)";
    private String editRecord = "#edit-record-1 > svg > path";
    private String countOfPage = "#root div.pagination.d-flex.align-items-center.justify-content-between.mt-3 div:nth-child(2)";
    private String selectFormControl = "select.form-control";
    private String deleteRecord = "#delete-record-2";

    // Variables
    private final String TIPE_TO_SEARCH = "Type to search";

    private final String SHOW10 = "Show 10";
    private final String SHOW20 = "Show 20";
    private final String SHOW30 = "Show 30";

    // Initialisation
    public Webtables(Page page) {
        super(page);
    }

    @Override
    public String getUrl() {
        return super.getUrl() + "webtables";
    }


    // Getters
    public String getCounStringsTabl() {
        return counStringsTabl;
    }

    public String getFirstStringTable() {
        return firstStringTable;
    }

    public String getEditRecord() {
        return editRecord;
    }

    public String getCountOfPage() {
        return countOfPage;
    }

    public String getSelectFormControl() {
        return selectFormControl;
    }

    public String getDeleteRecord() {
        return deleteRecord;
    }

    // Methods
    public static String generateRandomString(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }
        return sb.toString();
    }

    public static String randomInt() {
        String value = Integer.toString(ThreadLocalRandom.current().nextInt(1, 1001));
        return value;
    }

    public void createTableString() {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("First Name")).fill(generateRandomString(10));
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Last Name")).fill(generateRandomString(10));
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("name@example.com")).fill(generateRandomString(3) + "@" + generateRandomString(5) + ".ru");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Age")).fill(randomInt());
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Salary")).fill(randomInt());
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Department")).fill(generateRandomString(10));
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Submit")).click();
    }


    public void editRecordClick() {
        page.locator(getEditRecord()).click();
    }

    public void firstNameValueFill (String expectedText){
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("First Name")).fill(expectedText);
    }

    public void submitBtnClick(){
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Submit")).click();
    }

    public void deleteRecordSecondStringClick(){
        page.locator(getDeleteRecord()).click();

    }

    public void searchValueFill (String expectedText) {
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName(TIPE_TO_SEARCH)).fill(expectedText);
    }

    public void clearSearchValue(){
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName(TIPE_TO_SEARCH)).clear();
    }

    public void nextButtonClick(){
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")).click();
    }

    public void lastButtonClick(){
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Last")).click();
    }

    public void previousButtonClick(){
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Previous")).click();
    }
    public void firstButtonClick(){
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("First")).click();
    }

    public void selectFormControlFill (Integer expextedInt){
        if (expextedInt == 20){
            page.locator(getSelectFormControl()).selectOption(SHOW20);
        } else if (expextedInt == 30) {
            page.locator(getSelectFormControl()).selectOption(SHOW30);
        } else if (expextedInt == 10) {
            page.locator(getSelectFormControl()).selectOption(SHOW10);
        } else {
            expextedInt += 10;
        }
    }







    // Asserts

    public void checkCounStringsTabl(Integer expectedInt){
        assertThat(page.locator(getCounStringsTabl())).hasCount(expectedInt);

    }

    public void checkFirstStringTable (String expectedText){
        assertThat(page.locator(getFirstStringTable())).hasText(expectedText);
    }


   public void checkCountOfPage(String expectedText ){
       assertThat(page.locator(getCountOfPage())).containsText(expectedText);
   }




}
