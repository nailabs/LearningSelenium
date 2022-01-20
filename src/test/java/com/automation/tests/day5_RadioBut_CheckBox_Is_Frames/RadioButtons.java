package com.automation.tests.day5_RadioBut_CheckBox_Is_Frames;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class RadioButtons {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/radio_buttons");
        driver.manage().window().maximize();

        BrowserUtils.wait(2);
        List<WebElement> radioButtons = driver.findElements(By.tagName("input"));
        for (WebElement radiBut : radioButtons) {

            String id = radiBut.getAttribute("id") ;
            boolean selected = radiBut.isSelected();
            System.out.println(id+" is selected? "+ selected);

            if (radiBut.isEnabled()) {
                radiBut.click();
                System.out.println("Clicked on: "+id);
            BrowserUtils.wait(1);
        }else{
                System.out.println("Button is disabled");
            }
        }
        driver.quit();
    }
}
