package com.automation.tests.day13_Synchronization_Canvas16;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebOrders {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setup() {

        driver = DriverFactory.createDriver("Chrome");
        wait = new WebDriverWait(driver, 10);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
        BrowserUtils.wait(3);
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();
        BrowserUtils.wait(3);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void checkBoxTest() {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement btn = driver.findElement(By.id("ctl00_MainContent_btnCheckAll"));
        btn.click();
        BrowserUtils.wait(3);
        List<WebElement> checkBoxes = driver.findElements(By.cssSelector("input [type='checkbox']")); //or by css selector: input [type='checkbox']
        for(WebElement checkBox :checkBoxes){
            BrowserUtils.wait(3);
            Assert.assertTrue(checkBox.isSelected());
    }
    }
    @Test
    public void updateZipCode(){

        WebDriverWait wait = new WebDriverWait(driver, 10);
        String originalZip = driver.findElement(By.xpath("//tbody/tr[4]/td[9]")).getText();
        driver.findElement(By.xpath("//tbody/tr[4]/td[13]")).click();
        WebElement field = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5"));
        field.clear();
        field.sendKeys("20002");
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_UpdateButton")).click();
        String expected = "20002";
        String changedZip = driver.findElement(By.xpath("//tbody/tr[4]/td[9]")).getText();

        Assert.assertEquals(changedZip, expected);

    }
}