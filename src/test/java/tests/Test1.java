package tests;

import org.junit.Assert;
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
        authorization.inputItemLogin(ConfigProperties.getTestProperty("gis.login"));
        authorization.inputItemPassword(ConfigProperties.getTestProperty("gis.password"));
        authorization.clickButtonLogin();
        //ждем отрисовку карты
        Thread.sleep(5000);
        //еще ждем
        wait.until(visibilityOfElementLocated(By.xpath("//div[@id='root']/section/div[2]/div[5]")));
        if (!driver.findElement(By.xpath("//div[@id='root']/section/section[1]/section[2]//span[.='Проект для теста']")).isDisplayed()) {
            throw new RuntimeException("!!!Отсутствует элемент 'Проект для теста'!!!\n\n");
        }
        //проходимся по вкладками попутно проверяя наличие объектов
        mainPageGis.clickButtonLegend();
        mainPageGis.clickButtonLibrary();
        if (driver.findElement(By.cssSelector("[placeholder]")).isDisplayed()) {
            Assert.assertEquals("поиск",mainPageGis.getInputSearchCatalog());

        }
        if (driver.findElement(By.cssSelector(".ant-select-selection__rendered [unselectable]")).isDisplayed()) {
            Assert.assertEquals("выбранные слои",mainPageGis.getInputSrchLayerCatalog());
        }
        action.moveToElement(mainPageGis.getButtonCatalog()).click().perform();
        action.moveToElement(mainPageGis.getButtonLogout()).click().perform();
        Thread.sleep(1000);
        //проверяем что разлогинились
        Assert.assertTrue(authorization.getButtonLogin().isDisplayed());
    }

    @Test
    public void test5() throws Exception{
        driver.get(ConfigProperties.getTestProperty("administrationModule"));
        wait.until(visibilityOfElementLocated(By.cssSelector(".anticon-eye")));

        authorizationAdmin.setLogin(ConfigProperties.getTestProperty("admin.login"));
        authorizationAdmin.setPassword(ConfigProperties.getTestProperty("admin.password"));
        authorizationAdmin.clickButtonLogin();


    }
}
