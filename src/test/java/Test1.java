import org.junit.Test;
import pages.BaseClass;
import utils.ConfigProperties;



public class Test1 extends BaseClass {

    @Test
    public void test1() throws Exception {
        driver.get(ConfigProperties.getTestProperty("clientApplicationModule"));
        Thread.sleep(5000);
    }
}
