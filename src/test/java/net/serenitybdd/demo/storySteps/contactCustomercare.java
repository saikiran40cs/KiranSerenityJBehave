package net.serenitybdd.demo.storySteps;

import net.serenitybdd.demo.stepsLibrary.ContactPageLibrary;
import net.serenitybdd.demo.stepsLibrary.HomePageSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.*;

/**
 * Created by saikiran.nataraja on 15.7.2017.
 */
public class contactCustomercare {
    String subHead;
    String emailId;
    String orderNumber;
    String message;

    @Steps
    ContactPageLibrary contactPageLibrary;

    @Steps
    HomePageSteps homePageSteps;

    @BeforeScenario
    public void beforeScenario(){ System.out.println("******Before Scenario is executed******");}

    @AfterScenario
    public void afterScenario(){ System.out.println("******After Scenario is executed******");}

    @Given("Order Number is $OrderID")
    public void setOrderNumber(String odNo){
        homePageSteps.openUrl();
        homePageSteps.homePageVerification();
        homePageSteps.clickContact();
        orderNumber = odNo;
    }

    @When("I enter the $subHeading and $emailAd")
    @Aliases(values = {"user enters the $subHeading and $emailAd",
                        "kiran is king and he enters $subHeading and $emailAd"})
    public void setMessageValues(@Named("subHeading") String subjHeading, @Named("emailAd") String AAmailAddress){
        subHead = subjHeading;
        emailId = AAmailAddress;

    }

    @When("I enter a $message")
    @Alias("User enters the query")
    public void setMessage( String textMessage){
        message = textMessage;
    }

    @When("I click Send button")
    public void clickSend(){
        contactPageLibrary.sendMessage(subHead,emailId,orderNumber,message);
    }

    @Pending
    public void verifyContactUsPage(){

    }

    @Then("verify the $result from page.")
    public void performAction(String expectedResult){
        contactPageLibrary.verifyMessage(expectedResult);
    }
}
