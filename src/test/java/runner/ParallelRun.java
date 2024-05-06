package runner;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"org.example.stepdefs"},
        plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter", "html:target/cucumber-reports", "json:target/cucumber.json"},
        monochrome = true,
        tags="@test1")
public class ParallelRun extends SingleTestRun {

}
