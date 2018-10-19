package pages.docs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPageDocs {

    public WebDriver driver;

    public MainPageDocs(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver=driver;
    }

    @FindBy (id="Ресурсы")
    private WebElement readmeResource;

    @FindBy(id="Старт")
    private WebElement readmeBegin;

    @FindBy (css = ":nth-child(10) .lang-html")
    private WebElement readmeBlockCode;

    @FindBy (linkText = "Получение слоев (WMS)")
    private WebElement givinLayerWMS;

    @FindBy (css = "[href='https\\:\\/\\/gost-jira\\.atlassian\\.net\\/wiki\\/spaces\\/EGIPAPIDOC\\/pages\\/436699311\\/API']")
    private WebElement checkLink;

    @FindBy(id="container")
    private WebElement layerBlockCode;

    @FindBy (xpath = "//div[@id='map']")
    private WebElement pathCodeBlockLayer;

    public WebElement getPathCodeBlockLayer(){
        return pathCodeBlockLayer;
    }

    public WebElement getLayerBlockCode(){
        return layerBlockCode;
    }

    public WebElement getCheckLink(){
        return checkLink;
    }

    public WebElement getReadmeResource(){
        return readmeResource;
    }

    public WebElement getReadmeBegin(){
        return readmeBegin;
    }

    public WebElement getReadmeBlockCode() {
        return readmeBlockCode;
    }

    public void clickGivinLayerWMS(){
        givinLayerWMS.click();
    }
}
