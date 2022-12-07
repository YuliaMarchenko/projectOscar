package com.telran.oscar.pages;

import data.ShippingAddressData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasketPage extends BasePage{

    public BasketPage(WebDriver driver) {
        super(driver);
    }

    @FindBy()
    WebElement proceedToCheckout;

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

    public BasePage order(){
        click(proceedToCheckout);
        type(firstName, ShippingAddressData.FIRST_NAME);
        type(lastName, ShippingAddressData.LAST_NAME);
        type(firstLineOfAddress, ShippingAddressData.FIRST_LINE_OF_ADDRESS);
        type(city, ShippingAddressData.CITY);
        type(postcode, ShippingAddressData.POSTCODE);
        type(country, ShippingAddressData.COUNTRY);
        return this;
    }
}
