package com.automation.tests.day6_DropDowns_Alerts;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class selectByIndex {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(1);

        Select selectByInd = new Select(driver.findElement(By.id("state")));
        selectByInd.selectByIndex(15);
        String actual = selectByInd.getFirstSelectedOption().getText();
        System.out.println(actual);

        BrowserUtils.wait(1);
        driver.quit();
    }
}


