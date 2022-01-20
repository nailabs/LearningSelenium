package com.automation.utilities;

public class BrowserUtils {

    public static void wait(int seconds) {//has to be static here
        try {
            Thread.sleep(1000 * seconds);//checked exception
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
