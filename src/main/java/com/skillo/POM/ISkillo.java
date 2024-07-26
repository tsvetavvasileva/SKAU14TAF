package com.skillo.POM;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ISkillo {
    private final String BASE_URL = "http://training.skillo-bg.com:4200/";
    WebDriver driver;
    WebDriverWait wait;

    public ISkillo(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void navigateTo(String pageURSuffix) {
        String currentURL = BASE_URL + pageURSuffix;
        System.out.println(currentURL+ " " + ("this is the current url"));
        driver.get(currentURL);

        waitPageTobeFullLoaded();
    }

    public void waitAndClick(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));

        element.click();
        System.out.println("The user has clicked on element.");

        waitPageTobeFullLoaded();
    }

    public void typeTextInField(WebElement element, String inputText) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(inputText);

        waitPageTobeFullLoaded();
    }


    public void waitPageTobeFullLoaded() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("return document.readyState").equals("complete");
        System.out.println("DOM tree is fully loaded.");
    }

    public boolean isUrlLoaded(String pageURL) {
        waitPageTobeFullLoaded();
        return wait.until(ExpectedConditions.urlContains(pageURL));
    }

    public boolean isTitleShown(WebElement element) {
        boolean isTitleShown = false;
         System.out.println("ACTION @ The user is verifying if the Registration title is shown.");
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
             System.out.println("CONFIRM # The Registration title is shown to the user.");
            isTitleShown = true;
        } catch (NoSuchElementException e) {
             System.out.println("ERROR ! The title is not presented the user is not on Registration page.");
        }
        return isTitleShown;
    }

}
