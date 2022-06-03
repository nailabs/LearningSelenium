package com.automation.tests.day5_RadioBut_CheckBox_Is_Frames;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NestedFrame {
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/nested_frames");
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");
        WebElement content = driver.findElement(By.id("content"));
        System.out.println(content.getText());

        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-right");
        WebElement content2 = driver.findElement(By.tagName("body"));
        System.out.println(content2.getText());


        driver.switchTo().defaultContent();
        driver.quit();
    }
}
