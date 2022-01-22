package com.automation.tests.day6_DropDowns_Alerts;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByText {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createAdriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(1);
        WebElement simpleDropDown = driver.findElement(By.id("dropdown"));
        Select selectSimpleDropDown = new Select(simpleDropDown);   // make sure it's seleniuum import for 'Select' class
        selectSimpleDropDown.selectByVisibleText("Option 2");
        BrowserUtils.wait(1);

        Select selectYear = new Select(driver.findElement(By.id("year")));
        Select selectMonth = new Select(driver.findElement(By.id("month")));
        Select selectDay = new Select(driver.findElement(By.id("day")));

        selectDay.selectByVisibleText("13");
        selectMonth.selectByVisibleText("February");
        selectYear.selectByVisibleText("2022");

        List<WebElement> months = selectMonth.getOptions();
        for (WebElement month : months) {
            selectMonth.selectByVisibleText(month.getText());
            System.out.println(month.getText());
        }
        Select stateSelect = new Select(driver.findElement(By.id("state")));
        stateSelect.selectByVisibleText("Alabama");
        String selected = stateSelect.getFirstSelectedOption().getText();
        System.out.println(selected);

        List<WebElement> states = stateSelect.getOptions();
        for (WebElement state : states) {
            System.out.println(state.getText());
        }

        BrowserUtils.wait(1);
        driver.quit();
    }
}
