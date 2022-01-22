package com.automation.tests.day6_DropDowns_Alerts;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class XPath {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createAdriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        WebElement btn = driver.findElement(By.xpath("//button[@onclick='button1()']"));
        btn.click();
        WebElement result = driver.findElement(By.id("result"));
        System.out.println(result.getText());
        WebElement btn2 = driver.findElement(By.xpath("//button[text() ='Button 2']"));
        btn2.click();

        WebElement btn4 = driver.findElement(By.xpath("//button[contains(@id,'_button')]"));
                /*
                  From top to bottom to find the sibling:
               //label[text()='Username']/following-sibling::input
              //label[text()='Username']/preceding-sibling::input
                 */
        BrowserUtils.wait(2);
        driver.quit();
    }
}
