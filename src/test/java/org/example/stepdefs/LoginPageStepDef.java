package org.example.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.example.pages.LoginPage;
import org.example.pages.TestUtil;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class LoginPageStepDef {
    private LoginPage loginPage;

    @Before
    public void setUp() throws IOException {
        TestUtil.setUp();
        WebDriver driver = TestUtil.getDriver();
        loginPage = new LoginPage(driver);
    }

    @After
    public void tearDown() {
        TestUtil.tearDown();
    }

    @When("I Click on Sign Button from Header on HomePage")
    public void iClickOnSignButtonFromHeaderOnHomePage() {
        loginPage.clickOnSignButton();
    }

}
