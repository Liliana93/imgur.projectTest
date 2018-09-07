package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    public WebDriver driver;
   // @FindBy

    By loginField = By.xpath("//*[@id=\"identifierId\"]");

    By nextButton = By.xpath("//*[@id=\"identifierNext\"]/content");

    By passwordField = By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input");

    By submitButton = By.xpath("//*[@id=\"passwordNext\"]/content/span");

    private String userName;

    private String password;

    public LoginPage(WebDriver driver) {
        this.driver = driver;

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public WebElement getsubmitButton() {
        return driver.findElement(submitButton);
    }

    public void Login() throws InterruptedException {
        getloginField().sendKeys(getUserName());
        Thread.sleep(1000);
        getnextButton().click();
        Thread.sleep(1000);
        getpasswordField().sendKeys(getPassword());
        getsubmitButton().click();
        Thread.sleep(1000);
    }

    public boolean IsLoggedIn() throws InterruptedException {
        Thread.sleep(1000);
        String expectedUrl = "https://mail.google.com/mail/#inbox";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.equals(expectedUrl)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean IsAtLoginPage() {
        String acctualUrl = "https://accounts.google.com/signin";
        String expectedUrl = driver.getCurrentUrl();
        if (acctualUrl.equals(expectedUrl)) {
            return true;
        }
        return false;
    }

}