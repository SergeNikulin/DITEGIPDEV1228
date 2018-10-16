package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import pages.BaseClass;
import utils.ConfigProperties;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;


public class Test1 extends BaseClass {

    @Test
    public void test1() throws Exception {

        //Вход на страницу авторизации
        driver.get(ConfigProperties.getTestProperty("clientApplicationModule"));
        //ждем отрисовки элемента
        wait.until(visibilityOfElementLocated(By.cssSelector("#root > div > section > span")));
        //проходим авторизацию
        authorization.inputItemLogin("sys");
        authorization.inputItemPassword("123456");
        authorization.clickButtonLogin();
        Thread.sleep(5000);
    }
}
