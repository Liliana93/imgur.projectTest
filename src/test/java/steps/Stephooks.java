package steps;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import context.ScenarioContext;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import driver.AbstractDriver;
import driver.DriverFactory;
import driver.Drivers;
import io.restassured.RestAssured;

public class Stephooks {

    public static Properties prop;

    public static WebDriver driver;

    AbstractDriver abstractDriver;

    private ScenarioContext scenarioContext;

    public Stephooks(ScenarioContext scenarioContext) {
        this.scenarioContext = scenarioContext;
    }

    @Before()
    public WebDriver initFramework() throws IOException {
        prop = new Properties();
        FileInputStream dataFile = new FileInputStream("C:\\Imgur\\imgur.projectTest\\src\\main\\resources\\data.properties");
        prop.load(dataFile);
        RestAssured.baseURI = prop.getProperty("flickrbaseUrl");

        abstractDriver = DriverFactory.setDriver(Drivers.CHROME);
        driver = abstractDriver.getDriver();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        scenarioContext.setContext(ScenarioContext.Context.webDriver, driver);
        return driver;

    }

    @After
    public void teardown() {
        driver.close();
        driver = null;
    }
}