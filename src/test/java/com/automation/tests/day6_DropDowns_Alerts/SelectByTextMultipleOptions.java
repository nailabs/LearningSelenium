package com.automation.tests.day6_DropDowns_Alerts;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByTextMultipleOptions {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createAdriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(1);

        Select languagesSelect = new Select(driver.findElement(By.name("Languages")));
        boolean isMultipleHUH = languagesSelect.isMultiple();
        System.out.println(isMultipleHUH);

        languagesSelect.selectByVisibleText("Java");
        languagesSelect.selectByVisibleText("Python");
        languagesSelect.selectByVisibleText("JavaScript");

        List<WebElement> selectedLangs = languagesSelect.getAllSelectedOptions();
        for (WebElement oneSelectedLang : selectedLangs) {
            System.out.println(oneSelectedLang.getText());
        }
        languagesSelect.deselectByVisibleText("Python");
        List<WebElement> selectedLangs2 = languagesSelect.getAllSelectedOptions();
        for (WebElement oneSelectedLang2 : selectedLangs2) {
            System.out.println(oneSelectedLang2.getText());
        }
        BrowserUtils.wait(1);
        driver.quit();
    }
}
