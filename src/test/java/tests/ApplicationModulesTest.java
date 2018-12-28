package tests;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BaseClass;
import pages.docs.SomeVariables;
import utils.ConfigProperties;
import utils.Log;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;


public class ApplicationModulesTest extends BaseClass {

    @Test
    public void checkingAvailabilityClientApplicationModule() {
        try {
            Log.info("Test " + Thread.currentThread().getStackTrace()[1].getMethodName() + " is run!");
            //Вход на страницу авторизации
            Log.info("Opening the login page - OK");
            driver.get(ConfigProperties.getTestProperty("clientApplicationModule"));
            //ждем отрисовки элемента
            wait.until(visibilityOfElementLocated(By.xpath("/html//div[@id='root']//form//span[.='Техподдержка: ']")));
            //проходим авторизацию
            Log.info("Input Login: " + ConfigProperties.getTestProperty("gis.login"));
            authorization.inputItemLogin(ConfigProperties.getTestProperty("gis.login"));
            Log.info("Input Password: " + ConfigProperties.getTestProperty("gis.password"));
            authorization.inputItemPassword(ConfigProperties.getTestProperty("gis.password"));
            Log.info("Authorization execution - OK");
            authorization.clickButtonLogin();
            //ждем отрисовку карты
            Thread.sleep(500);
            //еще ждем
            Log.info("Waiting for loading map and related items.");
            wait.until(visibilityOfElementLocated(By.xpath("//div[@id='root']/section/div[2]/div[5]")));
            if (!driver.findElement(By.xpath("//div[@id='root']/section/section[1]/section[2]//span[.='WGS']")).isDisplayed()) {
                throw new RuntimeException("!!!Отсутствует элемент 'WGS'!!!\n\n");
            }
            //проходимся по вкладками попутно проверяя наличие объектов
            mainPageGis.clickButtonLegend();
            Log.info("Legend tab check - OK");
            action.moveToElement(mainPageGis.getButtonCatalog()).click().perform();
            Log.info("Catalog tab check - OK");
            Thread.sleep(1000);
            mainPageGis.clickButtonLibrary();
            Log.info("Library tab check - OK");
            wait.until(visibilityOfElementLocated(By.cssSelector("[placeholder]")));
            if (driver.findElement(By.cssSelector("[placeholder]")).isDisplayed()) {
                Assert.assertEquals("поиск в названии/описании", mainPageGis.getInputSearchCatalog());
            }
            if (driver.findElement(By.cssSelector(".ant-select-selection__rendered [unselectable]")).isDisplayed()) {
                Assert.assertEquals("выбранные слои", mainPageGis.getInputSrchLayerCatalog());
            }
            Log.info("Logout button check - OK");
            action.moveToElement(mainPageGis.getButtonLogout()).click().perform();
            Thread.sleep(2000);
            //проверяем что разлогинились
            Assert.assertTrue(authorization.getButtonLogin().isDisplayed());
            Log.info("Test completed successfully. The client application is operational.");
        } catch (Exception e) {
            Log.error("TEST FAIL!!!!!!", e);
            Assert.fail("TEST FAIL!!!!!!");
        }
    }

    @Test
    public void availabilityAdministrationModule() {
        try {
            Log.info("Test " + Thread.currentThread().getStackTrace()[1].getMethodName() + " is run!");
            //Вход на страницу авторизации
            driver.get(ConfigProperties.getTestProperty("administrationModule"));
            wait.until(visibilityOfElementLocated(By.cssSelector(".anticon-eye")));
            Log.info("Opening the login page - OK");
            authorizationAdmin.setLogin(ConfigProperties.getTestProperty("admin.login"));
            Log.info("Input Login: " + ConfigProperties.getTestProperty("admin.login"));
            authorizationAdmin.setPassword(ConfigProperties.getTestProperty("admin.password"));
            Log.info("Input Password: " + ConfigProperties.getTestProperty("admin.password"));
            authorizationAdmin.clickButtonLogin();
            Log.info("Authorization execution - OK");
        /*if(desktopAdmin.getWindowSuccess().isDisplayed()){
            desktopAdmin.clickCloseSuccess();
        }*/
            Thread.sleep(2000);
            wait.until(visibilityOfElementLocated(By.cssSelector(".anticon-user")));
            desktopAdmin.clickButtonUsers();
            Log.info("Users tab check - OK");
            Thread.sleep(2000);
            wait.until(visibilityOfElementLocated(By.xpath("//h1[.='Пользователи']")));
            wait.until(ExpectedConditions.visibilityOf(desktopAdmin.getJumpToMain()));
            desktopAdmin.clickJumpToMain();
            desktopAdmin.clickButtonRoles();
            Log.info("Roles tab check - OK");
            wait.until(visibilityOfElementLocated(By.xpath("//h1[.='Роли']")));
            Thread.sleep(2000);
            desktopAdmin.clickJumpToMain();
            desktopAdmin.clickButtonOrg();
            Log.info("Organization tab check - OK");
            wait.until(visibilityOfElementLocated(By.xpath("//h1[.='Организации']")));
            Thread.sleep(2000);
            wait.until(visibilityOfElementLocated(By.xpath("//i[@class='anticon anticon-user']"))).click();
            desktopAdmin.clickButtonLogout();
            Log.info("Logout button check - OK");
            Thread.sleep(2000);
            Assert.assertTrue(driver.findElement(By.cssSelector(".anticon-eye")).isDisplayed());
            Log.info("Test completed successfully. The Administration Module is operational.");
        } catch (Exception e) {
            Log.error("TEST FAIL!!!!!!", e);
            Assert.fail("TEST FAIL!!!!!!");
        }
    }

    @Test
    public void functionalMonitoringSystemZabbix() {
        try {
            Log.info("Test " + Thread.currentThread().getStackTrace()[1].getMethodName() + " is run!");
            //Вход на страницу авторизации
            Log.info("Opening the login page - OK");
            driver.get(ConfigProperties.getTestProperty("clientApplicationModule"));
            //ждем отрисовки элемента
            wait.until(visibilityOfElementLocated(By.xpath("/html//div[@id='root']//form//span[.='Техподдержка: ']")));
            //проходим авторизацию
            Log.info("Input Login: " + ConfigProperties.getTestProperty("gis.login"));
            authorization.inputItemLogin(ConfigProperties.getTestProperty("gis.login"));
            Log.info("Input Password: " + ConfigProperties.getTestProperty("gis.password"));
            authorization.inputItemPassword(ConfigProperties.getTestProperty("gis.password"));
            Log.info("Authorization execution - OK");
            authorization.clickButtonLogin();
            //ждем отрисовку карты
            Thread.sleep(10000);
            //еще ждем
            Log.info("Waiting for loading map and related items.");
            driver.get(ConfigProperties.getTestProperty("zabbix"));
            Log.info("Opening the ZABBIX main page - OK");
            zabbix.clickGraphs();
            Log.info("Opening the Graphs page - OK");
            zabbix.clickGraphsSelect();
            Log.info("Opening the Graphs select - OK");
            Thread.sleep(1000);
            if (!zabbix.getGraphFull().isDisplayed()) {
                throw new Exception("Graph utilization CPU not displayed");
            }
            Log.info("Graph utilization CPU is displayed - OK");
            zabbix.clickSelectHostid();
            zabbix.clickSeclectEGIPDBS02T();
            Log.info("Made transition to hostname EGIP-DBS02T-10.127.0.11 - OK");
            zabbix.clickGraphsSelect();
            Log.info("Opening the Graphs select - OK");
            zabbix.selectNetworkTraffic();
            Log.info("Opening the Graphs page Network Traffic - OK");
            if (!zabbix.getGraphFull().isDisplayed()) {
                throw new Exception("Graph Network Traffic not displayed");
            }
            Log.info("Graph Network Traffic is displayed - OK");
            Thread.sleep(4000);
            Log.info("Test completed successfully. The Monitoring System Zabbix is operational.");
        } catch (Exception e) {
            Log.error("TEST FAIL!!!!!!", e);
            Assert.fail("TEST FAIL!!!!!!");
        }
    }


    @Ignore
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
        // Assert.assertEquals(mainPageDocs.getLayerBlockCode().getText(), SomeVariables.layersBlockCode);
        driver.switchTo().defaultContent();
        mainPageDocs.clickSlidebar();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();"
                , mainPageDocs.getLinkCluster());
        Thread.sleep(3000);
        mainPageDocs.clickLinkCluster();
        wait.until(visibilityOfElementLocated(By.xpath("//article[@id='main']//p")));
        Assert.assertEquals(mainPageDocs.getHeadCluster().getText(), "Кластеризация точек выбранного слоя");
        driver.switchTo().frame(driver.findElement(By.xpath("/html//article[@id='main']//iframe")));
        driver.switchTo().frame(driver.findElement(By.id("app")));
        mainPageDocs.clickButtonCluster();
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(By.xpath("/html//article[@id='main']//iframe")));
        Assert.assertTrue(mainPageDocs.getLayerBlockCode().getText().contains("document.getElementById('bottom')"));
        driver.switchTo().defaultContent();
    }

    @Ignore
    @Test
    public void test2() throws Exception {
        driver.get(ConfigProperties.getTestProperty("dataProviderInteractionModule"));
        //Проверяем первую вкладку
        wait.until(visibilityOfElementLocated(By.cssSelector("#__BVID__3__BV_tab_controls_ .nav-item:nth-of-type(1) [href]")));
        Assert.assertEquals(fromTables.getDataConnect().getText(), "Данные для подключения");
        Assert.assertTrue(fromTables.getDataConnect().isDisplayed());
        Assert.assertEquals(fromTables.getMetadata().getText(), "Метаданные слоя");
        Assert.assertTrue(fromTables.getMetadata().isDisplayed());
        //проверяем что элемента не существует
        Assert.assertTrue(!fromTables.checkGetSelectTables());
        fromTables.clickButtonGetTables();
        //проверяем что элемент есть
        Assert.assertTrue(fromTables.checkGetSelectTables());

        fromArchive.clickFromArchive();
        Assert.assertEquals(fromArchive.checkFileName(), "name для импортируемого слоя");
        Assert.assertEquals(fromArchive.checkFileReprojectionable(), "reprojectionable");
        Assert.assertEquals(fromArchive.checkFileCharset(), "Кодировка файла");

        fromODOPM.clickLinkODOPM();
        Assert.assertEquals(fromODOPM.getDataConnect().getText(), "Данные для подключения");
        Assert.assertEquals(fromODOPM.getDataBase().getText(), "database (или SID)");
        Assert.assertTrue(!fromODOPM.getButtonImport().isEnabled());

        jms.clickLinkJMS();
        jms.setTextArea("{ }");
        Assert.assertTrue(jms.checkRadioButtonZero().isDisplayed());
        Assert.assertTrue(jms.checkRadioButtonFirst().isDisplayed());
        jms.clickRadioButtonFirst();
        Assert.assertTrue(jms.checkRadioButtonFirst().isEnabled());
        Assert.assertTrue(jms.checkRadioButtonSecond().isDisplayed());
        //Позже займусь кнопкой.
        // Assert.assertTrue(jms.getButtonSend().isDisplayed());
    }
}