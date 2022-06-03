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

public class LoginTest {

    public WebDriver driver;

    @BeforeMethod
    public void setup() {
        //setup webdriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void close() {
        //close browser and destroy webdriver object
        BrowserUtils.wait(2);
        driver.quit();
    }

    @Test
    public void Trying() {
        driver.get("http://practice.cybertekschool.com/login");
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword", Keys.ENTER);
        BrowserUtils.wait(2);
        String actual = driver.findElement(By.tagName("h4")).getText();
        String expected = "Welcome to the Secure Area. When you are done click logout below.";
        BrowserUtils.wait(2);
        Assert.assertEquals(actual, expected, "No match");
        BrowserUtils.wait(2);

    }


    @Test
    public void forgotPasswordTest() {
        driver.get("http://practice.cybertekschool.com/forgot_password");
        driver.findElement(By.name("email")).sendKeys("nana@nana.com", Keys.ENTER);
        BrowserUtils.wait(3);
        String expected = "Your e-mail's been sent!";
        String actual = driver.findElement(By.name("confirmation_message")).getText();
        Assert.assertEquals(actual, expected, "Message not valid`");
    }

    @Test
    public void CheckboxTest1() {
        driver.findElement(By.linkText("Checkboxes")).click();
        List<WebElement> boxes = driver.findElements(By.tagName("input"));
        BrowserUtils.wait(2);
        boxes.get(0).click();
        BrowserUtils.wait(2);
        Assert.assertTrue(boxes.get(0).isSelected(), "Checkbox 1 not selected");

    }
}




