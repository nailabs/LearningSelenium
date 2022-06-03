package com.automation.tests.day13_Synchronization_Canvas16;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WarmUp {
    WebDriver driver = DriverFactory.createDriver("Chrome");

    @BeforeMethod
    public void setup() {
        driver.get("http://practice.cybertekschool.com/tables");
        driver.manage().window().maximize();
        BrowserUtils.wait(3);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void sortLastNameAlphabetically() {
        WebElement lastName = driver.findElement (By.xpath("//*[@id=\"table1\"]/thead/tr/th[1]/span"));
        lastName.click();
        BrowserUtils.wait(3);

        List<WebElement> column = driver.findElements(By.xpath("//table[1]//tbody//td[1]"));
        for (int i = 0; i <column.size()-1 ; i++) {
            String value = column.get(i).getText();
            String nextValue = column.get(i + 1).getText();
            Assert.assertTrue(value.compareTo(nextValue) <= 0);
        }
    }
}
