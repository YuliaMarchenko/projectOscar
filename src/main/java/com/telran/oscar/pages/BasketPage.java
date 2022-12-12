package com.telran.oscar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasketPage extends HomePage{
    public BasketPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[contains(text),'Proceed to checkout']")
    WebElement proceedToCheckout;

    public CheckoutPage clickProceedToCheckout(){
        click(proceedToCheckout);
        return new CheckoutPage(driver);
    }
}
