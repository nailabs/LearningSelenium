package com.automation.tests.day5_RadioBut_CheckBox_Is_Frames;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FileUploading {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createDriver("chrome");

        driver.get("http://practice.cybertekschool.com/upload");
        BrowserUtils.wait(2);
        WebElement upload = driver.findElement(By.id("file-upload"));
        String filePath = System.getProperty("user.dir") + "/pom.xml";
        upload.sendKeys(filePath);
        BrowserUtils.wait(3);
        driver.findElement(By.id("file-submit"));
        BrowserUtils.wait(3);

        driver.quit();
    }
}
