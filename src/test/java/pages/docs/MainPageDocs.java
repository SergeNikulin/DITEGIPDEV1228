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

    public WebElement getReadmeResource(){
        return readmeResource;
    }

    public WebElement getReadmeBegin(){
        return readmeBegin;
    }

    public WebElement getReadmeBlockCode() {
        return readmeBlockCode;
    }
}
