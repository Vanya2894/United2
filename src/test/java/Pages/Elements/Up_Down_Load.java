package Pages.Elements;

import Pages.BasePage;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.WaitForSelectorState;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class Up_Down_Load extends BasePage {


    private String downloadBtn = "#downloadButton";
    private String selectFileBtn = "#uploadFile";
    private String filePathResult ="#uploadedFilePath";
    private String FAKE_PATH = "C:\\fakepath\\";


    @Override
    public String getUrl() {
        return super.getUrl() + "upload-download";
    }

    public Up_Down_Load(Page page) {
        super(page);
    }

    public String getDownloadBtn() {
        return downloadBtn;
    }

    public String getSelectFileBtn() {
        return selectFileBtn;
    }

    public String getFilePathResult() {
        return filePathResult;
    }


    public void downloadBtnClick() {
        page.locator(getDownloadBtn()).click();
    }

    public void selectFileBtnClick() {
        page.locator(getSelectFileBtn()).click();
    }


    public void checkiIsEnabledDownBtn() {
        assertThat(page.locator(getDownloadBtn())).isEnabled();
    }

    public void checkiIsEnabledSelectFileBtn() {
        assertThat(page.locator(getSelectFileBtn())).isEnabled();
    }

    public void checkFakePathHide() {
        assertThat(page.locator(getFilePathResult())).isHidden();
    }

    public void checkTextNOTEmptySelectFileBtn(String expected_file_name) {
        page.locator(filePathResult).waitFor();
        assertThat(page.locator(filePathResult)).containsText(FAKE_PATH + expected_file_name);
    }

    public void uploadFile(String expected_Path) {
        Path filePath = Paths.get(expected_Path).toAbsolutePath();
        page.locator(selectFileBtn).setInputFiles(filePath);
    }


    public void checkDownloadStart() throws IOException {
        Download download = page.waitForDownload(() -> {
            page.locator(downloadBtn).click();
        });

        Path filePath = download.path();
        assertNotNull(filePath, "Файл не был скачан");
        assertTrue(Files.exists(filePath), "Скачанный файл не существует");
        assertTrue(Files.size(filePath) > 0, "Скачанный файл пуст");

        String suggestedName = download.suggestedFilename();
        assertEquals("sampleFile.jpeg", suggestedName, "Имя файла не соответствует ожидаемому");
    }
}








