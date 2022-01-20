package com.automation.tests.day5_RadioBut_CheckBox_Is_Frames;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Frames {
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createAdriver("chrome");
        driver.get("http://practice.cybertekschool.com/iframe");

        BrowserUtils.wait(4);

        //we need to switch to iframe before webelement
        driver.switchTo().frame("mce_0_ifr");

        WebElement foundIframe = driver.findElement(By.id("tinymce"));
        System.out.println(foundIframe.getText());

        BrowserUtils.wait(2);

        foundIframe.clear();
        foundIframe.sendKeys("Hello World");

        BrowserUtils.wait(2);

        driver.switchTo().defaultContent();

        WebElement heading = driver.findElement(By.tagName("h3"));
        System.out.println(heading.getText());

        driver.quit();
    }
}
