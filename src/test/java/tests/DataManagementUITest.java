package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.BaseClass;
import utils.ConfigProperties;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class DataManagementUITest extends BaseClass {
    @Test
    public void dataTypeChecking() throws Exception{
        //Вход на страницу авторизации
        driver.get(ConfigProperties.getTestProperty("clientApplicationModule"));
        //ждем отрисовки элемента
        wait.until(visibilityOfElementLocated(By.xpath("/html//div[@id='root']//form//span[.='Техподдержка: ']")));
        //проходим авторизацию
        authorization.inputItemLogin(ConfigProperties.getTestProperty("gis.login"));
        authorization.inputItemPassword(ConfigProperties.getTestProperty("gis.password"));
        authorization.clickButtonLogin();
        //ждем отрисовку карты
        Thread.sleep(500);
        //еще ждем
        wait.until(visibilityOfElementLocated(By.xpath("//div[@id='root']/section/div[2]/div[5]")));
        if (!driver.findElement(By.xpath("//div[@id='root']/section/section[1]/section[2]//span[.='WGS']")).isDisplayed()) {
            throw new RuntimeException("!!!Отсутствует элемент 'WGS'!!!\n\n");
        }
        Assert.assertTrue(mainPageGis.getLayerProdShop().isDisplayed());
        action.contextClick(mainPageGis.getLayerProdShop()).moveToElement(mainPageGis.getShowInTable()).click().build().perform();
        //mainPageGis.clickShowInTable();
    }
}
