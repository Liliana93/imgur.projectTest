package steps;

import org.openqa.selenium.WebDriver;

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
