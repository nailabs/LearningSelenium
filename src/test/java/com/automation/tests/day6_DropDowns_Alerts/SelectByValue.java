package com.automation.tests.day6_DropDowns_Alerts;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectByValue {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(1);

        Select selectState = new Select(driver.findElement(By.id("state")));
        selectState.selectByValue("DC");
        String expected = "District Of Columbia";
        String actual = selectState.getFirstSelectedOption().getText();

        if (expected.equals(actual)) {
            System.out.println("Test passed");
        } else {
            System.out.println("test failed");
        }
        BrowserUtils.wait(1);


        //List<WebElement> allLinks = driver.findElements(By.className("dropdown-item"));
        //for (WebElement link : allLinks){
        //  System.out.println(link.getText()+" : "+link.getAttribute("href"));
        //}

        BrowserUtils.wait(0);
        driver.quit();
    }
}

