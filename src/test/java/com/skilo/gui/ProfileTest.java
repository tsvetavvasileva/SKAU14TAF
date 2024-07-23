package com.skilo.gui;

import com.skillo.POM.*;
import org.testng.annotations.Test;

public class ProfileTest extends TestObject {

    @Test
    public void verifyUserCanNavigateToProfilePage () {
        System.out.println("STEP 1: A guest user has opened the ISkillo HomePage.");
        HomePage homePage = new HomePage(super.getWebDriver());
        homePage.openHomePage();

        System.out.println("STEP 2: The guest user has navigated to ISkillo LoginPage.");
        LoginPage loginPage = new LoginPage(super.getWebDriver());
        loginPage.openLoginPage();
        loginPage.verifyLoginPageUrlIsCorrect();

        loginPage.provideUserName("tsveta.v");
        System.out.println("STEP 3: The user has provided a valid username.");

        loginPage.providePassword("123Abc");
        System.out.println("STEP 4: The user has provided a valid password.");

        loginPage.clickSubmitButton();
        System.out.println("STEP 5: The user has clicked on the Sign in button.");

        System.out.println("STEP 6: The user is successfully logged in the system with valid credentials.");
        homePage.isLogOutButtonShown();
        loginPage.msgStatusAfterSubmitSuccessfulLogin();
        homePage.confirmVisibilityOfProfileLink();

        System.out.println("STEP 7: The user has successfully clicked on Profile link and has opened ProfilePage.");
        ProfilePage profilePage = new ProfilePage(super.getWebDriver());
        profilePage.openProfilePage();
        profilePage.isProfilePicDisplayed();

    }

}
