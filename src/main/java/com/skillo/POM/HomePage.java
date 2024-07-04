package com.skillo.POM;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends ISkillo {
    public static final String HOME_PAGE_SUFIX = "posts/all";
    @FindBy(id = "nav-link-login")
    public WebElement navigationLoginButton; // = driver.findElement(By.id("nav-link-login"));
    @FindBy(id = "nav-link-new-post")
    private WebElement navigationNewPostButton;
    @FindBy(xpath = "//i[@class='fas fa-sign-out-alt fa-lg']")
    private WebElement navigationLogOutButton;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    };

    public void openHomePage() {
        navigateTo(HOME_PAGE_SUFIX);
    };

    public void clickOnNavigationLoginButton() {
        waitAndClick(navigationLoginButton);
    };

    public void clickOnNewPostButton() {
        waitAndClick(navigationNewPostButton);
    };

    public void clickOnLogOutButton() {
        waitAndClick(navigationLogOutButton);
    };

    public boolean isNewPostButtonToShown() {
        boolean isButtonShown = false;
        System.out.println(" ACTION @ The user is verifying if the navigation New Post button is presented");
        try {
            wait.until(ExpectedConditions.visibilityOf(navigationNewPostButton));
            System.out.println("CONFIRM # Navigation New Post button is presented to the user");
            isButtonShown = true;
        } catch (TimeoutException e) {
            System.out.println("ERROR ! The navigation New Post button was not presented to the user");
        }
        return isButtonShown;
    };

    public boolean isLogOutButtonShown() {
        boolean isButtonShown = false;
        System.out.println("ACTION @ The user is verifying if the navigation log out button is presented");
        try {
            wait.until(ExpectedConditions.visibilityOf(navigationLogOutButton));
            System.out.println("CONFIRM # Navigation logout button is presented to the user");
            isButtonShown = true;
        } catch (TimeoutException e) {
            System.out.println("ERROR ! The navigation logout button was not presented to the user");
        }
        return isButtonShown;
    };
}
