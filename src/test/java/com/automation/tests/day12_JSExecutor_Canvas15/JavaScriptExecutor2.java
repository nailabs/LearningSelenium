package com.automation.tests.day12_JSExecutor_Canvas15;

import com.automation.tests.day11_canvas14_Actions.JavaScriptExecutor;
import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptExecutor2 {

    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.createDriver("Chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void verifyTitle() {
        String expected = "Practice";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String actual = (String) js.executeScript("return document.title");
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void clickTest() {
        WebElement link = driver.findElement(By.linkText("Multiple Buttons"));

//        disable this click action ,to perform it with js executor
//        link.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        //after "" you can list webelements that will be used
        //as part of your javascript code
        //it's varargs, so you can list 0+
        //arguments - listed after ,
        //use index to get specific webelement
        // WebElement arguments = {element, link, link2};
        //from left - to right
        js.executeScript("arguments[0].click()", link);// 0: first webelement after comma

        WebElement button6 = driver.findElement(By.id("disappearing_button"));

        js.executeScript("arguments[0].click()", button6);

        BrowserUtils.wait(2);

        WebElement result = driver.findElement(By.id("result"));

        Assert.assertEquals(result.getText(), "Now it's gone!");
    }

    @Test
    public void textInputTest() {
        //
        driver.findElement(By.linkText("Form Authentication")).click();
        BrowserUtils.wait(5);

        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement loginbtn = driver.findElement(By.id("wooden_spoon"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        //to get text from input box - read attribute "value"
        //to enter text - set attribute "value"
        //.setAttribute('value', 'text') - enter some text
        js.executeScript("arguments[0].setAttribute('value', 'tomsmith')", username);
        js.executeScript("arguments[0].setAttribute('value', 'SuperSecretPassword')", password);
        js.executeScript("arguments[0].click()", loginbtn);

        JavaScriptExecutor js2 = (JavaScriptExecutor) driver;

        BrowserUtils.wait(4);
        String expected = "Welcome to the Secure Area. When you are done click logout below.";
        String subheader = js.executeScript("return document.getElementsByClassName('subheader')[0].textContent").toString();


        Assert.assertEquals(subheader, expected);
    }

    @Test
    public void scrollToElement() {
        BrowserUtils.wait(5);

        //href = link, URL
        WebElement link = driver.findElement(By.linkText("Cybertek School"));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].scrollIntoView(true)", link);
    }

    @Test
    public void scrollTest() {
        driver.navigate().to("http://practice.cybertekschool.com/infinite_scroll");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (int i = 0; i < 15; i++) {
            js.executeScript("window.scrollBy(0, 1000)");
            BrowserUtils.wait(1);
        }

    }


    @AfterMethod
    public void teardown() {
        BrowserUtils.wait(3);
        driver.quit();
    }
}
