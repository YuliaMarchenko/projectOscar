package com.telran.oscar.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderHistoryPage extends BasePage{
    public OrderHistoryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[contains(text(),'Order History')]")
    WebElement orderHistory;

    public OrderHistoryPage clickOnOrderHistory(){
        click(orderHistory);
        return this;
    }

    public boolean existNumberOfHistory(String numberOrder){
        return driver.findElements(By.xpath("//a[contains(text(),'" + numberOrder + "')]")).size() > 0;
    }
}
