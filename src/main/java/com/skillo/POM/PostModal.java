package com.skillo.POM;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PostModal extends ISkillo {

    //CONST if there are no const you can leave it empty

    //2. UI MAP
    private final WebElement modalElement;

    //3. CONSTRUCTOR
    public PostModal(WebDriver driver) {
        super(driver);
        this.modalElement = driver.findElement(By.className("post-modal"));
    }

    //4 USER ACTIONS
    public void clickOnBinIcon() {

    };

    //VERIFICATIONS
    public boolean isImageVisible() {
            return false;
    };

    public String getPostUser() {
        String IcanDoIt  = "I Can do it";
        return IcanDoIt;
    };

    public void confirmDeletingPost() {

    };
}
