package org.example.pages.driverFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.pages.config.GlobalConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class LocalBrowserEngine {

    public static RemoteWebDriver fnChromeBrowser(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        return new ChromeDriver(options);
    }

    public static RemoteWebDriver fnFirefoxBrowser(){
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    public static RemoteWebDriver fnSafariBrowser(){
        WebDriverManager.safaridriver().setup();
        return new SafariDriver();
    }

    public static RemoteWebDriver fnEdgeBrowser(){
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    }

    public static RemoteWebDriver GetLocalBrowserEngine(GlobalConfig objConfig){
        if (objConfig.browserType==GlobalConfig.BrowserType.EDGE)
            return fnEdgeBrowser();
        else if (objConfig.browserType==GlobalConfig.BrowserType.FIREFOX)
            return fnEdgeBrowser();
         else if (objConfig.browserType==GlobalConfig.BrowserType.SAFARI)
            return fnSafariBrowser();
         else
             return fnChromeBrowser();
    }
}
