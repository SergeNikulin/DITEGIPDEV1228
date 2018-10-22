package pages.egipImport;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FromArchive extends FromTables {

    public FromArchive(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Из архива")
    private WebElement fromArchive;

    @FindBy(xpath = "/html//label[@id='fileNameGroup__BV_label_']")
    private WebElement fileName;

    @FindBy(xpath = "//div[@id='__BVID__3__BV_tab_container_']/div[2]/form/div[4]/div[2]/div[@role='group']/label[@class='col-form-label pt-0']")
    private WebElement fileReprojectionable;

    @FindBy (css = "#__BVID__3__BV_tab_container_ .row:nth-child(8) [class='col-form-label pt-0']")
    private WebElement fileCharset;

    public void clickFromArchive() {
        fromArchive.click();
    }

    public String checkFileName() {
        return fileName.getText();
    }

    public  String checkFileReprojectionable(){
        return fileReprojectionable.getText();
    }

    public String checkFileCharset(){
        return fileCharset.getText();
    }
}
