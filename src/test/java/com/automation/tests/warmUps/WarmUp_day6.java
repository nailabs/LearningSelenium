package com.automation.tests.warmUps;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WarmUp_day6 {

    static WebDriver driver;

    public static void main(String[] args) throws Exception {
        //WebDriverManager.chromedriver().setup();
        //ChromeDriver driver = new ChromeDriver();
        ebayTest();
        amazonTest();
        wikiTest();
    }

    public static void ebayTest() throws InterruptedException {

        driver = DriverFactory.createDriver("chrome");
        driver.get("https://www.ebay.com/");
        driver.manage().window().maximize();
        driver.findElement(By.id("gh-ac")).sendKeys("java book");
        driver.findElement(By.id("gh-btn")).click();
        Thread.sleep(1000);
        WebElement searchResults = driver.findElement(By.tagName("h1"));
        System.out.println(searchResults.getText().split(" ")[0]);//to print number only
        Thread.sleep(1000);
        driver.quit();
    }

    public static void amazonTest() throws Exception {

        driver = DriverFactory.createDriver("chrome");
        driver.get("https://www.amazon.com/");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java book");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ENTER);
        String title = driver.getTitle();

        if (title.contains("java book")) {
            System.out.println("Passed");
        } else {
            System.out.println("failed");
        }
        Thread.sleep(1000);
        driver.quit();
    }

    public static void wikiTest() throws InterruptedException {
        driver = DriverFactory.createDriver("chrome");
        driver.get("https://www.wikipedia.org/");
        driver.findElement(By.id("searchInput")).sendKeys("Selenium(software)",Keys.ENTER);
        Thread.sleep(1000);
        String link = driver.getCurrentUrl();
        System.out.println(link);
    if (link.endsWith("Selenium(software)")){
        System.out.println("good job, wiki!");
    }else{
        System.out.println("dumb");
    }
    driver.quit();
    }

}