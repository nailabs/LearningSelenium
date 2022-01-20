package com.automation.tests.day5_RadioBut_CheckBox_Is_Frames;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckBoxesTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/checkboxes");

        List<WebElement> checkboxes = driver.findElements(By.tagName("input"));

        if(!checkboxes.get(0).isSelected()&& checkboxes.get(1).isSelected()){
            System.out.println("Test passed");
        }else{
            System.out.println("Test failed");
        }

        /*for (int i = 0; i < checkboxes.size(); i++) {
            if (i == 0 && (checkboxes.get(i).isSelected())) {
                checkboxes.get(i).click();
                System.out.println("first is unselected");
                BrowserUtils.wait(4);
            }else if(i == 1 && (!checkboxes.get(i).isSelected())) {
                checkboxes.get(i).click();
            } System.out.println("second is selected");
        }*/

        BrowserUtils.wait(4);
        driver.quit();

    }
}
