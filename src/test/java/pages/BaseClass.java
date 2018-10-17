package pages;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.gis.Authorization;
import pages.gis.MainPageGis;
import utils.ConfigProperties;

import java.util.concurrent.TimeUnit;


public class BaseClass {
    protected static WebDriver driver;
    protected static Actions action;
    protected static WebDriverWait wait;
    protected static Authorization authorization;
    protected static MainPageGis mainPageGis;


    @Before
    public void setup() {
        System.setProperty(ConfigProperties.getTestProperty("whatWebDriver"), ConfigProperties.getTestProperty("whereWebDriver"));
        driver = new ChromeDriver();
        action = new Actions(driver);
        wait = new WebDriverWait(driver, 5);
        authorization = new Authorization(driver);
        mainPageGis = new MainPageGis(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void toEnd() {
        driver.close();
    }
}
