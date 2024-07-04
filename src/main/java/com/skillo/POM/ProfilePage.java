package com.skillo.POM;

import org.openqa.selenium.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.io.File;
import java.util.List;


public class ProfilePage extends ISkillo {
    public static final String PROFILE_PAGE_SUFFIX = "users/8376";

    //WebElements or other UI Map
    @FindBy(id = "upload-img")
    private WebElement uploadProfilePic;
//    @FindBy(id = "nav-link-profile")
//    private WebElement navToProfileButton;
    @FindBy(className = "profile-image-source")
    private WebElement imgSource;
//    @FindBy(css = ".edit-profile-pic.ng-star-inserted")
//    private WebElement profileImageUploadButton;
//    @FindBy(tagName = "h2")
//    private WebElement userNameTag;


    public ProfilePage (WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //    User Actions
    public void openProfilePage () {
        navigateTo(PROFILE_PAGE_SUFFIX);
    }

    public int getPostCount () {
        List < WebElement > posts = driver.findElements(By.tagName("app-post"));
        return posts.size();
    }

    public void clickPost (int postIndex) {
        List < WebElement > posts = driver.findElements(By.tagName("app-post"));
        posts.get(postIndex).click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("return document.readyState").equals("complete");
    }

    public void uploadProfilePic (File file) {
        uploadProfilePic.sendKeys(file.getAbsolutePath());
        System.out.println("CONFIRMATION # The image was successfully uploaded.");
    }

    public boolean isProfilePicDisplayed () {
        System.out.println("CONFIRMATION #: The Profile pic is displayed.");
        wait.until(ExpectedConditions.visibilityOf(imgSource));
        String imgUrl = imgSource.getAttribute("src");
        return imgUrl.contains("https://i.imgur.com");
    }
}
