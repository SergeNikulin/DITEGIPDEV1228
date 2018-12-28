package pages.gis;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Zabbix {
    public WebDriver driver;

    public Zabbix(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy (xpath = "//ul[@id='sub_view']//a[@href='charts.php?ddreset=1']")
    WebElement graphs;

    @FindBy (xpath = "/html//select[@id='graphid']")
    WebElement graphsSelect;

    @FindBy(xpath = "//select[@id='graphid']/option[@value='525']")
    WebElement utilizationCPU;

    @FindBy (xpath = "/html//img[@id='graph_full']")
    WebElement graphFull;

    @FindBy (xpath = "//body//div[@class='header-title table']/div[@class='cell nowrap']/ul//form[@action='charts.php']/ul//select[@name='hostid']")
    WebElement selectHostid;

    @FindBy (xpath = "//body//div[@class='cell nowrap']/ul//form[@action='charts.php']/ul//select[@name='hostid']/option[@value='10262']")
    WebElement selectEGIPDBS02T;

    @FindBy (xpath = "//select[@id='graphid']/option[@value='833']")
    WebElement networkTraffic;

    public void selectNetworkTraffic(){
        networkTraffic.click();
    }

    public void clickSeclectEGIPDBS02T(){
        selectEGIPDBS02T.click();
    }

    public void clickSelectHostid(){
        selectHostid.click();
    }

    public WebElement getGraphFull(){
        return graphFull;
    }

    public void clickGraphs(){
        graphs.click();
    }

    public void clickGraphsSelect(){
        graphsSelect.click();
    }

    public void clickUtilizationCPU(){
        utilizationCPU.click();
    }
}
