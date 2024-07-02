package com.skillo.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

public class PostPage extends ISkillo {

    //1 CONSTS
    final String POST_PAGE_URL = "/posts/create";

    //2 UI MAP
    @FindBy(id = "create-post")
    private WebElement createP0ostButton;

    //3 CONSTRUCTOR
    public PostPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    };

    public boolean isImageVisible() {
        boolean isVisible = false;
        return isVisible;

    };

    //4. USER ACTIONS

    public String getImageName() {
        String iCanDoIt = "I can do it";
        return iCanDoIt;
    };

    public void uploadPicture(File file) {
        System.out.println("I can do it");
    };

    public void providePostCaption(String caption) {
        System.out.println("Some text here");
    };

    public void clickCreatePostButton() {
        System.out.println("Some Action here");
    };
}
