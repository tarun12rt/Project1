package org.example.pages;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class TestUtil {
    private static WebDriver driver;
    private static ExtentTest test;

    public static void setUp() throws IOException {
        driver = SeleniumDriver.getChromeDriver();
        test = ExtentReportManager.createTest("HomePageScenarios");
    }

    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        ExtentReportManager.flushReports();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static ExtentTest getTest() {
        return test;
    }
}
