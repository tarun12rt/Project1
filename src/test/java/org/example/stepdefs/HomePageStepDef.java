package org.example.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import org.example.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePageStepDef {
    private WebDriver driver;
    private HomePage homePage;

    @Before
    public void setup(){
        driver=new ChromeDriver();
    }

    @After
    public void tearDown(){
        if(driver!=null){
            driver.quit();
        }
    }

    @Given("I launch the Application")
    public void iLaunchTheApplication() {
        homePage.launchApplication();
    }
}
