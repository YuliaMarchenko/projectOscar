package com.telran.oscar.pages;

import data.CheckoutWithoutRegisterData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends BasePage {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "id_username")
    WebElement myEmailAddressIs;

    @FindBy(xpath = "//button[@type='submit' and contains(., 'Continue')]")
    WebElement buttonContinue;

    public CheckoutPage fillWhoAreYou() {
        type(myEmailAddressIs, CheckoutWithoutRegisterData.MY_EMAIL_ADDRESS_IS);
        click(buttonContinue);
        return this;
    }

    @FindBy(id = "id_first_name")
    WebElement firstName;

    @FindBy(id = "id_last_name")
    WebElement lastName;

    @FindBy(id = "id_line1")
    WebElement firstLineOfAddress;

    @FindBy(id = "id_line4")
    WebElement city;

    @FindBy(id = "id_postcode")
    WebElement postcode;

    @FindBy(id = "id_country")
    WebElement country;

    public CheckoutPage fillWhereShouldWeShipTo() {
        type(firstName, CheckoutWithoutRegisterData.FIRST_NAME);
        type(lastName, CheckoutWithoutRegisterData.LAST_NAME);
        type(firstLineOfAddress, CheckoutWithoutRegisterData.FIRST_LINE_OF_ADDRESS);
        type(city, CheckoutWithoutRegisterData.CITY);
        type(postcode, CheckoutWithoutRegisterData.POSTCODE);
        Select selectCountry = new Select(country);
        selectCountry.selectByVisibleText(CheckoutWithoutRegisterData.COUNTRY);
        click(buttonContinue);
        return this;
    }

    @FindBy(id = "view_preview")
    WebElement buttonContinuePayment;

    public CheckoutPage choosePayment() {
        click(buttonContinuePayment);
        return this;
    }

    @FindBy(id = "place-order")
    WebElement placeOrder;

    public CheckoutPage previewOrder() {
        click(placeOrder);
        return this;
    }

    @FindBy(xpath = "//h1")
    WebElement numberOfOrder;

    public String getNumberOfOrder(){
        return numberOfOrder.getText()
                .replace("Order ", "")
                .replace(": confirmation", "");
    }

    @FindBy(xpath = "//*[contains(text(),'Continue shopping')]")
    WebElement continueShopping;

    public AllProductsPage confirmation() {
        click(continueShopping);
        return new AllProductsPage(driver);
    }

    @FindBy(css = ".btn.btn-primary.btn-large.ship-address")
    WebElement shipToThisAddress;

    public CheckoutPage clickOnShipToThisAddress(){
        click(shipToThisAddress);
        return this;
    }
}
