package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import pages.BaseClass;
import pages.docs.SomeVariables;
import utils.ConfigProperties;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;


public class Test1 extends BaseClass {

  /*  @Test
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
        Thread.sleep(500);
        //еще ждем
        wait.until(visibilityOfElementLocated(By.xpath("//div[@id='root']/section/div[2]/div[5]")));
        if (!driver.findElement(By.xpath("//div[@id='root']/section/section[1]/section[2]//span[.='Проект для теста']")).isDisplayed()) {
            throw new RuntimeException("!!!Отсутствует элемент 'Проект для теста'!!!\n\n");
        }
        //проходимся по вкладками попутно проверяя наличие объектов
        mainPageGis.clickButtonLegend();
        action.moveToElement(mainPageGis.getButtonCatalog()).click().perform();
        Thread.sleep(1000);
       mainPageGis.clickButtonLibrary();
        wait.until(visibilityOfElementLocated(By.cssSelector("[placeholder]")));
        if (driver.findElement(By.cssSelector("[placeholder]")).isDisplayed()) {
            Assert.assertEquals("поиск",mainPageGis.getInputSearchCatalog());

        }
        if (driver.findElement(By.cssSelector(".ant-select-selection__rendered [unselectable]")).isDisplayed()) {
            Assert.assertEquals("выбранные слои",mainPageGis.getInputSrchLayerCatalog());
        }

        action.moveToElement(mainPageGis.getButtonLogout()).click().perform();
        Thread.sleep(2000);
        //проверяем что разлогинились
        Assert.assertTrue(authorization.getButtonLogin().isDisplayed());
    }

    @Test
    public void test5() throws Exception {
        driver.get(ConfigProperties.getTestProperty("administrationModule"));
        wait.until(visibilityOfElementLocated(By.cssSelector(".anticon-eye")));

        authorizationAdmin.setLogin(ConfigProperties.getTestProperty("admin.login"));
        authorizationAdmin.setPassword(ConfigProperties.getTestProperty("admin.password"));
        authorizationAdmin.clickButtonLogin();

        wait.until(visibilityOfElementLocated(By.cssSelector(".anticon-user")));
        desktopAdmin.clickButtonUsers();
        wait.until(visibilityOfElementLocated(By.xpath("//div[@id='root']/div/div//h1")));
        desktopAdmin.clickJumpToMain();
        desktopAdmin.clickButtonRoles();
        wait.until(visibilityOfElementLocated(By.xpath("//div[@id='root']/div/div//h1")));
        desktopAdmin.clickJumpToMain();
        desktopAdmin.clickButtonOrg();
        wait.until(visibilityOfElementLocated(By.xpath("//div[@id='root']/div/div//h1")));
        desktopAdmin.clickJumpToMain();
        wait.until(visibilityOfElementLocated(By.cssSelector(".anticon-user")));
        action.moveToElement(desktopAdmin.getUserMenu()).perform();
        desktopAdmin.clickButtonLogout();
        Thread.sleep(1000);
        Assert.assertTrue(driver.findElement(By.cssSelector(".anticon-eye")).isDisplayed());
    }*/

    @Test
    public void test3() throws Exception {
        driver.get(ConfigProperties.getTestProperty("dataConsumerInteractionModule"));
        wait.until(visibilityOfElementLocated(By.cssSelector(".app-name-link")));
        Assert.assertTrue(mainPageDocs.getReadmeResource().isDisplayed());
        Assert.assertEquals(mainPageDocs.getReadmeResource().getText(), "Ресурсы");
        Assert.assertTrue(mainPageDocs.getReadmeBegin().isDisplayed());
        Assert.assertEquals(mainPageDocs.getReadmeBegin().getText(), "Старт");
        Assert.assertTrue(mainPageDocs.getReadmeBlockCode().isDisplayed());
        //здесь и далее будут использоваться переменные типа String из класса SomeVariables
        Assert.assertEquals(mainPageDocs.getReadmeBlockCode().getText(), SomeVariables.readmeBlockCode);
        mainPageDocs.clickGivinLayerWMS();
        Thread.sleep(1000);
        Assert.assertEquals(mainPageDocs.getCheckLink().getText(), SomeVariables.layersWMS);
        driver.switchTo().frame(driver.findElement(By.xpath("/html//article[@id='main']//iframe")));
        driver.switchTo().frame(driver.findElement(By.id("app")));
        Assert.assertTrue(mainPageDocs.getPathCodeBlockLayer().isDisplayed());
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(By.xpath("/html//article[@id='main']//iframe")));
        Assert.assertEquals(mainPageDocs.getLayerBlockCode().getText(), SomeVariables.layersBlockCode);
        driver.switchTo().defaultContent();
        mainPageDocs.clickSlidebar();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();"
                , mainPageDocs.getLinkCluster());
        mainPageDocs.clickLinkCluster();
        wait.until(visibilityOfElementLocated(By.xpath("//article[@id='main']//p[.='функция кластеризации точек выбранного слоя']")));
        Assert.assertEquals(mainPageDocs.getHeadCluster().getText(), "Кластеризация точек выбранного слоя");
        driver.switchTo().frame(driver.findElement(By.xpath("/html//article[@id='main']//iframe")));
        driver.switchTo().frame(driver.findElement(By.id("app")));
        mainPageDocs.clickButtonCluster();
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(By.xpath("/html//article[@id='main']//iframe")));
        Assert.assertTrue(mainPageDocs.getLayerBlockCode().getText().contains("document.getElementById('bottom')"));
        driver.switchTo().defaultContent();


    }
}
