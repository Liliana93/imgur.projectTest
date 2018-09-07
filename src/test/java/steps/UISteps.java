package steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import context.ScenarioContext;
import cucumber.api.java.en.Given;

import static steps.Stephooks.driver;
import static steps.Stephooks.prop;

public class UISteps {

    public static Logger log = LogManager.getLogger(APISteps.class.getName());

    private ScenarioContext scenarioContext;

    public UISteps(ScenarioContext scenarioContext) {
        this.scenarioContext = scenarioContext;
    }

    @Given("^user accesses the YouTube Page$")
    public void userAccessesTheYouTubePage() throws Throwable {
        driver = (WebDriver) scenarioContext.getContext(ScenarioContext.Context.webDriver);
        driver.get(prop.getProperty("url"));
        log.info("User has accessed the YouTube");
    }
}
