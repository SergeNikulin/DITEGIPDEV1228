package pages;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigProperties;

import java.util.concurrent.TimeUnit;



public class BaseClass {
    public static WebDriver driver;
    public static Actions action;
    public static WebDriverWait wait;



    @Before
    public void setup(){
        System.setProperty(ConfigProperties.getTestProperty("whatWebDriver"),ConfigProperties.getTestProperty("whereWebDriver"));
        driver = new ChromeDriver();
        action = new Actions(driver);
        wait = new WebDriverWait(driver,5);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
      //  driver.get(ConfigProperties.getTestProperty("clientApplicationModule"));

    }
    @After
    public  void toEnd(){
        driver.close();
    }
}
