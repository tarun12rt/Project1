package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BaseStepDef2 {
    private WebDriver driver; // WebDriver instance
    private ElementUtils utils; // WebDriverUtils instance

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private By amazonLogo = By.id("nav-logo-sprites");
    private By searchBar = By.id("nav-search-bar-form");

    // Constructor to initialize WebDriver and WebDriverUtils
/*    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.utils = new ElementUtils(driver);
    }*/

    public boolean verifyAmazonLogoOnHomePage() {
        return driver.findElement(amazonLogo).isDisplayed();
    }

    public boolean verifySearchBarOnHomePage() {
        return driver.findElement(searchBar).isDisplayed();
    }
}
