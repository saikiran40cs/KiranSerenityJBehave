package net.serenitybdd.demo.storySteps;

import net.serenitybdd.demo.stepsLibrary.HomePageSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static com.thoughtworks.selenium.SeleneseTestBase.assertEquals;


public class search_product {
    float itemPriceOnSearch;

    @Steps
    HomePageSteps homePageSteps;


    @Given("Homepage I verify Homepage is opened")
    public void verifyHomepageOpened() {
        homePageSteps.openUrl();
        homePageSteps.homePageVerification();
    }

    @When("Homepage I search $dress in searchbox")
    public void searchProduct(String product) {
        homePageSteps.searchProduct(product);
    }

    @When("Homepage I click on button search")
    public void clickSearch() {
        homePageSteps.clickSearch();
    }

    @Then("Searchpage I return number of items displayed on search page")
    public void getNumberOfProducts() {
        homePageSteps.getNumberOfProducts();
    }

    @Then("Searchpage I return price of $1 item")
    public void getProductPrice(String index) {
        itemPriceOnSearch = homePageSteps.getProductPrice(index);
    }

    @When("Searchpage I hover on $1 item")
    public void hoverOnItem(String index) {
        homePageSteps.hoverOnItem(index);

    }

    @When("Searchpage I click on button AddToCart on $1 item")
    public void cickOnAddToCart(String index) {
        homePageSteps.cickOnAddToCart(index);
    }

    @When("Searchpage I Click on button ProceedToCheckout")
    public void clickProceedToCheckout() {
        homePageSteps.clickProceedToCheckout();
    }

    @Then("Summarypage verify price on summarypage")
    public void verifyItemPriceOnSummary() {
        float itemPrice = homePageSteps.getItemPriceOnSummary();
        assertEquals(itemPriceOnSearch,itemPrice);
    }

    @Then("Summarypage I click on button delete")
    public void clickDelete() {
        homePageSteps.clickDelete();
    }
}