package org.example.pages;

import org.example.pages.ElementUtils;
import org.example.pages.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver; // WebDriver instance
    private ElementUtils utils; // WebDriverUtils instance

    private By amazonLogo = By.id("nav-logo-sprites");
    private By searchBar = By.id("nav-search-bar-form");

    // Constructor to initialize WebDriver and WebDriverUtils
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.utils = new ElementUtils(driver);
    }

    public void launchBrowser() {
        driver.get("https://www.amazon.in/");
        WebDriverConfig.configureDriver(driver);
    }

    // Method to verify if Amazon logo is present on the homepage
    public boolean verifyAmazonLogoOnHomePage() {
        return utils.isElementDisplayed(amazonLogo);
    }

    // Method to verify if search bar is present on the homepage
    public boolean verifySearchBarOnHomePage() {
        return utils.isElementDisplayed(searchBar);
    }
}
