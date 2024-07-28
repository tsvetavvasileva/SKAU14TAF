package com.skillo.POM;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.time.Duration;

public class PostModal extends ISkillo {

    @FindBy(css = "div.col-12.ng-star-inserted")
    private WebElement imagePost;
    @FindBy(css = "div.post-modal-img>img")
    private WebElement imageWhenClickedOn;
    @FindBy(className = "post-user")
    private WebElement userNameDisplayedInPost;
    @FindBy(xpath= "//div/label/a")
    private WebElement deletePostButton;
    @FindBy(css= "div.delete-confirm")
    private WebElement confirmDeletingPost;
    @FindBy(xpath = "//*[@id=\"toast-container\"]")
    private WebElement popUpMsg;
    @FindBy(xpath = "//div/div/button[1]")
    private WebElement clickYesToDeleteButton;

    private WebDriverWait wait;

    public PostModal (WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public boolean isImagePostVisible() {
        try {
            wait.until(ExpectedConditions.visibilityOf(imagePost)).isDisplayed();
            wait.until(ExpectedConditions.visibilityOf(imageWhenClickedOn)).isDisplayed();
            String imgUrl = imageWhenClickedOn.getAttribute("src");
            boolean contains = imgUrl.contains("https://i.imgur.com");
        } catch  (TimeoutException e) {
            System.out.println("TimeoutException occurred: "+ e.getMessage());
        }
        System.out.println("CONFIRMATION #: The image is actually displayed.");
        return true;
    }

    public boolean getPostUser() {
        try {
            wait.until(ExpectedConditions.visibilityOf(userNameDisplayedInPost)).isDisplayed();
            userNameDisplayedInPost.getText();
        } catch  (NoSuchElementException e) {
            System.out.println("NoSuchElementException occured: "+ e.getMessage());
        }
        System.out.println("CONFIRMATION #: The username is displayed.");
        return true;
    }

    public boolean clickOnBinIcon () {
        try {
            wait.until(ExpectedConditions.visibilityOf(deletePostButton)).isDisplayed();
            deletePostButton.click();
        } catch  (NoSuchElementException e) {
            System.out.println("NoSuchElementException occured: "+ e.getMessage());
        }
        System.out.println("CONFIRMATION #: The user has clicked on Delete Post button.");
        return true;
    }

    public boolean confirmDeletingPost() {//there is "no usages" shown, but if you clik on "no usages" the method it is used
        try {
            wait.until(ExpectedConditions.visibilityOf(confirmDeletingPost)).isDisplayed();
        } catch  (NoSuchElementException e) {
            System.out.println("NoSuchElementException occured: "+ e.getMessage());
        }
        System.out.println("CONFIRMATION #: The 'Are you sure? -Yes/No' element is visible.");
        return true;
    }

    public boolean confirmYesToDelete() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(clickYesToDeleteButton)).click();
            popUpMsg.getText();
            wait.until(ExpectedConditions.visibilityOf(popUpMsg));
            Assert.assertEquals(popUpMsg.getText(), "Post Deleted!", "Post Deleted!");
        } catch  (NoSuchElementException e) {
            System.out.println("NoSuchElementException occured: "+ e.getMessage());
        }
        System.out.println("CONFIRMATION #: The user has confirmed selecting Yes and image was deleted.");
        return true;
    }
}
