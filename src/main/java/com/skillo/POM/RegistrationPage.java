package com.skillo.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class RegistrationPage extends ISkillo {
    public static final String REGISTER_PAGE_SUFFIX = "users/register";

    @FindBy(css = "app-register>div>div>form>h4")
    private WebElement registerPageHeaderTitle;
    @FindBy(xpath = "//div/input[contains(@formcontrolname,'username')]")
    private WebElement usernameInputField;
    @FindBy(xpath = "//div/input[contains(@formcontrolname,'email')]")
    private WebElement emailInputField;
    @FindBy(xpath = "//div/input[contains(@formcontrolname,'password')]")
    private WebElement passwordInputField;
    @FindBy(xpath = "//div/input[contains(@formcontrolname,'confirmPassword')]")
    private WebElement confirmPasswordInputField;
    @FindBy(css = "#sign-in-button")
    private WebElement registrationSignInButton;
    @FindBy(css = "div>div.col-12.col-lg-6.profile-user-settings>h2")
    private WebElement userNameTag;
    @FindBy(xpath = "//div[@class=\"toast-bottom-right toast-container\"]")
    private WebElement popUpMsg;

    public RegistrationPage (WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void confirmVisibilityOfRegisterPageHeaderTitle () {
        wait.until(ExpectedConditions.visibilityOf(registerPageHeaderTitle));
        waitPageTobeFullLoaded();
    }

    public void provideUsername (String username) {
        typeTextInField(usernameInputField, username);
    }

    public void provideEmail (String email) {
        typeTextInField(emailInputField, email);
    }

    public void providePassword (String password) {
        typeTextInField(passwordInputField, password);
    }

    public void provideConfirmPassword (String password) {
        typeTextInField(confirmPasswordInputField, password);
    }

    public void clickOnSignInButton () {
        waitAndClick(registrationSignInButton);
    }

    public void msgStatusAfterSubmitUnsuccessfulRegistration () {
        String expectedMsgText = "Registration failed!";
        String msgText = popUpMsg.getText();
        wait.until(ExpectedConditions.visibilityOf(popUpMsg));
        Assert.assertEquals(msgText, expectedMsgText);
    }

    public void fullRegistrationInputsAndActions (String username, String email, String password) {
        provideUsername(username);
        provideEmail(email);
        providePassword(password);
        provideConfirmPassword(password);
        clickOnSignInButton();
    }

    public boolean isUserNameDisplayed (String expectedUserNameIsDisplayed) {
        wait.until(ExpectedConditions.urlContains("http://training.skillo-bg.com:4200/users/"));
        wait.until(ExpectedConditions.visibilityOf(userNameTag));
        String username = userNameTag.getText();
        Assert.assertEquals(username, userNameTag.getText(), "The username is different than expected.");
        System.out.println("Username is displayed.");
        return false;
    }
}



