package steps;

/**
 * Created by Liliana on 04.09.2018.
 */
public class FirefoxDriver extends AbstractDriver{

    @Override
    protected void createDriver() {
        System.setProperty("webdriver.gecko.driver", "C:\\Soft\\Webdriver\\geckodriver.exe");
        //   prop.getProperty("webdriver.gecko.driver");
        driver = new org.openqa.selenium.firefox.FirefoxDriver();
    }
}