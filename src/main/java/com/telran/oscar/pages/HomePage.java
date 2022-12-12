package com.telran.oscar.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "login_link")
    WebElement loginRegisterLink;

    public LoginRegisterPage clickOnLoginRegisterLink() {
        click(loginRegisterLink);
        return new LoginRegisterPage(driver);
    }

    @FindBy(css = ".alertinner.wicon")
    WebElement alertIcon;

    public String getTextAlertIcon() {
        return alertIcon.getText();
    }

    @FindBy(css = ".nav-link.mt-2.mt-lg-0")
    WebElement iconUser;

    public ProfilePage clickOnAccount() {
        click(iconUser);
        return new ProfilePage(driver);
    }

    @FindBy(id = "logout_link")
    WebElement logoutLink;

    public HomePage clickOnLogout() {
        click(logoutLink);
        return this;
    }

    public boolean isLogoutLinkLinkExist(){
        return (driver.findElements(By.id("logout_link")).size() > 0);
    }

    @FindBy(xpath = "//*[contains(text(),'All products')]")
    WebElement allProducts;

    public AllProductsPage clickOnAllProducts(){
        click(allProducts);
        return new AllProductsPage(driver);
    }
}
