package org.example.pages;

import io.cucumber.java.Before;
import io.cucumber.java.After;
//import org.example.pages.TestUtil;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class BaseStepDef {
    protected WebDriver driver;

    @Before
    public void setUp() throws IOException {
        TestUtil.setUp();
        driver = TestUtil.getDriver();
    }

    @After
    public void tearDown() {
        TestUtil.tearDown();
    }
}

