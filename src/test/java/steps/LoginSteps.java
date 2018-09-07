package steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.LoginPage;

import static steps.Stephooks.driver;
import static steps.Stephooks.prop;

public class LoginSteps {

    public static Logger log = LogManager.getLogger(APISteps.class.getName());

    LoginPage lp;

    @Given("^user accesses the Login Page$")
    public void userAccessesTheLoginPage() throws Throwable {
        driver.get(prop.getProperty("gmailurl"));
        lp = new LoginPage(driver);
        log.info("User has accessed the Login Page");

    }

    @When("^user enters \"([^\"]*)\" and \"([^\"]*)\"$")
    public void userEntersAnd(String arg0, String arg1) throws Throwable {
        lp.setUserName(prop.getProperty("login"));
        lp.setPassword(prop.getProperty("password"));
        log.info("User has entered valid credentials");

    }

    @And("^clicks on submit button$")
    public void clicksOnSubmitButton() throws Throwable {
        lp.Login();
        log.info("User has clicked on submit button");
    }

    @Then("^user is logged in$")
    public void chechIfLoggedIn() throws Throwable {
        driver.get("https://mail.google.com/mail");
        Assert.assertTrue(lp.IsLoggedIn(), "User is not logged in");
        Thread.sleep(1000);
    }
}
