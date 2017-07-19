package net.serenitybdd.demo.pages;


import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SearchPage extends PageObject{
    private WebDriver driver;

    public String getTitle(){
        driver = getDriver();
        return driver.getTitle();
    }

    public int getNumberOfItems(){
        String strIdentifier = "//*[@class='page-heading  product-listing']/span[@class='heading-counter']";
        try {
            WebElement element = driver.findElement(By.xpath(strIdentifier));
            String strText = element.getText().trim();
            String strCount = strText.split(" results")[0];
            int count = Integer.parseInt(strCount);
            return count;
        }
        catch (Exception e){
            return 0;
        }
    }

    public void hoverOnItemByIndex(int index){
        try {
            String strIdentifier = "//ul[@class='product_list grid row']/li[" + index + "]";
            WebElement element = driver.findElement(By.xpath(strIdentifier));
            Actions actions = new Actions(driver);
            actions.moveToElement(element).build().perform();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public float getItemPriceByIndex(int index){
        String strIdentifier = "//ul[@class='product_list grid row']/li[" + index + "]" +
                "//div[@class='right-block']//span[@class='price product-price']";
        WebElement element = driver.findElement(By.xpath(strIdentifier));
        String strPrice = element.getText().trim();
        strPrice = strPrice.replace("$","");
        float price = Float.parseFloat(strPrice);
        return price;
    }

    public void clickOnAddToCartByIndex(int index){
        String strIdentifier = "//ul[@class='product_list grid row']/li[" + index + "]" +
                "//a[contains(@class,'ajax_add_to_cart_button')]";
        WebElement element = driver.findElement(By.xpath(strIdentifier));
        element.click();
    }

    public void clickOnProceedToCheckout(){
        String strIdentifier = "//a[@title='Proceed to checkout']";
        WebElement element = driver.findElement(By.xpath(strIdentifier));
        element.click();
    }

    public void closeBrowser(){
        driver.close();
    }
}
