package pages.gis;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MainPageGis extends Authorization {

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

    @FindBy(xpath = "//div[@id='root']/section//p[.='sys']")
    private WebElement buttonLogout;

    @FindBy(xpath = "//span[.='Продовольственные магазины']")
    private WebElement layerProdShop;

    @FindBy(xpath = "/html/body/div[6]/div/div/ul[@role='menu']/li[3]")
    private WebElement showInTable;

    public void clickShowInTable() {
        showInTable.click();
    }

    public WebElement getShowInTable() {
        return showInTable;
    }

    public WebElement getLayerProdShop() {
        return layerProdShop;
    }

    public String getInputSearchCatalog() {
        return inputSearchCatalog.getAttribute("placeholder");
    }

    public void clickButtonLegend() {
        buttonLegend.click();
    }

    public void clickButtonLibrary() {
        buttonLibrary.click();
    }

    public WebElement getButtonLibrary() {
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
