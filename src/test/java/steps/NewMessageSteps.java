package steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cucumber.api.java.en.When;
import pages.MailPage;

import static steps.Stephooks.driver;

public class NewMessageSteps {

    public static Logger log = LogManager.getLogger(APISteps.class.getName());

    MailPage mp;

    @When("^user clicks on compose button$")
    public void clickOnComposeButton() throws InterruptedException {
        mp = new MailPage(driver);
        Thread.sleep(2000);
        mp.getComposeButton().click();
        Thread.sleep(1000);
    }

    @When("^user enters the recipient \"([^\"]*)\"$")
    public void userEntersRecipient(String recipient) throws Throwable {
        mp.setReceipintName(recipient);
        mp.getRecipientField().sendKeys(mp.getReceipintName());
        Thread.sleep(1000);
    }

    @When("^user enters the subject \"([^\"]*)\"$")
    public void userEntersSubject(String subject) throws Throwable {
        mp.setSubjectName(subject);
        mp.getSubjectField().sendKeys(mp.getSubjectName());
        Thread.sleep(1000);
    }

    @When("^user enters the message \"([^\"]*)\"$")
    public void userEntersMessage(String message) throws Throwable {
        mp.setMessage(message);
        mp.getMessageBodyField().sendKeys(mp.getMessage());
        Thread.sleep(1000);
    }

    @When("^user clicks on send button$")
    public void clickOnSendButton() throws InterruptedException {
        mp.getSendButton().click();
        Thread.sleep(2000);
    }

}
