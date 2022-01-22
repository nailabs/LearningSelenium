package com.automation.tests.day7_CSSLocators_XPath;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Xpath {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createAdriver("chrome");
        driver.get("http://practice.cybertekschool.com/login");
        driver.findElement(By.xpath("//label[text() = 'Username']/following-sibling::input"));
        driver.findElement(By.xpath("//label[text() = 'Password']/following-sibling::input"));
        //label[text()='Username']/following-sibling::input
        BrowserUtils.wait(1);

        driver.findElement(By.xpath("//button[@type = 'submit' or @id ='wooden_spoon']"));
        driver.findElement(By.xpath("//button[@type = 'submit' and @id ='wooden_spoon']"));

        BrowserUtils.wait(1);
        driver.quit();
    }
}
