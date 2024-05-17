/*
package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"org.example.stepdefs"},
        plugin = {"pretty",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter"
        , "html:target/cucumber-reports"
        , "json:target/cucumber.json"},
        monochrome = true,
        tags="@test1")
public class ParallelTestRun extends AbstractTestNGCucumberTests {
    @DataProvider(parallel = true)
    Object[][] scenario();
}
*/
