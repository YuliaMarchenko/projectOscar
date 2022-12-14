package com.telran.oscar.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasketPage extends HomePage{
    public BasketPage(WebDriver driver) {
        super(driver);
    }

    public boolean existHeaderBasket() {
        return driver.findElements(By.xpath("//h1[contains(text(),'Basket')]")).size() > 0;
    }

    @FindBy(xpath = "//*[contains(text(),'Proceed to checkout')]")
    WebElement proceedToCheckout;

    public CheckoutPage clickProceedToCheckout(){
        click(proceedToCheckout);
        return new CheckoutPage(driver);
    }

    @FindBy(xpath = "(//th[@class='total text-right'])[1]")
    WebElement basketTotal;

    public String getPriceBasketTotalAsString() {
        return basketTotal.getText();
    }

    public Double getPriceBasketTotalAsDouble() {
        return Double.parseDouble(basketTotal.getText().replace("£", ""));
    }

    @FindBy(xpath = "//h3[@class='price_color']")
    WebElement orderTotal;

    public Double getPriceOrderTotalAsDouble() {
        return Double.parseDouble(orderTotal.getText().replace("£", ""));
    }

    @FindBy(css = "#id_form-0-quantity")
    WebElement quantityBook;

    @FindBy(css = ".input-group-append")
    WebElement updateQuantity;

    public BasketPage changeQuantityBook(String quantity){
        type(quantityBook, quantity);
        click(updateQuantity);
        return this;
    }
}
