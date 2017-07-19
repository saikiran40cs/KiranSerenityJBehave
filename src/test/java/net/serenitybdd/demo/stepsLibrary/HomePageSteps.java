package net.serenitybdd.demo.stepsLibrary;

import net.serenitybdd.demo.pages.HomePage;
import net.serenitybdd.demo.pages.SearchPage;
import net.serenitybdd.demo.pages.SummaryPage;
import net.thucydides.core.annotations.Step;
import static com.thoughtworks.selenium.SeleneseTestBase.assertTrue;

public class HomePageSteps {
    HomePage homePage;
    SearchPage searchPage;
    SummaryPage summaryPage;

    @Step
    public void openUrl(){
        homePage.openUrl();
    }

    @Step
    public void homePageVerification() {
        assertTrue(homePage.getTitle().contains("My Store"));
    }

    @Step
    public void searchProduct(String product) {
        homePage.enterSearchBox(product);
    }

    @Step
    public void clickContact(){
        homePage.clickContactButton();
        System.out.println("The contact button is clicked");
    }


    @Step
    public void clickSearch() {
        homePage.clickSearchButton();
    }

    @Step
    public void getNumberOfProducts() {
        searchPage.getTitle();
        System.out.println("Number of products on page are: " + searchPage.getNumberOfItems());
    }

    @Step
    public float getProductPrice(String index) {
        return searchPage.getItemPriceByIndex(Integer.parseInt(index));
    }

    @Step
    public void hoverOnItem(String index) { searchPage.hoverOnItemByIndex(Integer.parseInt(index)); }

    @Step
    public void cickOnAddToCart(String index) {
        searchPage.clickOnAddToCartByIndex(Integer.parseInt(index));
    }

    @Step
    public void clickProceedToCheckout() {
        searchPage.clickOnProceedToCheckout();
    }

    @Step
    public float getItemPriceOnSummary() {
        summaryPage.getTitle();
        return summaryPage.getCartPriceWithoutShipping();
    }

    @Step
    public void clickDelete() {
        summaryPage.clickOnDelete();
    }

    @Step
    public void closeBrowser(){
        homePage.closeBrowser();
    }
}
