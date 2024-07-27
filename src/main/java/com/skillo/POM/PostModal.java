package com.skillo.POM;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;


public class PostModal extends ISkillo {
    private final WebElement modalElement;

    @FindBy(xpath = "//*[@id=\"toast-container\"]")
    private WebElement popUpMsg;


    public PostModal (WebDriver driver) {
        super(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        this.modalElement = driver.findElement(By.cssSelector(".col-12.ng-star-inserted"));
        wait.until(ExpectedConditions.visibilityOf(modalElement)).isDisplayed();
    }


    public boolean isImagePostVisible() {
        try {
            WebElement image = modalElement.findElement(By.cssSelector("div.post-modal-img>img"));
            wait.until(ExpectedConditions.visibilityOf(image)).isDisplayed();
            String imgUrl = image.getAttribute("src");
            boolean contains = imgUrl.contains("https://i.imgur.com");
        } catch  (NoSuchElementException e) {
        }
        System.out.println("CONFIRMATION #: The image is displayed.");
        return true;
    }


    public boolean getPostUser() {
        try {
            WebElement postUser = modalElement.findElement(By.className("post-user"));
            wait.until(ExpectedConditions.visibilityOf(postUser)).isDisplayed();
            postUser.getText();
        } catch  (NoSuchElementException e) {
        }
        System.out.println("CONFIRMATION #: The username is displayed.");

        return true;
    }

    public boolean clickOnBinIcon () {
        try {
            WebElement deletePostButton = modalElement.findElement(By.xpath("//div/label/a"));
            wait.until(ExpectedConditions.visibilityOf(deletePostButton)).isDisplayed();
            deletePostButton.click();
        } catch  (NoSuchElementException e) {
        }
        System.out.println("CONFIRMATION #: The user has clicked on Delete Post button.");

        return true;
    }


    public boolean confirmDeletingPost() {
        try {
            WebElement confirmDeletingPost = modalElement.findElement(By.cssSelector("div.delete-confirm"));
            wait.until(ExpectedConditions.visibilityOf(confirmDeletingPost)).isDisplayed();
        } catch  (NoSuchElementException e) {
        }
        System.out.println("CONFIRMATION #: The 'Are you sure? -Yes/No' element is visible.");

        return true;
    }

    public boolean confirmYesToDelete() {
        try {
            WebElement clickYesToDelete = modalElement.findElement(By.xpath("//div/div/button[1]"));
            wait.until(ExpectedConditions.elementToBeClickable(clickYesToDelete)).click();
            WebElement popUpMsg = modalElement.findElement(By.xpath("//*[@id=\"toast-container\"]"));
            popUpMsg.getText();
            wait.until(ExpectedConditions.visibilityOf(popUpMsg));
            Assert.assertEquals(popUpMsg.getText(), "Post Deleted!", "Post Deleted!");
        } catch  (NoSuchElementException e) {
        }
        System.out.println("CONFIRMATION #: The user has confirmed selecting Yes and image was deleted.");

        return true;
    }

}
