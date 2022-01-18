package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {
    public static void main(String[] args) throws Exception {

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        // RemoteWebDriver driverF = new FirefoxDriver();//polymorphism from parent class
        driver.get("http://google.com");//to open
        driver.manage().window().maximize();
        Thread.sleep(4000);//wait for 4 sec
        String title = driver.getTitle();//returns the title of the page
        System.out.println("This is title: " + title);
        String expectedTitle = "Google";
        if (expectedTitle.equals(title)) {
            System.out.println("Test passed");
        } else {
            System.out.println("failed");
        }
        driver.navigate().to("http://amazon.com");
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);
        String current0 = driver.getCurrentUrl();
        System.out.println(current0);
        driver.navigate().forward();
        Thread.sleep(2000);
        String current = driver.getCurrentUrl();
        System.out.println(current);
        driver.navigate().refresh();
        Thread.sleep(5000);


        verifyEquals(driver.getTitle(), "Amazon.com. Spend less. Smile more.");

        driver.close();
        //driver.quit();//all windows
    }

    public static void verifyEquals(String arg1, String arg2) {
        if (arg1.equals(arg2)) {
            System.out.println("Passed yay");
        } else {
            System.out.println("Oh no!");
        }

    }
}
