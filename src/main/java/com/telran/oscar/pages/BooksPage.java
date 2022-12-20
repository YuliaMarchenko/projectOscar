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

    @FindBy(xpath ="(//*[contains(text(),'Add to basket')])[1]")
    WebElement addFirstProductToBasket;

    @FindBy(xpath = "//*[contains(text(),'View basket')]")
    WebElement viewBasket;

    public BasketPage addProductInBasketAndViewBasket(){
        click(addFirstProductToBasket);
        click(viewBasket);
        return new BasketPage(driver);
    }

    @FindBy(xpath = "(//*[contains(text(),'Add to basket')])[2]")
    WebElement addSecondProductToBasket;

    public BasketPage addSecondProductInBasket(){
        click(addSecondProductToBasket);
        return new BasketPage(driver);
    }

    @FindBy(xpath = "//*[contains(text(),'Checkout now')]")
    WebElement checkoutNow;

    public CheckoutPage addProductAndCheckoutNow(){
        click(addFirstProductToBasket);
        click(checkoutNow);
        return new CheckoutPage(driver);
    }

    @FindBy(xpath = "//li[1]//div[@class='product_price w-100']//p[@class='price_color']")
    WebElement priceFirstBook;

    public double getPriceFirstBook(){
        return getPriceBook(priceFirstBook);
    }

    public String getPriceFirstBookAsString(){
        return priceFirstBook.getText();
    }

    @FindBy(xpath = "//li[2]//div[@class='product_price w-100']//p[@class='price_color']")
    WebElement priceSecondBook;

    public double getPriceSecondBook(){
        return getPriceBook(priceSecondBook);
    }

    public double getPriceBook(WebElement priceBook){
        return Double.parseDouble(priceBook.getText().replace("£", ""));
    }

    @FindBy(xpath = "(//h3//a)[5]")
    WebElement bookForReview;

    @FindBy(css = "#write_review")
    WebElement writeReview;

    @FindBy(css = "#id_title")
    WebElement title;

    @FindBy(xpath = "(//i[@class='fas fa-star'])[3]")
    WebElement scoreThree;

    @FindBy(css = "#id_body")
    WebElement bodyReview;

    @FindBy(css = "#id_name")
    WebElement nameRevierer;

    @FindBy(css = "#id_email")
    WebElement emailRevierer;

    @FindBy(xpath = "//button[contains(text(),'Save review')]")
    WebElement saveReview;

    public BooksPage writeReview(){
        click(bookForReview);
        click(writeReview);
        type(title, "review of book");
        click(scoreThree);
        type(bodyReview, "I don't recommend");
        type(nameRevierer, "Vasia");
        type(emailRevierer, "emailVasia@test.com");
        click(saveReview);
        return this;
    }

    public boolean existCustomerReviews(){
        return driver.findElements(By.xpath("//h2[contains(text(), 'Customer Reviews')]")).size() > 0;
    }
}
