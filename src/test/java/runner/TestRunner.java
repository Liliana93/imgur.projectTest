package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = {"src/test/resources/features"},
        glue = {"steps"},
        tags = {"@APITest", "@UITest"},
        format = {"json:target/cucumber.json", "html:target/site/cucumber-pretty"})

public class TestRunner extends AbstractTestNGCucumberTests {


}
