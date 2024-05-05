package org.example.pages;

import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver=driver;
    }


    public void launchApplication() {
        driver.get("https://www.amazon.in/");
    }
}
