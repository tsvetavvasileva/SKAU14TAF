package com.skillo.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class LoginPage extends ISkillo {
    public static final String LOGIN_PAGE_SUFFIX = "users/login";

    @FindBy(css = "p.h4")
    private WebElement loginPageHeaderTitle;
    @FindBy(name = "usernameOrEmail")
    private WebElement usernameInputField;
    @FindBy(id = "defaultLoginFormPassword")
    private WebElement passwordInputField;
    @FindBy(xpath = "//span[contains(text(),'Remember me')]")
    private WebElement rememberMeLabelText;
    @FindBy(xpath = "//input[contains(@formcontrolname,'rememberMe')]")
    private WebElement rememberMeCheckBox;
    @FindBy(id = "sign-in-button")
    private WebElement loginFormSubmitButton;
    @FindBy(xpath = "//a[contains(.,'Register')]")
    private WebElement loginFormRegistrationLink;
    @FindBy(xpath = "//div[@class=\"toast-message ng-star-inserted\"]")
    private WebElement popUpMsg;
    @FindBy(tagName = "h2")
    private WebElement userNameTag;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void openLoginPage() {
        navigateTo(LOGIN_PAGE_SUFFIX);
    }

    public void provideUserName(String userName) {
        typeTextInField(usernameInputField, userName);
    }

    public void providePassword(String userPassword) {
        typeTextInField(passwordInputField, userPassword);
    }

    public void clickSubmitButton() {
        waitAndClick(loginFormSubmitButton);
        waitPageTobeFullLoaded();
    }

    public void confirmVisibilityOfRememberMeLabelText () {
        wait.until(ExpectedConditions.visibilityOf(rememberMeLabelText));
        waitPageTobeFullLoaded();
    }

    public void markRememberMeCheckbox() {
        waitAndClick(rememberMeCheckBox);
        System.out.println("Remember me is selected.");
    }

    public void verifyLoginPageUrlIsCorrect () {
        wait.until(ExpectedConditions.urlContains("http://training.skillo-bg.com:4200/users/login"));
    }

    public void loginWithUserAndPassword(String userName, String password) {
        provideUserName(userName);
        providePassword(password);
        clickSubmitButton();
        markRememberMeCheckbox();
    }

    public void msgStatusAfterSubmitSuccessfulLogin() {
        String expectedMsgText = "Successful login!";
        String msgText = popUpMsg.getText();
        wait.until(ExpectedConditions.visibilityOf(popUpMsg));
        Assert.assertEquals(msgText, expectedMsgText);
    }

    public void clickOnRegistrationLink(){
        waitAndClick(loginFormRegistrationLink);
    }

    public void msgStatusAfterInvalidLoginWithWrongPassword() {
        String expectedMsgText = "Invalid username or password";
        String msgText = popUpMsg.getText();
        wait.until(ExpectedConditions.visibilityOf(popUpMsg));
        Assert.assertEquals(msgText, expectedMsgText);
    }

    public void msgStatusAfterInvalidLoginWithWrongUsername() {
        String expectedMsgText2 = "User not found";
        String msgText = popUpMsg.getText();
        wait.until(ExpectedConditions.visibilityOf(popUpMsg));
        Assert.assertEquals(msgText, expectedMsgText2);
    }

    public void msgStatusAfterInvalidLoginWithEmptyData() {
        String expectedMsgText3 = "User not found";
        String msgText = popUpMsg.getText();
        wait.until(ExpectedConditions.visibilityOf(popUpMsg));
        Assert.assertEquals(msgText, expectedMsgText3);
    }

    public boolean isLoginFormTitleShown() {
        boolean isShown = false;
        if (isTitleShown(loginPageHeaderTitle)) {
            isShown = true;
        }
        return  isShown;
    }

    public void isUserNameDisplayed (String expectedUserNameIsDisplayed) {
        wait.until(ExpectedConditions.urlContains("http://training.skillo-bg.com:4200/users/"));
        wait.until(ExpectedConditions.visibilityOf(userNameTag));
        String username = userNameTag.getText();
        Assert.assertEquals(username, userNameTag.getText(), "The username is different than expected.");
        System.out.println("Username is displayed.");
    }
}