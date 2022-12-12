package com.telran.oscar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AllProductsPage extends BasePage {

    public AllProductsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath ="//*[contains(text),'Add to basket']")
    WebElement addToBasket;

    @FindBy(xpath = "//*[contains(text),'View basket']")
    WebElement viewBasket;

    public CheckoutPage addProductInBasket(){
        click(addToBasket);
        click(viewBasket);
        return new CheckoutPage(driver);
    }
}
