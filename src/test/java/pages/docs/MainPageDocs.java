package pages.docs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPageDocs {

    public WebDriver driver;

    public MainPageDocs(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "Ресурсы")
    private WebElement readmeResource;

    @FindBy(id = "Старт")
    private WebElement readmeBegin;

    @FindBy(xpath = "//article[@id='main']//code[@class='lang-html']")
    private WebElement readmeBlockCode;

    @FindBy(linkText = "Получение слоев (WMS)")
    private WebElement givinLayerWMS;

    @FindBy(css = "[href='https\\:\\/\\/gost-jira\\.atlassian\\.net\\/wiki\\/spaces\\/EGIPAPIDOC\\/pages\\/436699311\\/API']")
    private WebElement checkLink;

    @FindBy(xpath = "//div[@id='container']/div[@class='monaco-editor vs-dark']")
    private WebElement layerBlockCode;

    @FindBy(xpath = "//div[@id='map']")
    private WebElement pathCodeBlockLayer;

    @FindBy(css = "[href='\\#\\/examples\\/layers\\/cluster\\/cluster']")
    private WebElement linkCluster;

    @FindBy(css = ".anchor span")
    private WebElement headCluster;

    @FindBy(css = ".sidebar")
    private WebElement slidebar;

    @FindBy(id="bottom")
    private WebElement buttonCluster;

    public void clickButtonCluster(){
        buttonCluster.click();
    }

    public void clickSlidebar() {
        slidebar.click();
    }

    public WebElement getLinkCluster() {
        return linkCluster;
    }

    public WebElement getHeadCluster() {
        return headCluster;
    }

    public void clickLinkCluster() {
        linkCluster.click();
    }

    public WebElement getPathCodeBlockLayer() {
        return pathCodeBlockLayer;
    }

    public WebElement getLayerBlockCode() {
        return layerBlockCode;
    }

    public WebElement getCheckLink() {
        return checkLink;
    }

    public WebElement getReadmeResource() {
        return readmeResource;
    }

    public WebElement getReadmeBegin() {
        return readmeBegin;
    }

    public WebElement getReadmeBlockCode() {
        return readmeBlockCode;
    }

    public void clickGivinLayerWMS() {
        givinLayerWMS.click();
    }
}
