package pages.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthorizationAdmin {
    public WebDriver webDriver;

    public AuthorizationAdmin(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.webDriver = driver;
    }

    @FindBy (xpath = "*//input[@name='username']")
    private WebElement login;

    @FindBy (xpath = "*//input[@name='password']")
    private WebElement password;

    @FindBy (xpath = "///button[@innertext='Войти']")
    private WebElement buttonLogin;

    public void setLogin(String text) {
        login.sendKeys(text);
    }

    public void setPassword(String text){
        password.sendKeys(text);
    }

    public void clickButtonLogin(){
        buttonLogin.click();
    }
}
