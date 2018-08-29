package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import io.restassured.RestAssured;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class WebdriverSteps {
    public static WebDriver driver;
    public Properties prop;
    public static Logger log = LogManager.getLogger(Stepdef.class.getName());

    @Before()
    public WebDriver initializeDriver() throws IOException {
        prop = new Properties();
        FileInputStream dataFile = new FileInputStream("C:\\FlickrApiProject\\imgur.projectTest\\src\\main\\resources\\data.properties");

        prop.load(dataFile);
        RestAssured.baseURI = prop.getProperty("flickrbaseUrl");
        String browserName = prop.getProperty("browser");
        System.out.println(browserName);

        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Webdriver\\chromedriver.exe");
            driver = new ChromeDriver();

        } else if (browserName.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "C:\\Webdriver\\geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (browserName.equals("IE")) {

        }

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        return driver;
    }

    @Given("^user accesses the YouTube Page$")
    public void userAccessesTheYouTubePage() throws Throwable {
        driver.get(prop.getProperty("url"));
        log.info("User has accessed the YouTube");

    }

    @After
    public void teardown() {
        driver.close();
        driver = null;
    }
}
