package org.example.pages;

import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

public class WebDriverConfig {

    // Method to configure WebDriver settings
    public static void configureDriver(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
}

