package pages.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DesktopAdmin {
    public WebDriver driver;

    public DesktopAdmin(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    @FindBy (xpath = "//main//a[@href='#/users']")
    private WebElement buttonUsers;

    @FindBy (xpath = "//main//a[@href='#/roles']")
    private WebElement buttonRoles;

    @FindBy (xpath = "//main//a[@href='#/organizations']")
    private WebElement buttonOrg;

    @FindBy (css = "[href='\\#\\/login']")
    private WebElement buttonLogout;

    @FindBy (xpath = "//a[@href='#/']")
    private WebElement jumpToMain;

    @FindBy (css = ".anticon-user")
    private WebElement userMenu;

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

    public void clickJumpToMain(){
        jumpToMain.click();
    }
}
