package com.skillo.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends ISkillo {

    // 1 CONSTS
    public static final String LOGIN_PAGE_SUFIX = "users/login";

    //2 UI MAP
    //WEB elements
    @FindBy(css = "p.h4")
    public WebElement loginPageHeaderTitle;
    @FindBy(id = "sign-in-button")
    public WebElement loginFormSubmitButton;


    //3 CONSTRUCTOR
    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //4 USER ACTIONS

    public void provideUserName(String userName) {

        // To do
        // Please use the common method created in Iskilo / Abstract Page Object or CommonPageObject(just a different name for some abstract class)
    }

    public void providePassword(String userPassword) {
        //TO do ->  some hint here
        //  typeTextInField();
    }

    public void clickSubmitButton() {
        waitAndClick(loginFormSubmitButton);
    }

    public void loginWithUserAndPassword() {
        System.out.println("TO Do");
    };

    //6 VERIFICATIONS
    public void msgStatusAfterSubmitSuccessfulLogin() {
        System.out.println("To do");
        // To do a bit more advanced at the moment for you
        // You can crate it a bit later whenever you have some more tme
    }

    public void msgStatusAfterInvalidLogin() {
        // To do a bit more advanced at the moment for you
        // You can crate it a bit later whenever you have some more tme
    }

    public void selectingRememberMeCheckBox() {
        // To do a bit more advanced at the moment for you
        // You can crate it a bit later whenever you have some more tme
    }

    //OTHER SUPPORT METHODS

    public boolean isLoginTitleShown() {
        //Some hints here with a method that is created in our ISkilopage

        // return isTitleShown(loginPageHeaderTitle);
        return false;
    }


}