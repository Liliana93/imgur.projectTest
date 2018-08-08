package steps;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
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
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class Stepdef {
    public static Response response;
    public static RequestSpecification httpRequest;
    public Properties prop;
    public static Logger log = LogManager.getLogger(Stepdef.class.getName());

    @Before()
    public void init() throws IOException {
        prop = new Properties();
        FileInputStream dataFile = new FileInputStream("C:\\imgur.project\\src\\main\\resources\\data.properties");
        prop.load(dataFile);
        RestAssured.baseURI = prop.getProperty("flickrbaseUrl");
        /*public static WebDriver driver;

    public WebDriver initializeDriver() throws IOException {

        prop = new Properties();
        FileInputStream dataFile = new FileInputStream("C:\\TestFramework\\src\\main\\resources\\data.properties");

        prop.load(dataFile);
        String browserName = prop.getProperty("browser");
        System.out.println(browserName);

        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Soft\\Webdriver\\chromedriver.exe");
            driver = new ChromeDriver();

        } else if (browserName.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver",  "C:\\Soft\\Webdriver\\geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (browserName.equals("IE")) {

        }

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        return driver;
    }
*/
    }
    @Given("^user makes a Get Request$")
    public void userMakesAGetRequest() throws Throwable {
        log.info("Making a Get request");
        response = RestAPIHandler.sendGetRequest(prop.getProperty("flickrpath"));
    }

    @Then("^Response Code should be (\\d+)$")
    public void responseCodeShouldBe(int code) throws Throwable {
        int responseStatusCode = response.getStatusCode();
        Assert.assertEquals(responseStatusCode, code, "Incorrect status code returned");
        log.info("Response code is 200");
    }

}