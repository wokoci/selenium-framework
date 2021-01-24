package com.example;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverFactory {

    private RemoteWebDriver webDriver;

    private final String operatingSystem = System.getProperty("os.name").toUpperCase();
    private final String systemArchitecture = System.getProperty("os.arch");

    RemoteWebDriver getDriver() {
        if (null == webDriver) {
            System.out.println(" ");
            System.out.println("Current operating System: " + operatingSystem);
            System.out.println("Current Architecture: " + systemArchitecture);
            System.out.println("Current browser Selection: Firefox");
            System.out.println(" ");
            webDriver = new FirefoxDriver();
        }
        return webDriver;
    }

    void quitDriver() {
        webDriver.quit();
        webDriver = null;
    }
}
