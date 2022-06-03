package com.automation.tests.day10_VytrackPractice;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class WarmUpMyOwn {

    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");
    public WebDriver driver = DriverFactory.createDriver("chrome");
    private Actions actions;
    private String storemanagerUserName = "storemanager85";
    private String storemanagerPassword = "UserUser123";
    private By activitiesBy = By.xpath("//span[@class='title title-level-1' and contains(text(),'Activities')]");
    private By logCallBtnBy = By.cssSelector("a[title='log call']");

    @Test
    public void WarmUpMyOwn() {

        driver.get("https://qa2.vytrack.com/user/login");
        driver.manage().window().maximize();
        BrowserUtils.wait(5);
        driver.findElement(usernameBy).sendKeys(storemanagerUserName);
        BrowserUtils.wait(3);
        driver.findElement(passwordBy).sendKeys(storemanagerPassword, Keys.ENTER);

        BrowserUtils.wait(3);
        actions.clickAndHold(driver.findElement(activitiesBy));
        BrowserUtils.wait(3);
        driver.findElement(By.linkText("Calls")).click();
        BrowserUtils.wait(5);
        driver.quit();
    }
}