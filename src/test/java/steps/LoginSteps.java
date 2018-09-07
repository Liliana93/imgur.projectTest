package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
}
