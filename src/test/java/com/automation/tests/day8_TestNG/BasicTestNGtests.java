package com.automation.tests.day8_TestNG;

import org.testng.Assert;
import org.testng.annotations.*;

public class BasicTestNGtests {

    @BeforeTest
    public static void beforeTest(){
        System.out.println("Before test");
    }

    @AfterTest
    public static void afterTest(){
        System.out.println("After test");
    }
    @BeforeSuite
    public static void beforeSuite(){
        System.out.println("Before suite");
    }

    @AfterSuite
    public static void afterSuite(){
        System.out.println("After suite");
    }
    @BeforeClass
    public static void beforeClass(){   // runs only 1 per class before @beforemethod  and before all tests
        System.out.println("Before class");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("After class");
    }

    @BeforeMethod   // runs automatically before EVERY method in the class
    public void setup(){
        System.out.println("Before method");//works as precondition or setup
    }

    @AfterMethod    //Runs automatically after every(!) test in the class
    public void teardown(){
        System.out.println("AFTER METHOD");
    }

    @Test
    public void test1() {
        System.out.println("TEST1");
        String expected = "apple";
        String actual = "apple";
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void test2() {
        System.out.println("TEST2");
        int num1 = 5;
        int num2 = 10;
        Assert.assertTrue(num1 < num2); //hard assertion: if assertion fails, it stops the execution immediately (due to exception)

    }

}

