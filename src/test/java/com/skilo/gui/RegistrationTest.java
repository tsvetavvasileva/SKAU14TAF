package com.skilo.gui;

import com.skillo.POM.*;
import org.testng.annotations.Test;
import utils.ContentGeneration;

public class RegistrationTest extends TestObject{

    @Test(priority= -1)
    public void verifyUserCanRegisterWithValidData() {
        System.out.println("=== > *** Verify a new user can register in the system with valid data *** < ===");

        final String USERNAME = ContentGeneration.createUser() ;
        final String EMAIL = ContentGeneration.createEmail();

        System.out.println("THE RANDOM GENERATED USERNAME IS: " + USERNAME);
        System.out.println("THE RANDOM GENERATED EMAIL IS: " + EMAIL);

        System.out.println("STEP 1: A guest user has opened the ISkillo HomePage.");
        HomePage homePage = new HomePage(super.getWebDriver());
        homePage.openHomePage();

        System.out.println("STEP 2: The guest user has navigated to ISkillo LoginPage.");
        LoginPage loginPage = new LoginPage(super.getWebDriver());
        loginPage.openLoginPage();

        System.out.println("STEP 3: The guest user has clicked on Register link.");
        loginPage.clickOnRegistrationLink();

        System.out.println("STEP 4: The guest user has successfully accessed the Registration form.");
        RegistrationPage registrationPage = new RegistrationPage(super.getWebDriver());
        registrationPage.confirmVisibilityOfRegisterPageHeaderTitle();

        System.out.println("STEP 5: The guest user has provided valid registration data and has clicked on the Sign In button.");
        registrationPage.fullRegistrationInputsAndActions(USERNAME, EMAIL, "123456");

        System.out.println("STEP 6: The user is successfully registered and logged in after registration with valid data.");
        homePage.confirmVisibilityOfProfileLink();

        System.out.println("STEP 7: The user has successfully clicked on HomePage Profile link after registering and logging in the system.");
        registrationPage.isUserNameDisplayed("Username is displayed.");
    }

    @Test
    public void verifyUserCannotRegisterWithInvalidData() {
        System.out.println("=== > *** Verify a new user cannot register in the system with invalid data *** < ===");
        HomePage homePage = new HomePage(super.getWebDriver());

        final String USERNAME = "W" ;
        final String EMAIL = "WRONG";

        System.out.println("THE RANDOM GENERATED USERNAME IS: " + USERNAME);
        System.out.println("THE RANDOM GENERATED EMAIL IS: " + EMAIL);

        System.out.println("STEP 1: A guest user has opened the ISkillo HomePage.");
        homePage.openHomePage();

        System.out.println("STEP 2: The guest user has navigated to ISkillo LoginPage.");
        homePage.clickOnNavigationLoginButton();

        System.out.println("STEP 3: The guest user has clicked on the Register link.");
        LoginPage loginPage = new LoginPage(super.getWebDriver());
        loginPage.clickOnRegistrationLink();

        System.out.println("STEP 4: The guest user has successfully accessed the Registration form.");
        RegistrationPage registrationPage = new RegistrationPage(super.getWebDriver());
        registrationPage.confirmVisibilityOfRegisterPageHeaderTitle();

        System.out.println("STEP 5: The guest user has provided invalid registration data and has clicked on the Sign In button.");
        registrationPage.fullRegistrationInputsAndActions(USERNAME, EMAIL, "123456");

        System.out.println("Registration has failed, the user is not able to register successfully with invalid data.");
        registrationPage.msgStatusAfterSubmitUnsuccessfulRegistration();
    }
}
