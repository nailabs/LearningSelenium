package com.automation.tests.day4_Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindElementsTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().driverVersion("79").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/");
        Thread.sleep(3000);

        //how to collect all the links from the page.

        List<WebElement> links = driver.findElements(By.tagName("a"));//pay attention to plural
        for (WebElement link : links) {
            System.out.println(link.getText());
            System.out.println(link.getAttribute("href"));//attribute
            System.out.println();//for extra space btw the lines

            for (int i = 1; i < links.size(); i++) {//skipping the first link, coz its home page link
                links.get(i).click();
                //Thread.sleep(2000);
                driver.navigate().back();
                //Thread.sleep(2000);
                links = driver.findElements(By.tagName("a"));
            }
//            link.click();
            //          Thread.sleep(2000);
            //        driver.navigate().back(); doesn't work, stale exception.
        }
        driver.quit();
    }
}
