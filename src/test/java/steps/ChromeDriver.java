package steps;

import static steps.Stephooks.prop;

public class ChromeDriver extends AbstractDriver {

    @Override
    protected void createDriver() {
        prop.getProperty("webdriver.chrome.driver");
        driver = new org.openqa.selenium.chrome.ChromeDriver();
    }
}