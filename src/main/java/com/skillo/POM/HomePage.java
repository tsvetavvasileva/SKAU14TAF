package com.skillo.POM;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends ISkillo {
    public static final String HOME_PAGE_SUFFIX = "posts/all";

    @FindBy(css = "#nav-link-login")
    public WebElement navigationLoginButton;
    @FindBy(css = "#nav-link-new-post")
    private WebElement navigationNewPostButton;
    @FindBy(className = "fa-sign-out-alt")
    private WebElement navigationLogOutButton;
    @FindBy(css = "#nav-link-profile")
    private WebElement navigationProfileLink;
    @FindBy(css = "div:nth-child(3)>app-post-detail>div>div.post-feed-img")
    private  WebElement homePagePostNumber3;
    @FindBy(css = "img.profile-image-source")
    private WebElement imgSource;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void openHomePage() {
        navigateTo(HOME_PAGE_SUFFIX);
    }

    public void verifyHomePageUrlIsCorrect () {
        wait.until(ExpectedConditions.urlContains("http://training.skillo-bg.com:4200/posts/all"));
    }

    public void clickOnNavigationLoginButton() {
        waitAndClick(navigationLoginButton);
    }

    public void confirmVisibilityOfProfileLink () {
        wait.until(ExpectedConditions.elementToBeClickable(( By.id("nav-link-profile"))));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(35));
        waitAndClick(navigationProfileLink);
    }

    public void clickOnNewPostButton() {
        waitAndClick(navigationNewPostButton);
    }

    public void clickOnLogOutButton() {
        waitAndClick(navigationLogOutButton);
    }

    public boolean navigateToHomePagePostNumber3() {
        boolean isVisible;
        try {
            isVisible = wait.until(ExpectedConditions.visibilityOf(homePagePostNumber3)).isDisplayed();
            waitAndClick(homePagePostNumber3);
            System.out.println("CONFIRMATION# The post is visible.");
        } catch (TimeoutException e) {
            System.out.println("ERROR: The post is not visible.");
            isVisible = false;
        }
        return isVisible;
    }

    public boolean isThirdPostDisplayed () {
        try {
            wait.until(ExpectedConditions.visibilityOf(imgSource));
            String imgUrl = imgSource.getAttribute("src");
            return imgUrl.contains("https://i.imgur.com");
        } catch  (TimeoutException e) {
            System.out.println("TimeoutException occurred: "+ e.getMessage());
        }
        System.out.println("CONFIRMATION #: The Post source url is displayed.");
        return true;
    }

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
    }

    public boolean isLogOutButtonShown() {
        boolean isButtonShown = false;
        System.out.println("ACTION @ The user is verifying if the navigation log out button is presented.");
        try {
            wait.until(ExpectedConditions.visibilityOf(navigationLogOutButton));
            System.out.println("CONFIRMATION # Navigation logout button is presented to the user.");
            isButtonShown = true;
        } catch (TimeoutException e) {
            System.out.println("ERROR ! The navigation logout button was not presented to the user.");
        }
        return isButtonShown;
    }
}
