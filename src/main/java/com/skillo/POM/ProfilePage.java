package com.skillo.POM;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.util.List;

public class ProfilePage extends ISkillo {

    //1 CONSTS


    //2 UI MAP
    @FindBy(id = "upload-img")
    private WebElement uploadProfilePic;

    //3 CONSTRUCTOR
    public ProfilePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //4 USER ACTIONS

    //5 Verifications
}
