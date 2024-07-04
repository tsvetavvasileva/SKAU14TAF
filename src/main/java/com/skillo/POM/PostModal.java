package com.skillo.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class PostModal extends ISkillo {
    private final WebElement modalElement;

    WebElement iframeElement = driver.findElement(By.name("iframe"));
    String iframeId = iframeElement.getAttribute("id");
    String iframeName = iframeElement.getAttribute("name");


    public PostModal (WebDriver driver) {
        super(driver);
        this.modalElement = driver.findElement(By.cssSelector("[class='post-modal-img']"));
    }

    public boolean isImageVisible () {
        boolean isVisible;
        try {
            WebElement image = By.cssSelector("[class='post-modal-img']").findElement(modalElement);
            isVisible = wait.until(ExpectedConditions.visibilityOf(image)).isDisplayed();
        } catch (NoSuchElementException e) {
            System.out.println("Element is not visible");
            isVisible = false;
        }
        return isVisible;
    }

    public String getPostUser () {
        WebElement postUser = modalElement.findElement(By.className("[class*='post-user']"));
        wait.until(ExpectedConditions.visibilityOf(postUser));
        return postUser.getText();
    }

    public void clickOnBinIcon () {
        WebElement deletePostButton = modalElement.findElement(By.cssSelector(".delete-ask"));
        wait.until(ExpectedConditions.visibilityOf(deletePostButton));
        deletePostButton.click();
        waitPageTobeFullLoaded();
    }

    public void confirmDeletingPost () {
        WebElement confirmDeletingPost = modalElement.findElement(By.cssSelector(".delete-confirm"));
        wait.until(ExpectedConditions.visibilityOf(confirmDeletingPost));
        confirmDeletingPost.click();
        waitPageTobeFullLoaded();
    }

    public String getIframeInfo () {
        iframeId = iframeElement.getAttribute("id");
        iframeName = iframeElement.getAttribute("name");
        return "id" + "name";
    }
}
