package com.telran.oscar.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailHistoryPage extends BasePage{
    public EmailHistoryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[contains(text(),'Email History')]")
    WebElement emailHistory;

    public EmailHistoryPage clickOnEmailHistory(){
        click(emailHistory);
        return this;
    }

    public boolean existNotificationWhenRegister(){
        return driver.findElements(By.xpath("//a[contains(text(),'Thank you for registering.')]")).size() > 0;
    }

    public boolean existNotificationWhenPasswordChange(){
        return driver.findElements(By.xpath("//a[contains(text(),'Your password changed at example.com.')]")).size() > 0;
    }
}
