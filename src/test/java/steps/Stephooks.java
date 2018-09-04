package steps;

import context.ScenarioContext;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.restassured.RestAssured;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


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
        //   FileInputStream dataFile = new FileInputStream("C:\\FlickrApiProject\\imgur.projectTest\\src\\main\\resources\\data.properties");
        FileInputStream dataFile = new FileInputStream("C:\\imgur update\\imgur.projectTest\\src\\main\\resources\\data.properties");
        prop.load(dataFile);
        RestAssured.baseURI = prop.getProperty("flickrbaseUrl");

       /* String browserName = prop.getProperty("browser");

        if (browserName.equals("chrome")) {
            // System.setProperty("webdriver.chrome.driver", "C:\\Webdriver\\chromedriver.exe");
            System.setProperty("webdriver.chrome.driver", "C:\\Soft\\Webdriver\\chromedriver.exe");
            //  prop.getProperty("webdriver.chrome.driver");
            driver = new ChromeDriver();

        } else if (browserName.equals("firefox")) {
            //System.setProperty("webdriver.gecko.driver", "C:\\Webdriver\\geckodriver.exe");
            System.setProperty("webdriver.gecko.driver", "C:\\Soft\\Webdriver\\geckodriver.exe");
            //   prop.getProperty("webdriver.gecko.driver");
            driver = new FirefoxDriver();
        } else if (browserName.equals("IE")) {

        }*/
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