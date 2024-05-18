package org.example.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementUtils {
    private WebDriver driver;
    private static final int TIMEOUT = 10;

    public ElementUtils(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement waitForElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public boolean isElementDisplayed(By locator) {
        try {
            WebElement element = waitForElement(locator);
            return element.isDisplayed();
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }

    // Method to click an element
    public void clickElement(By locator) {
        try {
            WebElement element = waitForElement(locator);
            element.click();
        } catch (ElementClickInterceptedException | TimeoutException e) {
            // Handle exception
            System.err.println("Element not clickable: " + e.getMessage());
        }
    }

    // Method to enter text into an element
    public void enterText(By locator, String text) {
        try {
            WebElement element = waitForElement(locator);
            element.clear();
            element.sendKeys(text);
        } catch (InvalidElementStateException | TimeoutException e) {
            // Handle exception
            System.err.println("Unable to enter text: " + e.getMessage());
        }
    }

    // Method to get text from an element
    public String getText(By locator) {
        try {
            WebElement element = waitForElement(locator);
            return element.getText();
        } catch (TimeoutException | NoSuchElementException e) {
            // Handle exception
            System.err.println("Unable to get text: " + e.getMessage());
            return "";
        }
    }
}
