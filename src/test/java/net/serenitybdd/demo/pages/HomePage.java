package net.serenitybdd.demo.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.validation.constraints.Max;
import java.lang.ref.WeakReference;

public class HomePage extends PageObject{
    @Managed(driver="chrome")
    private WebDriver driver;

    @FindBy(id="search_query_top")
    private WebElement searchQuery;

    @FindBy(name="submit_search")
    private WebElement clickSearchButton;

    @FindBy(xpath = "//a[text()='Contact us']")
    private WebElement clickContactButton;

    public void openUrl(){
        driver = getDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");
    }

    public String getTitle(){
        driver = getDriver();
        return driver.getTitle();
    }

    public void enterSearchBox(String product){
        searchQuery.sendKeys(product);
    }

    public void clickContactButton(){ clickContactButton.click(); }

    public void clickSearchButton(){
        clickSearchButton.click();
    }

    public void closeBrowser(){
        driver.close();
    }
}
