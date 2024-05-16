package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features", // Path to your feature files
        glue = "org.example.stepdefs",            // Package containing step definitions
        tags = "@HomePageScenarios",              // Tags to filter which scenarios to run
        plugin = {
                "pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/cucumber.json"
        },
        monochrome = true                          // Optional: for more readable console output
)
public class TestRunner {
    // This class remains empty, used only as a holder for the above annotations
}
