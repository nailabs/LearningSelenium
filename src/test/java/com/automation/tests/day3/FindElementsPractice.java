package com.automation.tests.day3;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FindElementsPractice {
    public static void main(String[] args) throws InterruptedException {
        //WebDriverManager.chromedriver().setup();
        //WebDriver driver = new ChromeDriver();

        WebDriver driver = DriverFactory.createAdriver("chrome");
        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement fullName = driver.findElement(By.name("full_name"));
        fullName.sendKeys("Mister Twister");

        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("nailya@yours.com");

        WebElement signUp = driver.findElement(By.name("wooden_spoon"));
        signUp.click();
        Thread.sleep(5000);
        driver.quit();

    }
}
