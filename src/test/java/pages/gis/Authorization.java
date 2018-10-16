package pages.gis;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Authorization {
    public WebDriver webDriver;

    public Authorization(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.webDriver = driver;
    }


}
