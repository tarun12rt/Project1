package org.example.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.example.pages.BaseStepDef;
import org.example.pages.HomePage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import static org.example.pages.TestUtil.getDriver;

public class HomePageStepDef extends BaseStepDef {
    private HomePage homePage;

    @Given("I launch the Application")
    public void i_launch_the_application() {
        homePage.launchBrowser();
        homePage = new HomePage(getDriver());
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
