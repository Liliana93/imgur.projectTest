package steps;

import org.openqa.selenium.WebDriver;

/**
 * Created by Liliana on 04.09.2018.
 */
public abstract class AbstractDriver {
    protected WebDriver driver;
    protected abstract void createDriver();

    public WebDriver getDriver() {
        if (driver == null) {
            createDriver();
        }
        return driver;
    }
}
