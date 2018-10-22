package pages.egipImport;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FromODOPM extends FromTables{

    public FromODOPM(WebDriver driver){
        super(driver);
    }

    @FindBy (css = "#__BVID__3__BV_tab_container_ [role='tabpanel']:nth-of-type(3) [class='col-sm-6']:nth-of-type(1) strong")
    private WebElement dataConnect;

    @FindBy (linkText = "Из ОДОПМ")
    private WebElement linkODOPM;

    @FindBy (xpath = "//div[@id='__BVID__3__BV_tab_container_']/div[3]/div/form[1]//div[@id='databaseGroup']/label[@id='databaseGroup__BV_label_']")
    private WebElement dataBase;

    @FindBy(css = "#__BVID__3__BV_tab_container_ form:nth-child(6) [type]")
    private WebElement buttonImport;

    public void clickLinkODOPM(){
        linkODOPM.click();
    }

    public WebElement getDataConnect(){
        return dataConnect;
    }

    public WebElement getDataBase(){
        return dataBase;
    }

    public WebElement getButtonImport(){
        return buttonImport;
    }




}
