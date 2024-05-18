package org.example.stepdefs;

import io.cucumber.java.Before;
import io.cucumber.java.en.When;
import org.example.pages.BaseStepDef;
import org.example.pages.LoginPage;

import java.io.IOException;

public class LoginPageStepDef extends BaseStepDef {
    private LoginPage loginPage;

    @Before
    public void setUp() throws IOException {
        super.setUp();
        loginPage = new LoginPage(driver);
    }

    @When("I Click on Sign Button from Header on HomePage")
    public void iClickOnSignButtonFromHeaderOnHomePage() {
        loginPage.clickOnSignButton();
    }
}
