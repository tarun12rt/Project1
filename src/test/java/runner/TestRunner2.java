package runner;
import java.io.IOException;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.example.pages.FileUtilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;


@CucumberOptions(
        features = "src/test/resources/features", // Path to your feature files
        glue = "org.example.stepdefs",            // Package containing step definitions and hooks
        plugin = {
                "pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
        },
        tags = "@HomePageScenarios",

        monochrome = true                          // Optional: for more readable console output
)


public class TestRunner2 extends AbstractTestNGCucumberTests {
        @Override
        @DataProvider(parallel = false)
        public Object[][] scenarios(){
                return super.scenarios();
        }

        @AfterSuite
        public void fnAfterTestSuite() throws IOException{
                System.out.println("After Test Suite");
                FileUtilities.fnCopyToCICD();
        }

}
