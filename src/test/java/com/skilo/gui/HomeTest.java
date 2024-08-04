package com.skilo.gui;

import com.skillo.POM.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTest extends TestObject {

    @Test
    public void verifyUserCanNavigateToAnAlreadyCreatedPost() {
        System.out.println("=== > *** Verify the user can navigate to an already created post on their HomePage after login *** < ===");

        final String HOME_PAGE_URL = "posts/all";
        final String LOGIN_PAGE_URL = "users/login";

        final String USERNAME = "gandalf";
        final String PASSWORD = "thegray";

        System.out.println("STEP 1: A guest user has opened ISkillo website home page.");
        HomePage homePage = new HomePage(super.getWebDriver());
        homePage.openHomePage();
        homePage.isUrlLoaded(HOME_PAGE_URL);

        System.out.println("STEP 2: The user has clicked on Login button.");
        homePage.clickOnNavigationLoginButton();

        System.out.println("STEP 3: The LoginPage URL is fully loaded.");
        homePage.isUrlLoaded(LOGIN_PAGE_URL);

        System.out.println("STEP 4: The user has provided a valid username.");
        LoginPage loginPage = new LoginPage(super.getWebDriver());
        loginPage.provideUserName(USERNAME);

        System.out.println("STEP 5: The user has provided a valid password.");
        loginPage.providePassword(PASSWORD);

        System.out.println("STEP 6: The user has clicked on the Sign in button.");
        loginPage.clickSubmitButton();

        System.out.println("STEP 7: The user has verified they are located on HomePage after successful login.");
        homePage.confirmVisibilityOfProfileLink();
        loginPage.msgStatusAfterSubmitSuccessfulLogin();

        System.out.println("STEP 8: The user has verified their successful login as they checked logout button is also visible.");
        homePage.isLogOutButtonShown();

        System.out.println("STEP 6: The user has scrolled down to the third post on HomePage and has opened it.");
        homePage.navigateToHomePagePostNumber3();
        Assert.assertTrue(homePage.isThirdPostDisplayed(), "The third post is visible!");
        }
}