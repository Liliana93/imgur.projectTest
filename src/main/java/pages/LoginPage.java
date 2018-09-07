package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    public WebDriver driver;

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    private String userName;
    private String password;

    By loginField = By.xpath("//*[@id=\"identifierId\"]");
    By nextButton = By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div/div[2]");
    By passwordField = By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div/div[2]/div/div[1]/div/form/content/section/div/content/div[1]/div/div[1]/div/div[1]/input");

    public LoginPage(WebDriver driver) {
        this.driver = driver;

    }

    public WebElement getloginField() {
        return driver.findElement(loginField);
    }

    public WebElement getpasswordField() {
        return driver.findElement(passwordField);
    }

    public WebElement getnextButton() {
        return driver.findElement(nextButton);
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setPassword(String password) {
        this.password = password;
    }


    public void Login() throws InterruptedException {
        Thread.sleep(3000);
        getloginField().sendKeys(getUserName());
        Thread.sleep(3000);
        getnextButton().click();
        getpasswordField().sendKeys(getPassword());
        getnextButton().click();
    }

//    public boolean IsLoggedIn() {
//        String expectedUrl = "http://localhost/website_wordpress/wp-admin/";
//        String actualUrl = driver.getCurrentUrl().toString();
//        if (actualUrl.equals(expectedUrl))
//            return true;
//        else
//            return false;
//    }
//
//    public boolean IsAtLoginPage() {
//        String acctualUrl = "http://localhost/website_wordpress/wp-login.php";
//        String expectedUrl = driver.getCurrentUrl();
//        if (acctualUrl.equals(expectedUrl)) {
//            return true;
//        }
//        return false;
//    }



}
