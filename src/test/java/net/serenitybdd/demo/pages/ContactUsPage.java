package net.serenitybdd.demo.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by saikiran.nataraja on 15.7.2017.
 */
public class ContactUsPage extends PageObject {
//    @Managed(driver = "firefox")
    @Managed
    private WebDriver driver;

    @FindBy(xpath = "//select[@name='id_contact']")
    private WebElement SubjectHeading;

    @FindBy(id = "email")
    private WebElement emailAddress;

    @FindBy(id = "id_order")
    private WebElement orderId;

    @FindBy(id = "message")
    private WebElement messageToCustomerCare;

    @FindBy(id = "submitMessage")
    private WebElement sendButton;

    @FindBy(xpath = "//p[@class='alert alert-success']")
    private WebElement getAlertmessage;

    public String getTitle() {
        driver = getDriver();
        return driver.getTitle();
    }

    public void enterSubMessage(String subHead) {
        new Select(SubjectHeading).selectByValue(subHead);
    }

    public void enterEmailAd(String emailId) {
        emailAddress.sendKeys(emailId);
    }

    public void enterOrderNumber(String orderNumber) {
        orderId.sendKeys(orderNumber);
    }

    public void enterTextMessage(String message) {
        messageToCustomerCare.sendKeys(message);
    }

    public void clickSendButton() {
        sendButton.click();
    }

    public String getAlertMessageFromPage() {
        return getAlertmessage.getText();
    }
}
