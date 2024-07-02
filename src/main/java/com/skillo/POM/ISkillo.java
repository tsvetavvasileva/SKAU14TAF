package com.skillo.POM;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ISkillo {

    // EXAMPLE FOR PAGE  OBJECT STRUCTURE
    // 1. CONSTS
    //Define the constants here
    final String BASE_URL = "http://training.skillo-bg.com:4200/";
    WebDriver driver;
    WebDriverWait wait;


    //2 CONSTRUCTOR
    public ISkillo(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //SUPPORT METHODS FOR THE ALL PAGES - COMMON SUPPORT METHODS OOP
    public void waitAndClick(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));

        element.click();

        waitPageTobeFullLoaded();
    }

    public void typeTextInField(WebElement element, String inputText) {
      //To do
    }

    public void navigateTo(String pageURLsufix) {
        String currentURL = BASE_URL + pageURLsufix;
        driver.get(currentURL);
        waitPageTobeFullLoaded();
    }

    public boolean isUrlLoaded(String pageURL) {
        //To do
       return false;
    }

    public void waitPageTobeFullLoaded() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("return document.readyState").equals("complete");
        System.out.println("DOM for the page is fully loaded");

    }

    public String getPlaceholder(WebElement element) {
        String iCanDoIt = "To do";
        return  iCanDoIt;
        //To do
    };

    public boolean isPlaceholderCorrect( ) {
        //To do
      return false;
    };

    public boolean isTitleShown() {
        //To do
        return false;
    };

}
