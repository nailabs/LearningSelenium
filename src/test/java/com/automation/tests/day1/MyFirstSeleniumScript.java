package com.automation.tests.day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyFirstSeleniumScript {
    public static void main(String[] args) {

//setup chromedriver
        WebDriverManager.chromedriver().setup();

        //create chromedriver object
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://google.com");
        System.out.println("Hi");



    }
}
