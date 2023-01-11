package testConfiguration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Config
{
    public static WebDriver driver;
    public String url[] = new String[] {"https://www.amazon.com/","",""};

    public void masterSetup()
    {
    String path ="chromedriver.exe";
    System.setProperty("webdriver.chrome.driver",path);
    driver = new ChromeDriver();
    //Maximize browser window
    driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(this.url[0]);
    }

    public void masterTearDown() {
    driver.quit();
    }
}
