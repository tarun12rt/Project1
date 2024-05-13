package org.example.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class HomePage {
    private WebDriver driver; // WebDriver instance

    private By amazonLogo = By.id("nav-logo-sprites");
    private By searchBar = By.id("nav-search-bar-form");

    // Constructor to initialize WebDriver
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to launch the browser and navigate to Amazon homepage
    public void launchBrowser() {
        driver.get("https://www.amazon.in/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    // Method to find and return a web element based on the given locator
    private WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    // Method to verify if Amazon logo is present on the homepage
    public boolean verifyAmazonLogoOnHomePage() {
        WebElement logoElement = findElement(amazonLogo);
        return logoElement.isDisplayed();
    }

    // Method to verify if search bar is present on the homepage
    public boolean verifySearchBarOnHomePage() {
        WebElement searchBarElement = findElement(searchBar);
        return searchBarElement.isDisplayed();
    }
}
