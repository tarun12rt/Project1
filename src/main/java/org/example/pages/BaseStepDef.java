package org.example.pages;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.example.pages.TestUtil;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class BaseStepDef {
    protected WebDriver driver;

    @Before
    public void setUp() throws IOException {
        if (driver == null) {
            TestUtil.setUp();
            driver = TestUtil.getDriver();
        }
    }

    @After
    public void tearDown() {
        if (driver != null) {
            TestUtil.tearDown();
        }
    }
}
