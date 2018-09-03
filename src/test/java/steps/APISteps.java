package steps;

import classes.RestAPIHandler;
import context.ScenarioContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import static steps.Stephooks.prop;


public class APISteps {

    public static Logger log = LogManager.getLogger(APISteps.class.getName());
    private ScenarioContext scenarioContext;

    public APISteps(ScenarioContext scenarioContext) {
        this.scenarioContext = scenarioContext;
    }

    @Given("^user makes a Get Request$")
    public void userMakesAGetRequest() throws Throwable {
        log.info("Making a Get request");
        Response response = RestAPIHandler.sendGetRequest(prop.getProperty("flickrpath"));
        scenarioContext.setContext(ScenarioContext.Context.Response, response);
    }

    @Then("^Response Code should be (\\d+)$")
    public void responseCodeShouldBe(int code) throws Throwable {
        Response response = (Response) scenarioContext.getContext(ScenarioContext.Context.Response);
        int responseStatusCode = response.getStatusCode();
        Assert.assertEquals(responseStatusCode, code, "Incorrect status code returned");
        log.info("Response code is 200");
    }

}