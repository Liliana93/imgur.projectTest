package steps;

/**
 * Created by Liliana on 04.09.2018.
 */
public class ChromeDriver extends AbstractDriver {
    @Override
    protected void createDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Soft\\Webdriver\\chromedriver.exe");
        driver = new org.openqa.selenium.chrome.ChromeDriver();
    }
}
