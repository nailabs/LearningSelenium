package com.automation.tests.vytrack.fleet;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


public class VehiclesTests {

    private WebDriver driver;
    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");
    private String username = "storemanager85";
    private String password = "UserUser123";
    public String url = "https://qa2.vytrack.com/user/login";
    private By fleetBy = By.xpath("//span[@class='title title-level-1' and contains(text(),'Fleet')]");
    private By allVehicles = By.linkText("Vehicles");

    @Test(description = "Verify Page SubTitle")
    public void CheckTitle(){

        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);
        BrowserUtils.wait(3);
        //driver.findElement(fleetBy).click();
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(fleetBy)).perform();
        BrowserUtils.wait(3);

        //driver.findElement(allVehicles).click();
        BrowserUtils.wait(10);
        actions.moveToElement(driver.findElement(allVehicles)).perform();

        String text = driver.findElement(By.className("oro-subtitle")).getText();
        System.out.println(text);
        BrowserUtils.wait(10);
        assertTrue(text.equalsIgnoreCase("All cars"));
    }

    @Test
    public void VerifyPageNumber(){

        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);
        BrowserUtils.wait(3);
        //driver.findElement(fleetBy).click();
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(fleetBy)).perform();
        BrowserUtils.wait(3);

        //driver.findElement(allVehicles).click();
        BrowserUtils.wait(10);
        actions.moveToElement(driver.findElement(allVehicles)).perform();

        String text = driver.findElement(By.xpath("//label[text()='Page:']/..//input")).getText();
        BrowserUtils.wait(10);
        assertTrue(text.contains("1"));

    }
//*****************************PROBLEMS, THIS CLASS DOES NOT WORK**************************************
    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        BrowserUtils.wait(3);
    }

    @AfterMethod
    public void tearDown() {
        BrowserUtils.wait(10);
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
