package RunManually;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testConfiguration.Config;

public class AutomationTest {
private final Config conf = new Config();
    @BeforeTest
    public void launchSite() {conf.masterSetup();}
    @Test(priority = 1)
    public void SearchItem() throws InterruptedException
    {

    }
    @AfterTest
    public void tearDown() {
        conf.masterTearDown();
    }

}
