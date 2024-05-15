package org.example.pages;

import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    protected WebDriver driver;
    protected ExtentTest test;

    @Before
    public void setUp() {
        // Initialize WebDriver
        driver = SeleniumDriver.getChromeDriver();

        // Initialize ExtentReports
        test = ExtentReportManager.createTest(getClass().getSimpleName());
    }

    @After
    public void tearDown() {
        // Quit WebDriver
        if (driver != null) {
            driver.quit();
        }

        // Flush ExtentReports
        ExtentReportManager.flushReports();
    }
}


