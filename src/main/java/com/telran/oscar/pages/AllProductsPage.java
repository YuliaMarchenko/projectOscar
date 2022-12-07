package com.telran.oscar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AllProductsPage extends BasePage {

    public AllProductsPage(WebDriver driver) {
        super(driver);
    }

    // find new css
    @FindBy(css =".btn.btn-primary.btn-block")
    WebElement addBasket;

    @FindBy()
    WebElement viewBasket;

    public BasketPage addProductInBasket(){
        click(addBasket);
        click(viewBasket);
        return new BasketPage(driver);
    }
}
