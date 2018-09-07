package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MailPage {

    public WebDriver driver;

    By composeButton = By.xpath("//*[@id=\":4h\"]/div/div");

    By recipientField = By.xpath(" //*[@id=\":9s\"]");

    By subjectField = By.xpath("//*[@id=\":9a\"]");

    By messageBodyField = By.xpath("//*[@id=\":af\"]");

    By sendButton = By.xpath("//*[@id=\":90\"]");

    private String receipintName;

    private String subjectName;

    private String message;

    public MailPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getComposeButton() {
        return driver.findElement(composeButton);
    }

    public WebElement getRecipientField() {
        return driver.findElement(recipientField);
    }

    public WebElement getSubjectField() {
        return driver.findElement(subjectField);
    }

    public WebElement getMessageBodyField() {
        return driver.findElement(messageBodyField);
    }

    public WebElement getSendButton() {
        return driver.findElement(sendButton);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public String getReceipintName() {
        return receipintName;
    }

    public void setReceipintName(final String receipintName) {
        this.receipintName = receipintName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(final String subjectName) {
        this.subjectName = subjectName;
    }
}
