package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.DataProvider;

public class SingleTestRun extends AbstractTestNGCucumberTests {
    @DataProvider(parallel = false)
    public Object[][] scenario() {
        return scenarios();
    }
}
