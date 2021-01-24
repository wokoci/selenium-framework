package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class BasicTest {

    @Test
    public void searchForCheese() {
        googleExampleThatSearchesFor("cheese");
    }
    @Ignore
    @Test
    public void searchForMilk() {
        googleExampleThatSearchesFor("milk");
    }

    private ExpectedCondition<Boolean> pageTitleStartsWith(final String searchString) {
        return driver -> driver.getTitle().toLowerCase().startsWith(searchString);
    }

    private void googleExampleThatSearchesFor(final String searchString) {
        System.setProperty("webdriver.chrome.driver","src/test/browsers/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("http://google.com");
        WebElement searchFiled = driver.findElement(By.id("q"));

        searchFiled.clear();
        searchFiled.sendKeys(searchString);

        System.out.println("Page title is:" + driver.getTitle());
        searchFiled.submit();

        WebDriverWait wait = new WebDriverWait(driver, 10, 100);
        wait.until(pageTitleStartsWith(searchString));

        System.out.println("Page title is :" + driver.getTitle());
        driver.quit();
    }
}
