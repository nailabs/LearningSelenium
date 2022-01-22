package com.automation.tests.day6_DropDowns_Alerts;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Alerts {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        BrowserUtils.wait(1);

        List<WebElement> buttons = driver.findElements(By.tagName("button"));
        buttons.get(0).click();
        String popUptext = driver.switchTo().alert().getText();
        System.out.println(popUptext);
        driver.switchTo().alert().accept();
        String actual = driver.findElement(By.id("result")).getText();
        System.out.println(actual);

        BrowserUtils.wait(1);

        buttons.get(1).click();//index
        BrowserUtils.wait(1);
        driver.switchTo().alert().dismiss();

        buttons.get(2).click();
        BrowserUtils.wait(1);
        driver.switchTo().alert().sendKeys("Hello World");
        BrowserUtils.wait(3);
        driver.switchTo().alert().accept();
        String actual2 = driver.findElement(By.id("result")).getText();
        String expected2 = "Hello World";

        if (actual2.endsWith(expected2)) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }

        BrowserUtils.wait(1);
        driver.quit();
    }

}
