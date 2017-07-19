package net.serenitybdd.demo.stepsLibrary;

import net.serenitybdd.demo.pages.ContactUsPage;
import net.serenitybdd.demo.pages.HomePage;
import net.serenitybdd.demo.pages.SearchPage;
import net.serenitybdd.demo.pages.SummaryPage;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.support.ui.Select;

import static com.thoughtworks.selenium.SeleneseTestBase.assertTrue;

/**
 * Created by saikiran.nataraja on 15.7.2017.
 */
public class ContactPageLibrary {
    HomePage homePage;
    ContactUsPage contactUsPage;

    @Step
    public void openUrl() {
        homePage.openUrl();
    }

    @Step
    public void homePageVerification() {
        assertTrue(homePage.getTitle().contains("My Store"));
    }

    @Step
    public void clickContact() {        homePage.clickContactButton();    }

    @Step
    public void goToContactsPage(){ contactUsPage.getDriver();}

    @Step
    public void sendMessage(String subHead,String emailId,String orderNumber,String message){
        contactUsPage.enterEmailAd(emailId);
        contactUsPage.enterOrderNumber(orderNumber);
        contactUsPage.enterTextMessage(message);
        contactUsPage.enterSubMessage(subHead);
        contactUsPage.clickSendButton() ;
    }

    @Step
    public void verifyMessage(String expectedResult){
        assertTrue("Message sent to the customer care",contactUsPage.getAlertMessageFromPage().equalsIgnoreCase(expectedResult));
    }

    @Step
    public void closeBrowser(){
        homePage.closeBrowser();
    }

}
