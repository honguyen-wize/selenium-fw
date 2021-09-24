package cucumberOptions;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/java/features",
        glue = "stepDefinitions",
        format = {"pretty", "html:target/cucumber", "json:target/cucumber.json"}
)

public class TestRunner extends AbstractTestNGCucumberTests {
}