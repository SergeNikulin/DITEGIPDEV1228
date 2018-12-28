package pages;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.admin.AuthorizationAdmin;
import pages.admin.DesktopAdmin;
import pages.docs.MainPageDocs;
import pages.egipImport.FromArchive;
import pages.egipImport.FromODOPM;
import pages.egipImport.FromTables;
import pages.egipImport.JMS;
import pages.gis.Authorization;
import pages.gis.MainPageGis;
import pages.gis.Zabbix;
import utils.ConfigProperties;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import utils.Log;

import java.util.concurrent.TimeUnit;


public class BaseClass {
    protected static WebDriver driver;
    protected static Actions action;
    protected static WebDriverWait wait;
    protected static Authorization authorization;
    protected static MainPageGis mainPageGis;
    protected static AuthorizationAdmin authorizationAdmin;
    protected static DesktopAdmin desktopAdmin;
    protected static MainPageDocs mainPageDocs;
    protected static FromTables fromTables;
    protected static FromArchive fromArchive;
    protected static FromODOPM fromODOPM;
    protected static JMS jms;
    protected static Zabbix zabbix;


    @Before
    public void setup() {
        Log.info("******************************************************************************************************");
        System.setProperty(ConfigProperties.getTestProperty("whatWebDriver"), ConfigProperties.getTestProperty("whereWebDriver"));
        driver = new ChromeDriver();
        action = new Actions(driver);
        wait = new WebDriverWait(driver, 15);
        authorization = new Authorization(driver);
        mainPageGis = new MainPageGis(driver);
        authorizationAdmin = new AuthorizationAdmin(driver);
        desktopAdmin = new DesktopAdmin(driver);
        mainPageDocs = new MainPageDocs(driver);
        fromTables = new FromTables(driver);
        fromArchive = new FromArchive(driver);
        fromODOPM = new FromODOPM(driver);
        jms = new JMS(driver);
        zabbix = new Zabbix(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void toEnd() {
        //Log.endLog("Test is ending!!!");
        Log.info("******************************************************************************************************");
        driver.close();
        driver.quit();

    }
}
