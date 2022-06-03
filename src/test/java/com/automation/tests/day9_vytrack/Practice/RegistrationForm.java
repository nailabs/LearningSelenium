package com.automation.tests.day9_vytrack.Practice;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationForm {

    private String url = "http://practice.cybertekschool.com/registration_form";
    private WebDriver driver;
    private By firstNameBy = By.name("firstname");
    private By lastNameBy = By.name("lastname");
    private By userNameBy = By.name("username");
    private By emailBy = By.name("email");
    private By passwordBy = By.name("password");
    private By phoneBy = By.name("phone");
    private By maleBy = By.cssSelector("input[value='male']");
    private By femaleBy = By.cssSelector("input[value='female']");
    private By DOBby = By.name("birthday");
    private By departmentBy = By.name("department");
    private By jobTitleBy = By.name("job_title");
    private By Java = By.xpath("//label[text()='Java']/preceding-sibling::input");
    private By signUpBy = By.id("wooden_spoon");

    @Test
    public void test1() {
        driver.findElement(firstNameBy).sendKeys("Patrick");
        driver.findElement(lastNameBy).sendKeys("White");
        driver.findElement(userNameBy).sendKeys("patrickbot");
        driver.findElement(passwordBy).sendKeys("password123");
        driver.findElement(emailBy).sendKeys("patrickmail@gmail.com");
        driver.findElement(phoneBy).sendKeys("772-456-7289");
        driver.findElement(DOBby).sendKeys("12/12/2018");
        driver.findElement(femaleBy).click();
        BrowserUtils.wait(5);
        Select departmentSelect = new Select(driver.findElement(departmentBy));
        departmentSelect.selectByVisibleText("Department of Agriculture");
        Select jobSelect = new Select(driver.findElement(jobTitleBy));
        jobSelect.selectByVisibleText("SDET");
        BrowserUtils.wait(5);
        driver.findElement(signUpBy).click();
        String expected = "You've successfully completed registration!";
        String actual = driver.findElement(By.tagName("p")).getText();
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void verifyFirstNameLength() {
        driver.findElement(firstNameBy).sendKeys("a");
        BrowserUtils.wait(3);
        WebElement warningMessage = driver.findElement(By.xpath("//small[text()='first name must be more than 2 and less than 64 characters long']"));
                Assert.assertTrue(warningMessage.isDisplayed());
    }




    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        BrowserUtils.wait(3);
        driver.quit();
    }
}
