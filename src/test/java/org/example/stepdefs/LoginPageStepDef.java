package org.example.stepdefs;

import io.cucumber.java.en.When;
import org.example.pages.BaseStepDef;
import org.example.pages.LoginPage;

public class LoginPageStepDef extends BaseStepDef {
    private LoginPage loginPage;

    @When("I Click on Sign Button from Header on HomePage")
    public void iClickOnSignButtonFromHeaderOnHomePage() {
        loginPage = new LoginPage(driver);
        loginPage.clickOnSignButton();
    }
}
