package org.example.pages;

import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

public class HomePage {

    public void launchBrowser() {
        WebDriver driver = SeleniumDriver.getChromeDriver();
        driver.get("https://www.amazon.in/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
}
