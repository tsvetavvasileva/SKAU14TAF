package com.skillo.POM;

import org.openqa.selenium.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.util.List;


public class ProfilePage extends ISkillo {
    public static final String PROFILE_PAGE_SUFFIX = "users/8376";


    @FindBy(id = "upload-img")
    private WebElement uploadProfilePic;
    @FindBy(className = "profile-image-source")
    private WebElement imgSource;


    public ProfilePage (WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
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

    public void uploadProfilePic (File file) {// shows no usages, but if you click on it, you will be able to see it is used and where-
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
