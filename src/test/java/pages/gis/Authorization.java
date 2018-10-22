package pages.gis;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Authorization {
    public WebDriver driver;

    public Authorization(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "login")
    private WebElement itemLogin;

    @FindBy(id = "password")
    private WebElement itemPassword;

    @FindBy(css = "[type='submit']")
    private WebElement buttonLogin;

    public void inputItemLogin(String value) {
        itemLogin.sendKeys(value);
    }

    public void inputItemPassword(String value) {
        itemPassword.sendKeys(value);
    }

    public void clickButtonLogin() {
        buttonLogin.click();
    }

    public WebElement getButtonLogin() {
        return buttonLogin;
    }
}
