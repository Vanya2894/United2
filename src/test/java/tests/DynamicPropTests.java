package tests;

import Pages.Elements.ButtonsPage;
import Pages.Elements.DynamicProp;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DynamicPropTests extends BaseTest{

    DynamicProp dynamicProp;

    @BeforeEach
    void initPage() {
        dynamicProp = new DynamicProp(page);
    }

    @Test
    public void waitDuttonsTest(){
        navigateTo(dynamicProp);

        Allure.step("Проверяем, что кнопка 'Will enable 5 seconds' становится активна через 5 сек", () -> {
            dynamicProp.assertIsEnabledBTN(false);
            dynamicProp.assertIsEnabledBTN(true);
        });

        Allure.step("Проверяем, что кнопка 'Color Change' изменяет цвет цвет", () -> {
            page.reload();
            dynamicProp.testButtonColorChanges();
        });

        Allure.step("Проверяем, что кнопка 'Visible After 5 Seconds' появляется чере 5 сек", () -> {
            page.reload();
            dynamicProp.assertIsVisibleBTN(false);
            dynamicProp.assertIsVisibleBTN(true);
        });



    }
}
