package com.telran.oscar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasePage{

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "delete_profile")
    WebElement deleteProfile;

    @FindBy(id = "id_password")
    WebElement idPassword;

    @FindBy(css = ".btn.btn-lg.btn-danger")
    WebElement buttonDelete;

    public void deleteProfile(String password){
        click(deleteProfile);
        type(idPassword, password);
        click(buttonDelete);
    }
}
