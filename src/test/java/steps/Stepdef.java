package steps;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import classes.RestAPIHandler;
import context.Context;
import context.ScenarioContext;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Stepdef {

    public Properties prop;

    public static Logger log = LogManager.getLogger(Stepdef.class.getName());

    private ScenarioContext scenarioContext;

    public Stepdef(ScenarioContext scenarioContext) {
        this.scenarioContext = scenarioContext;
    }

    @Before()
    public void init() throws IOException {
        prop = new Properties();
        FileInputStream dataFile = new FileInputStream("C:\\FlickrApiProject\\imgur.projectTest\\src\\main\\resources\\data.properties");
        prop.load(dataFile);
        RestAssured.baseURI = prop.getProperty("flickrbaseUrl");
    }

    @Given("^user makes a Get Request$")
    public void userMakesAGetRequest() throws Throwable {
        log.info("Making a Get request");
        Response response = RestAPIHandler.sendGetRequest(prop.getProperty("flickrpath"));
        scenarioContext.setContext(Context.Response, response);
    }

    @Then("^Response Code should be (\\d+)$")
    public void responseCodeShouldBe(int code) throws Throwable {
        Response response = (Response) scenarioContext.getContext(Context.Response);
        int responseStatusCode = response.getStatusCode();
        Assert.assertEquals(responseStatusCode, code, "Incorrect status code returned");
        log.info("Response code is 200");
    }

}