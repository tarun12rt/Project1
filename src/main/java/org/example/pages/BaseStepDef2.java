package org.example.pages;

import org.example.pages.ConfigLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseStepDef2 {
    protected WebDriver driver;

    public void launchBrowser() {
        String executionProvider = ConfigLoader.getProperty("ExecutionProvider");
        String browserType = ConfigLoader.getProperty("BrowserType");

        if ("local".equalsIgnoreCase(executionProvider)) {
            if ("CHROME".equalsIgnoreCase(browserType)) {
                System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                driver = new ChromeDriver(options);
            } else {
                throw new UnsupportedOperationException("Browser type not supported: " + browserType);
            }
        } else if ("remote".equalsIgnoreCase(executionProvider)) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName(browserType.toLowerCase());
            try {
                driver = new RemoteWebDriver(new URL("http://" + ConfigLoader.getProperty("RemoteServer") + ":" + ConfigLoader.getProperty("RemotePort") + "/wd/hub"), capabilities);
            } catch (MalformedURLException e) {
                throw new RuntimeException("Remote server URL is malformed", e);
            }
        } else {
            throw new UnsupportedOperationException("Execution provider not supported: " + executionProvider);
        }

        driver.manage().timeouts().implicitlyWait(ConfigLoader.getIntProperty("DriverTimeOut"), java.util.concurrent.TimeUnit.SECONDS);
        driver.get(ConfigLoader.getProperty("prodAppURL"));
    }

    public WebDriver getDriver() {
        return driver;
    }
}

