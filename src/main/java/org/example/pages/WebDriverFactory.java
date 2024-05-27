package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

public class WebDriverFactory {

    public static WebDriver createDriver() {
        String executionProvider = ConfigLoader.getProperty("ExecutionProvider");
        String browserType = ConfigLoader.getProperty("BrowserType");
        WebDriver driver;

        if ("local".equalsIgnoreCase(executionProvider)) {
            if ("CHROME".equalsIgnoreCase(browserType)) {
                System.setProperty("webdriver.chrome.driver","src/test/resources/drivers");
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
        return driver;
    }
}

