package RunManually;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testConfiguration.Config;

import static org.testng.Assert.assertEquals;
import static testConfiguration.Config.*;

public class AutomationTest {
    private final Config conf = new Config();

    @BeforeTest
    public void launchSite() {
        conf.masterSetup();
    }

    @Test(priority = 1)
    public void SearchItem() throws InterruptedException {

    //search product using keyword
    Thread.sleep(2000);
    WebElement SearchItem = driver.findElement(By.id("twotabsearchtextbox"));
    SearchItem.sendKeys("The Ultimate Coach");
    WebElement Submit = driver.findElement(By.id("nav-search-submit-button"));
    Submit.click();
    Thread.sleep(2000);
    //verify search result mapping searched keyword
    assertEquals("\"The Ultimate Coach\"", driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/h1/div/div[1]/div/div/span[3]")).getText());

    //select item by item name
    WebElement itemLink = driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal' and contains(text(),'The Ultimate Coach')]"));
    itemLink.click();

//    Configure options for locations issues in case add to cart option is not available because of location
//    WebElement DLink = driver.findElement(By.xpath("//*[@id=\"contextualIngressPtLabel_deliveryShortLine\"]"));
//    DLink.click();
//    driver.findElement(By.id("GLUXZipUpdateInput")).sendKeys("11580");Thread.sleep(1000);
//    WebElement AddressUpdate = driver.findElement(By.xpath("//*[@id=\"GLUXZipUpdate\"]/span/input"));
//    AddressUpdate.click();
//
//    WebElement Apply = driver.findElement(By.xpath("//*[@id=\"GLUXZipUpdate\"]/span/input"));
//    Apply.click();
//    WebElement Continue = driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/span/span/input"));
//    Continue.click();


    //Add item to cart
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollBy(0,150)");
    Thread.sleep(2000);
    driver.findElement(By.id("add-to-cart-button")).click();

    //navigate back to cart
    WebElement BackToCart = driver.findElement(By.xpath("//*[@id=\"sw-gtc\"]/span/a"));
    BackToCart.click();

    //verify the item name to verify  same item is in cart as searched one
    Assert.assertEquals("The Ultimate Coach",driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[3]/div[3]/div/div[2]/div[1]/div/form/div[2]/div[3]/div[4]/div/div[2]/ul/li[1]/span/a/span[1]/span/span[2]")).getText());

    //or
    String ActualProduct = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[3]/div[3]/div/div[2]/div[1]/div/form/div[2]/div[3]/div[4]/div/div[2]/ul/li[1]/span/a/span[1]/span/span[2]")).getText();

    if(ActualProduct.equals("The Ultimate Coach"))
        {
            System.out.println("Book added in cart is correct");
        }
    else{
            System.out.println("Book added in cart is incorrect");
    }
    Thread.sleep(4000);
        }

        @AfterTest
        public void tearDown () {
        conf.masterTearDown();
        }

    }

