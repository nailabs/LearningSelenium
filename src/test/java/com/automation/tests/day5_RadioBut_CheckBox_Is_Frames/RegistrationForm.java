package com.automation.tests.day5_RadioBut_CheckBox_Is_Frames;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class RegistrationForm {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/registration_form");
        driver.findElement(By.name("firstname")).sendKeys("Naila");
        driver.findElement(By.name("lastname")).sendKeys("Urman");
        driver.findElement(By.name("username")).sendKeys("hellouu");
        driver.findElement(By.name("email")).sendKeys("naila@you.com");
        driver.findElement(By.name("password")).sendKeys("worldbetter");
        driver.findElement(By.name("phone")).sendKeys("123-456-7898");
        //gender:
        List<WebElement> gender = driver.findElements(By.name("gender"));
        gender.get(1).click();

        driver.findElement(By.name("birthday")).sendKeys("01/01/2001");
        driver.findElement(By.id("inlineCheckbox2")).click();
        BrowserUtils.wait(2);
        driver.findElement(By.id("wooden_spoon")).click();
        BrowserUtils.wait(2);
        driver.quit();
    }
}
