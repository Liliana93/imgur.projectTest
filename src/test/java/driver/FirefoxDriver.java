package driver;

import driver.AbstractDriver;

import static steps.Stephooks.prop;

public class FirefoxDriver extends AbstractDriver {

    @Override
    protected void createDriver() {
        prop.getProperty("webdriver.gecko.driver");
        driver = new org.openqa.selenium.firefox.FirefoxDriver();
    }
}