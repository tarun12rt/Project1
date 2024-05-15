package org.example.stepdefs;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.example.pages.BaseTest;
import org.example.pages.HomePage;
import org.junit.Assert;

public class HomePageStepDef extends BaseTest {
    private HomePage homePage;

    @Override
    @Before
    public void setUp() {
        super.setUp();
        homePage = new HomePage(driver);
    }

    @Given("I launch the Application")
    public void i_launch_the_application() {
        homePage.launchBrowser();
        test.pass("Launched the application successfully.");
    }

    @And("I Verify Amazon Logo on HomePage")
    public void iVerifyAmazonLogoOnHomePage() {
        Assert.assertTrue(homePage.verifyAmazonLogoOnHomePage());
        test.pass("Verified Amazon Logo on HomePage.");
    }

    @And("I Verify Search Bar on HomePage")
    public void iVerifySearchBarOnHomePage() {
        Assert.assertTrue(homePage.verifySearchBarOnHomePage());
        test.pass("Verified Search Bar on HomePage.");
    }
}
