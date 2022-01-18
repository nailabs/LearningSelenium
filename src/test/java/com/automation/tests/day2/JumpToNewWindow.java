package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class JumpToNewWindow {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/open_new_tab");
        Thread.sleep(4000);
        String windowHandle1 = driver.getWindowHandle(); //window's od is handle
        System.out.println(windowHandle1);
        Set<String> allWindowHandles2 = driver.getWindowHandles();
        System.out.println(allWindowHandles2);
        System.out.println("before switch: " + driver.getCurrentUrl());
        for (String windowId : allWindowHandles2) {
            if (!windowId.equals(windowHandle1))
                driver.switchTo().window(windowId);
        }
        System.out.println("After switch: " + driver.getCurrentUrl());

        driver.quit();
    }

    public static void switchToWindowBasedOnTitle(String pageTitle, WebDriver driver){
        Set<String> windows = driver.getWindowHandles();
        for (String window1:windows){
            driver.switchTo().window(window1);
            if (driver.getTitle().equals(pageTitle)){
                break;
            }
        }




    }
}
