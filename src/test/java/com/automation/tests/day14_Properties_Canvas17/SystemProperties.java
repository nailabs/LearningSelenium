package com.automation.tests.day14_Properties_Canvas17;

import org.testng.annotations.Test;

public class SystemProperties {


    @Test
    public void test(){
        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("user.home"));
        System.out.println(System.getProperty("user.home")+"/Downloads");
        System.out.println(System.getProperty("os.arch")); //architecture
        //create new file: configuration.properties: Most important thing about the project, goes to github, engine of the project
        //only one browser there. Used in developmemt as well
    }
}
