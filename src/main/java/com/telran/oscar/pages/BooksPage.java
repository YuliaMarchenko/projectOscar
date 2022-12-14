package com.telran.oscar.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BooksPage extends BasePage {
    public BooksPage(WebDriver driver) {
        super(driver);
    }

    public boolean existHeaderBooks() {
        return driver.findElements(By.xpath("//h1[contains(text(),'Books')]")).size() > 0;
    }

    public boolean existHeaderFiction() {
        return driver.findElements(By.xpath("//h1[contains(text(),'Fiction')]")).size() > 0;
    }

    public boolean existHeaderComputersInLiterature() {
        return driver.findElements(By.xpath("//h1[contains(text(),'Computers in Literature')]")).size() > 0;
    }

    public boolean existHeaderNonFiction() {
        return driver.findElements(By.xpath("//h1[contains(text(),'Non-Fiction')]")).size() > 0;
    }

    public boolean existHeaderEssentialProgramming() {
        return driver.findElements(By.xpath("//h1[contains(text(),'Essential programming')]")).size() > 0;
    }

    public boolean existHeaderHacking() {
        return driver.findElements(By.xpath("//h1[contains(text(),'Hacking')]")).size() > 0;
    }

    @FindBy(xpath ="//*[contains(text(),'Add to basket')]")
    WebElement addToBasket;

    @FindBy(xpath = "//*[contains(text(),'View basket')]")
    WebElement viewBasket;

    public BasketPage addProductInBasketAndViewBasket(){
        click(addToBasket);
        click(viewBasket);
        return new BasketPage(driver);
    }

    @FindBy(xpath = "//*[contains(text(),'Checkout now')]")
    WebElement checkoutNow;

    public CheckoutPage addProductAndCheckoutNow(){
        click(addToBasket);
        click(checkoutNow);
        return new CheckoutPage(driver);
    }
}
