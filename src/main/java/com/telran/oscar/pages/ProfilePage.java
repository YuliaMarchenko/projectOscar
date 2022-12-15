package com.telran.oscar.pages;

import data.UserData;
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

    @FindBy(xpath = "//a[contains(text(),'Profile')]")
    WebElement profileLink;

    public ProfilePage clickOnProfileLink(){
        click(profileLink);
        return this;
    }

    @FindBy(xpath = "//a[contains(text(),'Change password')]")
    WebElement changePassword;

    @FindBy(id = "id_old_password")
    WebElement oldPassword;

    @FindBy(id = "id_new_password1")
    WebElement newPassword;

    @FindBy(id = "id_new_password2")
    WebElement newPasswordConfirmation;

    @FindBy(css = ".btn.btn-lg.btn-primary")
    WebElement saveButton;

    public ProfilePage changePassword(){
        click(changePassword);
        type(oldPassword, UserData.REGISTER_PASSWORD);
        type(newPassword, UserData.REGISTER_WRONG_CONFIRM_PASSWORD);
        type(newPasswordConfirmation, UserData.REGISTER_WRONG_CONFIRM_PASSWORD);
        click(saveButton);
        return this;
    }
}
