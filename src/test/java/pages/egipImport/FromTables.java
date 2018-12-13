package pages.egipImport;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FromTables {
    public WebDriver driver;

    public FromTables(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    @FindBy(xpath = "//div[@id='__BVID__3__BV_tab_container_']/div[1]/form[1]//strong[.='Данные для подключения']")
    private WebElement dataConnect;

    @FindBy(css = "#__BVID__3__BV_tab_container_ [role='tabpanel']:nth-of-type(1) [class='col-sm-6']:nth-of-type(2) strong")
    private WebElement metadata;

    @FindBy (xpath = "//div[@id='__BVID__3__BV_tab_container_']/div[1]/form[1]/button[@type='submit']")
    private WebElement buttonGetTables;

    @FindBy (xpath = "//div[@id='__BVID__3__BV_tab_container_']/div[1]/div[@role='alert']")
    private WebElement getSelectTables;

    public WebElement getDataConnect(){
        return dataConnect;
    }

    public WebElement getMetadata(){
        return metadata;
    }

    public void clickButtonGetTables(){
        buttonGetTables.click();
    }

    public WebElement getGetSelectTables(){
        return getSelectTables;
    }

    public Boolean checkGetSelectTables(){
        try{
           return getSelectTables.isDisplayed();
        }catch (NoSuchElementException e){
            return false;
        }
    }
}
