package pages.gis;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class MainPageGis extends Authorization{

    public MainPageGis(WebDriver driver) {
         super(driver);
    }

    @FindBy(xpath = "//div[@id='root']/section/section[1]/section[1]/div[2]")
    private WebElement buttonLegend;

    @FindBy(xpath = "//*[@id=\"root\"]/section/section[1]/section[1]/div[3]")
    private WebElement buttonLibrary;

    @FindBy(xpath = "//div[@id='root']/section/section[1]/section[1]/div[4]")
    private WebElement buttonCatalog;

    @FindBy(css = "[placeholder]")
    private WebElement inputSearchCatalog;

    @FindBy(css = ".ant-select-selection__rendered [unselectable]")
    private WebElement inputSrchLayerCatalog;

    @FindBy(xpath = "//div[@id='root']/section/div[4]/p")
    private WebElement buttonLogout;


    public String getInputSearchCatalog() {
        return inputSearchCatalog.getAttribute("placeholder");
    }

    public void clickButtonLegend() {
        buttonLegend.click();
    }

    public void clickButtonLibrary() {
        buttonLibrary.click();
    }
    public WebElement getButtonLibrary(){
        return buttonLibrary;
    }

    public WebElement getButtonCatalog() {

        return buttonCatalog;
    }


    public String getInputSrchLayerCatalog() {
        return inputSrchLayerCatalog.getText();
    }

    public WebElement getButtonLogout() {
        return buttonLogout;
    }
}
