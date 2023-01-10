package RunManually;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testConfiguration.Config;

import static testConfiguration.Config.driver;

public class AutomationTest {
private final Config conf = new Config();
    @BeforeTest
    public void launchSite() {conf.masterSetup();}
    @Test(priority = 1)
    public void SearchItem() throws InterruptedException
    {
        //search product using keyword
        Thread.sleep(2000);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Lenovo IdeaPad Gaming 3 - 2022 - Everyday Gaming Laptop");
        driver.findElement(By.id("nav-search-submit-button")).click();

        Thread.sleep(2000);
        //verify search result mapping searched keyword
        Assert.assertEquals("\"Lenovo IdeaPad Gaming 3 - 2022 - Everyday Gaming Laptop\"",driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/h1/div/div[1]/div/div/span[3]")).getText());

        //select item by item name
        WebElement itemLink = driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal' and contains(text(),'Lenovo IdeaPad Gaming 3 - 2022 - Everyday Gaming Laptop - NVIDIA GeForce RTX 3050 Graphics - 15.6\" FHD Display - 120 Hz - AMD Ryzen 5 6600H - 8GB DDR5 - 258GB SSD - Win 11 - Free 3-month Xbox GamePass')]"));
        itemLink.click();

        //configure options for locations issues
        driver.findElement(By.xpath("//*[@id=\"contextualIngressPtLabel_deliveryShortLine\"]")).click();
        driver.findElement(By.id("GLUXZipUpdateInput")).sendKeys("85726");
        driver.findElement(By.xpath("//*[@id=\"GLUXZipUpdate\"]/span/input")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[8]/div/div/div[2]/span/span/input")).click();
        Thread.sleep(2000);
    }
    @Test(priority = 2)
    public void AddToCart() throws InterruptedException {
        //Add item to cart
        driver.findElement(By.id("add-to-cart-button")).click();
        driver.findElement(By.xpath("//*[@id=\"attachSiNoCoverage\"]/span/input")).click();

        //navigate back to cart
        driver.findElement(By.xpath("//*[@id=\"attach-sidesheet-view-cart-button\"]/span/input")).click();
    }
    @AfterTest
    public void tearDown() {
        conf.masterTearDown();
    }


}
