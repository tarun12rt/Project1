package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver; // WebDriver instance
    private ElementUtils utils; // WebDriverUtils instance


    // Constructor to initialize WebDriver and WebDriverUtils
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.utils = new ElementUtils(driver);
    }

    private By signBtn = By.id("nav-link-accountList");


    public void clickOnSignButton() {
       utils.clickElement(signBtn);
    }
}
