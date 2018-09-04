package steps;

public class ChromeDriver extends AbstractDriver {
    @Override
    protected void createDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Soft\\Webdriver\\chromedriver.exe");
        driver = new org.openqa.selenium.chrome.ChromeDriver();
    }
}