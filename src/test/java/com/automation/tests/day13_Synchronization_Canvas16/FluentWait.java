package com.automation.tests.day13_Synchronization_Canvas16;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.function.Function;

public class FluentWait {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.createDriver("Chrome");
    }

    @AfterMethod
    public void teardow() {
        driver.quit();
    }

    @Test
    public void fluentWaitTest() {
        driver.get("http://practice.cybertekschool.com/dynamic_loading/6");
        Wait<WebDriver> wait = new org.openqa.selenium.support.ui.FluentWait<>(driver).
                withTimeout(Duration.ofSeconds(10)).
                pollingEvery(Duration.ofSeconds(5)).
                ignoring(NoSuchElementException.class).//at least nosuchel exception has to be put. you can use others too
                ignoring(ElementClickInterceptedException.class);

        WebElement submitBtn = wait.until(new Function<WebDriver, WebElement>(){// function is anonymous class
            @Override
            public WebElement apply(WebDriver Webdriver){
                return driver.findElement(By.xpath("//button[text()='Submit']"));
            }
        });
    }

}

