package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
       // RemoteWebDriver driverF = new FirefoxDriver();//polymorphism from parent class
        driver.get("http://google.com");//to open


    }
}