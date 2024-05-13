package org.example.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumDriver {

    public static WebDriver getChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\tarun\\IdeaProjects\\Project1\\src\\test\\resources\\drivers\\chromedriver.exe");
        return new ChromeDriver();
    }
}
