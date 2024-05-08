package org.example.pages;

import org.apache.logging.log4j.core.appender.ConsoleAppender;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    WebDriver driver1 =null;
    public HomePage(WebDriver driver){
        this.driver=driver;
    }


    public void launchApplication() {
        System.getProperty("webdriver.chrome.driver","C:/Users/tarun/IdeaProjects/Project1/src/test/resources/drivers/chromedriver.exe");
//        driver1
        System.out.println("Entering URL");
        driver.get("https://www.amazon.in/");
    }
}
