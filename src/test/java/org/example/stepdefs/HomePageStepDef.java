package org.example.stepdefs;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.example.pages.BaseStepDef;
import org.example.pages.HomePage;
import org.example.pages.TestUtil;
import org.junit.Assert;

import java.io.IOException;

public class HomePageStepDef extends BaseStepDef {
    private HomePage homePage;

    @Before
    public void setUp() throws IOException {
        super.setUp();
        homePage = new HomePage(driver);
    }

    @Given("I launch the Application")
    public void i_launch_the_application() {
        homePage.launchBrowser();
        TestUtil.getTest().pass("Launched the application successfully.");
    }

    @And("I Verify Amazon Logo on HomePage")
    public void iVerifyAmazonLogoOnHomePage() {
        Assert.assertTrue(homePage.verifyAmazonLogoOnHomePage());
        TestUtil.getTest().pass("Verified Amazon Logo on HomePage.");
    }

    @And("I Verify Search Bar on HomePage")
    public void iVerifySearchBarOnHomePage() {
        Assert.assertTrue(homePage.verifySearchBarOnHomePage());
        TestUtil.getTest().pass("Verified Search Bar on HomePage.");
    }
}
