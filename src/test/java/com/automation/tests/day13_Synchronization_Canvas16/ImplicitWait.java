package com.automation.tests.day13_Synchronization_Canvas16;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ImplicitWait {
    private WebDriver driver;

    @BeforeMethod
    private void setup() {
        driver = DriverFactory.createDriver("Chrome");
        driver.get("http://practice.cybertekschool.com/dynamic_loading/2");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }

    @Test
    public void waitTest() {
    driver.findElement(By.tagName("button")).click();
        WebElement finishElement = driver.findElement(By.id("finish"));
        System.out.println(finishElement.getText());
//not a good practice to use thread.sleep. These are better
    }
}
