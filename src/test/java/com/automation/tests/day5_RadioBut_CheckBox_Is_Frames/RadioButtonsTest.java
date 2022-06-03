package com.automation.tests.day5_RadioBut_CheckBox_Is_Frames;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadioButtonsTest {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createDriver("chrome");//webdriver is an interface
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        BrowserUtils.wait(2);
        WebElement blackb = driver.findElement(By.id("black"));

        if (blackb.isDisplayed()&&blackb.isEnabled()) {
            blackb.click();
        }
        if (blackb.isSelected()){
            System.out.println("TEST PASSED!");
        }else{
            System.out.println("TEST FAILED");
        }

        driver.quit();


    }
}
