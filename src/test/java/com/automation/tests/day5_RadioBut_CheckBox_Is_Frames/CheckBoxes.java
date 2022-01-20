package com.automation.tests.day5_RadioBut_CheckBox_Is_Frames;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckBoxes {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/checkboxes");
        BrowserUtils.wait(2);

        List<WebElement> checkBoxes = driver.findElements(By.tagName("input"));
        // checkBoxes.get(1).click(); //we can use isSelected
        for (int i = 0; i < checkBoxes.size(); i++) {
                                // if visible             if eligible to click             if not checked
            if (checkBoxes.get(i).isDisplayed() && checkBoxes.get(i).isEnabled() && (!checkBoxes.get(i).isSelected())) {
                checkBoxes.get(i).click();
                System.out.println(i + 1 + " was clicked");
            } else {
                System.out.println(i + 1 + " wasn't clicked");
            }
            BrowserUtils.wait(2);
            System.out.println("test");
            driver.quit();
        }
    }
}