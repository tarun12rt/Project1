package org.example.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import org.example.pages.HomePage;
import org.example.pages.SeleniumDriver;
import org.openqa.selenium.WebDriver;

public class HomePageStepDef {
    private WebDriver driver;
    private HomePage homePage;

    @Before
    public void setup(){
        driver = SeleniumDriver.getChromeDriver();
        homePage = new HomePage();
    }

    @After
    public void tearDown(){
        if(driver!=null){
            driver.quit();
        }
    }

    @Given("I launch the Application")
    public void i_launch_the_application() {
        homePage.launchBrowser();
    }
}
