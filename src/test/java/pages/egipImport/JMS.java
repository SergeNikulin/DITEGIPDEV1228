package pages.egipImport;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JMS extends FromTables {

    public JMS (WebDriver driver){
        super(driver);
    }

    @FindBy (linkText = "JMS")
    private WebElement linkJMS;

    @FindBy (css = "[rows]")
    private WebElement textArea;

    @FindBy (css = "[role] .custom-control-inline:nth-of-type(2) span")
    private WebElement radioButtonFirst;

    @FindBy (css = "[type='button']")
    private WebElement buttonSend;

    @FindBy (xpath = "//div[@id='__BVID__3__BV_tab_container_']/div[4]//div[@role='alert']")
    private WebElement resultMessage;

    public void clickLinkJMS(){
        linkJMS.click();
    }

    public void setTextArea(String string) {
        textArea.sendKeys(string);
    }

    public void clickRadioButtonFirst(){
        radioButtonFirst.click();
    }

    public void clickButtonSend(){
        buttonSend.click();
    }

    public String getResultMessage(){
        return resultMessage.getText();
    }
}
