package tests;


import Pages.Elements.Up_Down_Load;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Up_Down_Load_Tests extends BaseTest {

    private String NAME_GPEG_FILE = "XnN3imzv7phSeBHYCO-Jqw.jpeg";
    private String NAME_EXE_FILE = "exeFile.exe";
    private String NAME_PDF_FILE = "testPDF.pdf";
    private String NAME_WEBM_FILE = "exeFile.exe";

    private String PATH_TO_UPLOAD_FILE = "src/test/resources/UploadFiles/";


    Up_Down_Load upDownLoadPage;

    @BeforeEach
    void initPage() {
        upDownLoadPage = new Up_Down_Load(page);
    }

    @Test
    public void testToDovnload() {
        navigateTo(upDownLoadPage);

        Allure.step("Шаг 1. Проверка, что кнопка 'Download' активна", () -> {
            upDownLoadPage.checkiIsEnabledDownBtn();
        });
        Allure.step("Шаг 2. Клик по кнопке 'Download'", () -> {
            upDownLoadPage.checkDownloadStart();
        });


    }
    @Test
    public void testToUpload(){
        navigateTo(upDownLoadPage);

        Allure.step("Шаг 1. Проверка, что кнопка 'Выберите файл' активна и поле содержит текст", () -> {
            upDownLoadPage.checkiIsEnabledSelectFileBtn();
            upDownLoadPage.checkFakePathHide();
        });
        Allure.step("Шаг2. Загружаем файл .jpeg", () -> {
            upDownLoadPage.uploadFile(PATH_TO_UPLOAD_FILE + NAME_GPEG_FILE);
            upDownLoadPage.checkTextNOTEmptySelectFileBtn(NAME_GPEG_FILE);
        });
    }

    @Test
    public void testDifferentFormat(){
        navigateTo(upDownLoadPage);

        Allure.step("Загружаем файл формата .exe", () -> {
            upDownLoadPage.checkiIsEnabledSelectFileBtn();
            upDownLoadPage.checkFakePathHide();
            upDownLoadPage.uploadFile(PATH_TO_UPLOAD_FILE + NAME_EXE_FILE);
            upDownLoadPage.checkTextNOTEmptySelectFileBtn(NAME_EXE_FILE);
        });

        Allure.step("Загружаем файл формата .pdf", () -> {
            upDownLoadPage.checkiIsEnabledSelectFileBtn();
            upDownLoadPage.uploadFile(PATH_TO_UPLOAD_FILE + NAME_PDF_FILE);
            upDownLoadPage.checkTextNOTEmptySelectFileBtn(NAME_PDF_FILE);
        });
    }


}
