package pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class DesktopAdmin extends AuthorizationAdmin{

    public DesktopAdmin(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//main//a[@href='#/users']")
    private WebElement buttonUsers;

    @FindBy (xpath = "//main//a[@href='#/roles']")
    private WebElement buttonRoles;

    @FindBy (xpath = "//main//a[@href='#/organizations']")
    private WebElement buttonOrg;

    @FindBy (xpath = "//ul[@id='SubMenu-user$Menu']//a[@href='#/login']")
    private WebElement buttonLogout;

    @FindBy (xpath = "//div[@id='root']/div//a[@href='#/']")
    private WebElement jumpToMain;

    @FindBy (css = ".anticon-user")
    private WebElement userMenu;

    @FindBy (xpath = "//div[@type='success']")
    private WebElement windowSuccess;

    @FindBy (xpath = "//div[@type='success']//i[@class='anticon anticon-close']")
    private WebElement closeSuccess;

    public void clickCloseSuccess(){closeSuccess.click();}

    public WebElement getWindowSuccess(){return windowSuccess;}

    public WebElement getUserMenu(){
        return userMenu;
    }

    public void clickButtonUsers(){
        buttonUsers.click();
    }

    public void clickButtonRoles(){
        buttonRoles.click();
    }

    public void clickButtonOrg(){
        buttonOrg.click();
    }

    public void clickButtonLogout(){
        buttonLogout.click();
    }

    public WebElement getJumpToMain(){return jumpToMain;}
    public void clickJumpToMain(){
        jumpToMain.click();
    }
}
