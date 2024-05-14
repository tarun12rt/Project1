package org.example.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.example.pages.HomePage;
import org.example.pages.SeleniumDriver;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class HomePageStepDef {
    private WebDriver driver;
    private HomePage homePage;

    @Before
    public void setup(){
        driver = SeleniumDriver.getChromeDriver();
        homePage = new HomePage(driver);
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

    @And("I Verify Amazon Logo on HomePage")
    public void iVerifyAmazonLogoOnHomePage() {
        Assert.assertTrue(homePage.verifyAmazonLogoOnHomePage());
    }

    @And("I Verify Search Bar on HomePage")
    public void iVerifySearchBarOnHomePage() {
        Assert.assertTrue(homePage.verifySearchBarOnHomePage());
    }
}
