package com.automation.tests.day14_Properties_Canvas17;

import com.automation.utilities.ConfigurationReader;
import org.testng.annotations.Test;

public class ConfigurationReaderTest {

    @Test
    public void readProperties() {

        String browser = ConfigurationReader.getProperty("browser");
        String url = ConfigurationReader.getProperty("qa1");

        System.out.println(browser);
        System.out.println(url);

        String password = ConfigurationReader.getProperty("password");
        System.out.println(password);
    }
}
