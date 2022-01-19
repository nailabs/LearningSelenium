package com.automation.tests.day4_Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class VerifyThatElementIsGone {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        Thread.sleep(2000);

        driver.findElement(By.id("disappearing_button")).click();
        Thread.sleep(2000);

        if (driver.findElements(By.id("disappearing_button")).size() == 0) {  ///findelements is a collection //or.listEmpty ok too
            System.out.println("Test passed, button is removed from collection");
        } else {
            System.out.println("Test failed");
        }
       Thread.sleep(2000);
        List<WebElement> buttons = driver.findElements(By.tagName("button"));

        for (WebElement button: buttons){
            button.click();
            Thread.sleep(2000);
        }

        //System.out.println(buttons);
        driver.quit();

    }
}