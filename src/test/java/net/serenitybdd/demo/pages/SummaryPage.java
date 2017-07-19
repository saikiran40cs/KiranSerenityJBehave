package net.serenitybdd.demo.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SummaryPage extends PageObject{
    private WebDriver driver;

    public String getTitle(){
        driver = getDriver();
        return driver.getTitle();
    }

    public float getCartPriceWithoutShipping(){
        String strIdentifier = "//td[@id='total_product']";
        WebElement element = driver.findElement(By.xpath(strIdentifier));
        String strPrice = element.getText().trim();
        strPrice = strPrice.replace("$","");
        float price = Float.parseFloat(strPrice);
        return price;
    }

    public void clickOnDelete(){
        String strIdentifier = "//a[@class='cart_quantity_delete']";
        WebElement element = driver.findElement(By.xpath(strIdentifier));
        element.click();
    }

    public void closeBrowser(){
        driver.close();
    }
}
