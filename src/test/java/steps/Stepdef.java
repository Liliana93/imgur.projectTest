package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import classes.RestAPIHandler;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class Stepdef {
    public static Response response;
    public static RequestSpecification httpRequest;
    public Properties prop;
    public static Logger log = LogManager.getLogger(Stepdef.class.getName());

    @Given("^user makes a Get Request$")
    public void userMakesAGetRequest() throws Throwable {
        prop = new Properties();
        FileInputStream dataFile = new FileInputStream("C:\\imgur.project\\src\\main\\resources\\data.properties");
        prop.load(dataFile);
        RestAssured.baseURI = prop.getProperty("flickrbaseUrl");
        log.info("Making a Get request");
       // response = RestAPIHandler.getRequest(prop.getProperty("flickrpath"));
    }

    @Then("^Response Code should be (\\d+)$")
    public void responseCodeShouldBe(int code) throws Throwable {
        int responseStatusCode = response.getStatusCode();
        Assert.assertEquals(responseStatusCode, code, "Incorrect status code returned");
    }


}
