package com.example.config;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.HashMap;

public enum DriverType implements DriverSetUp {
    FIREFOX {
        @Override
        public RemoteWebDriver getDriverObject(DesiredCapabilities capabilities) {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("start-maximized");

            return new FirefoxDriver(options);
        }
    },
    CHROME {
        @Override
        public RemoteWebDriver getDriverObject(DesiredCapabilities capabilities) {
            HashMap<String, Object> chromePreferences = new HashMap<>();
            chromePreferences.put("preference.password.enabled",false);
            ChromeOptions chromeOptions = new ChromeOptions();

            chromeOptions.addArguments("start-maximized");
            return new ChromeDriver(chromeOptions);
        }
    };


}
