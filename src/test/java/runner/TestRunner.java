package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

//@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features", // Path to your feature files
        glue = "org.example.stepdefs",            // Package containing step definitions and hooks
        plugin = {
                "pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:target/cucumber-reports/extent-report.html", // Specify the output file for ExtentCucumberAdapter
                "html:target/cucumber-reports/cucumber.html", // Ensure html output file has an explicit filename
                "json:target/cucumber-reports/cucumber.json" // Ensure json output file has an explicit filename
        },
        tags = "@HomePageScenarios",
        monochrome = true                          // Optional: for more readable console output
)
public class TestRunner {
        // This class remains empty, used only as a holder for the above annotations
}
