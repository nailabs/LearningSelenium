package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://google.com");
        Thread.sleep(2000);
        WebElement search = driver.findElement(By.name("q"));
        search.sendKeys("Java", Keys.ENTER);
        Thread.sleep(6000);

        WebElement news = driver.findElement(By.linkText("Новости"));
        news.click();
        Thread.sleep(4000);
        driver.quit();

    }
}
