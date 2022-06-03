package com.automation.tests.day8_TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UnitTestPractice {
    public static void main(String[] args) {
        System.out.println(reverseString("apple"));
        String expected = "cba";
        String toReverse = "abc";
        String actual = reverseString(toReverse);
        verifyEquals(expected, actual);

    }

    @Test(description = "verify if method can reverse a string")   //annotation outside main method
    public void test() {
        String expected = "elppa";
        String actual = reverseString("apple");     //click see difference in compiler if different
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void test2(){
        String expected = "rac";
        String actual = reverseString("car");
        Assert.assertEquals(actual,expected);

    }

    public static boolean verifyEquals(String expected, String actual) { //we can use testng assertion instead of this method
        if (expected.equals(actual)) {
            System.out.println("TEST PASSED");
            return true;
        } else {
            System.out.println("TEST FAILED");
            System.out.println("Expected: " + expected);
            System.out.println("Actual: " + actual);
            return false;
        }
    }

    public static String reverseString(String str) {
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }
        return reversed;
    }
}
