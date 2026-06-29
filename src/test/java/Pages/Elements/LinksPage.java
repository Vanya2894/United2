package Pages.Elements;

import Pages.BasePage;
import com.microsoft.playwright.Page;

import static io.restassured.RestAssured.given;


public class LinksPage extends BasePage {

    private final String home = "#simpleLink";
    private final String homeDinam = "#dynamicLink";
    private final String created = "#created";
    private final String noContent = "#no-content";
    private final String moved = "#moved";
    private final String badRequest = "#bad-request";
    private final String unauthorized = "#unauthorized";
    private final String forbidden = "#forbidden";
    private final String invalidUrl = "#invalid-url";


    @Override
    public String getUrl() {
        return super.getUrl() + "links";
    }

    public LinksPage(Page page) {
        super(page);
    }

    public String getHome() {
        return home;
    }

    public String getHomeDinam() {
        return homeDinam;
    }

    public String getCreated() {
        return created;
    }

    public String getNoContent() {
        return noContent;
    }

    public String getMoved() {
        return moved;
    }

    public String getBadRequest() {
        return badRequest;
    }

    public String getUnauthorized() {
        return unauthorized;
    }

    public String getForbidden() {
        return forbidden;
    }

    public String getInvalidUrl() {
        return invalidUrl;
    }

    public void homeClick() {
        page.locator(getHome()).click();
    }

    public void homeDinamClick() {
        page.locator(getHomeDinam()).click();
    }

    public void createdClick() {
        page.locator(getCreated()).click();
    }

    public void noContentClick() {
        page.locator(getNoContent()).click();
    }

    public void movedClick() {
        page.locator(getMoved()).click();
    }

    public void badRequestClick() {
        page.locator(getBadRequest()).click();
    }

    public void unauthorizedClick() {
        page.locator(getUnauthorized()).click();
    }

    public void forbiddenClick() {
        page.locator(getForbidden()).click();
    }

    public void invalidUrlClick() {
        page.locator(getInvalidUrl()).click();
    }



    public void assertStatusCode(String url, int expectedStatusCode) {
        given()
                .when()
                .get(url)
                .then()
                .statusCode(expectedStatusCode);
    }

}
