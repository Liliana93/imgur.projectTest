package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = {"src/test/resources/features"},
        tags = {"@APITest, @UITest"},
        glue = {"steps"},
        format = {"json:target/cucumber.json", "html:target/site/cucumber-pretty"},
        monochrome = true)


public class TestRunner extends AbstractTestNGCucumberTests {
}