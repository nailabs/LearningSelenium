package com.automation.tests.day8_TestNG;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SearchTests {

    @Test
    public void googleSearchTest() {
        driver.get("http://google.com");
        driver.findElement(By.name("q")).sendKeys("java", Keys.ENTER);
        BrowserUtils.wait(3);
        List<WebElement> searchItems = driver.findElements(By.tagName("h3"));
        for (WebElement searchItem : searchItems) {
            // System.out.println(searchItem.getText());
            String var = searchItem.getText();
            if (!var.isEmpty()) {
                System.out.println(var);
                Assert.assertTrue(var.toLowerCase().contains("java"));
            }
        }
    }

    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        //setup webdriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void tearDown() {
        //close browser and destroy webdriver object
        driver.quit();
    }

    @Test(description = "Search for Java book on Amazon")
    public void AmazonSearchTest() {
        driver.get("https://www.amazon.com/");

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);
        BrowserUtils.wait(3);
        List<WebElement> searchItems = driver.findElements(By.xpath("//h2/a"));
        System.out.println(searchItems.get(0).getText()+"==================================================================================================================================================================================");
        searchItems.get(0).click();

        BrowserUtils.wait(5);
        WebElement productTitle = driver.findElement(By.id("title"));
        String productTitleString = productTitle.getText();
        System.out.println(productTitleString);
        Assert.assertTrue(productTitleString.contains("Java"));
        //i
        driver.quit();

    }
}