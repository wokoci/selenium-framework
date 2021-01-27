package com.example.config;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public interface DriverSetUp {
   RemoteWebDriver getDriverObject (DesiredCapabilities  capabilities);
}
