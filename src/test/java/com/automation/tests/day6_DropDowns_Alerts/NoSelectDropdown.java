package com.automation.tests.day6_DropDowns_Alerts;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class NoSelectDropdown {

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(1);
        driver.findElement(By.id("dropdownMenuLink")).click();//to expand
        BrowserUtils.wait(1);


        List<WebElement> allLinks = driver.findElements(By.className("dropdown-item"));
        for (WebElement link : allLinks) {
            System.out.println(link.getText() + " : " + link.getAttribute("href"));
        }
        driver.findElement(By.linkText("Amazon")).click();
        //  BrowserUtils.wait(0);
        driver.quit();
    }
}
