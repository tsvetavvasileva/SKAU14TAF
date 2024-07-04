package com.skilo.gui;

import com.skillo.POM.*;
import org.testng.annotations.Test;
import utils.ContentGeneration;

import java.util.Random;

public class RegistrationTest extends TestObject{

    @Test(priority= -1)
    public void verifyUserCanRegisterWithValidData() throws InterruptedException {
        System.out.println("=== > *** Verify a new user can register in the system with valid data *** < ===");

        /* ***************************************
        Providing a second way to generate random data
        We are using current date stamp to generate random string
        How : by getting the time at the moment and append some static username
        ***************************************
        */
        final String USERNAME = ContentGeneration.createUser() ;
        final String EMAIL = ContentGeneration.createEmail();

        System.out.println("THE RANDOM GENERATED USERNAME IS: " + USERNAME);
        System.out.println("THE RANDOM GENERATED EMAIL IS: " + EMAIL);

        System.out.println("STEP 1: A guest user has opened the ISkillo HomePage.");
        HomePage homePage = new HomePage(super.getWebDriver());
        homePage.openHomePage();

        System.out.println("STEP 2: The guest user has navigated to ISkillo LoginPage.");
        homePage.clickOnNavigationLoginButton();

        System.out.println("STEP 3: The guest user has clicked on Register link.");
        LoginPage loginPage = new LoginPage(super.getWebDriver());
        loginPage.openLoginPage();
        loginPage.clickOnRegistrationLink();

        System.out.println("STEP 4: The guest user has accessed the Registration form.");
        RegistrationPage registrationPage = new RegistrationPage(super.getWebDriver());
        registrationPage.confirmVisibilityOfRegisterPageHeaderTitle();

        //Must add new valid data for registration. Email must be under 20 chars.
        System.out.println("STEP 5: The guest user has provided valid registration data and has clicked on the Sign In button.");
        registrationPage.fullRegistrationInputsAndActions(USERNAME, EMAIL, "123456");

        System.out.println("STEP 6: The user is successfully registered and logged in after registration with valid data.");
        homePage.confirmVisibilityOfProfileLink();

        System.out.println("STEP 7: The user has successfully clicked on HomePage Profile link after registering and logging in the system.");
        registrationPage.isUserNameDisplayed("Username is displayed.");

        /*  ***************************************
            THERE IS A NEED MORE VERIFICATION TO BE DONE - done
            EXAMPLE user profile name matches the provided user for registration

            ***************************************
        */
    }

    @Test
    public void verifyUserCannotRegisterWithInvalidData() throws InterruptedException {
        System.out.println("=== > *** Verify a new user cannot register in the system with invalid data *** < ===");
        HomePage homePage = new HomePage(super.getWebDriver());

        /* ***************************************
        Providing a second way to generate random data
        We are using current date stamp to generate random string
        How : by getting the time at the moment and append some static username
        ***************************************
        */
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

        System.out.println("STEP 4: The guest user has accessed the Registration form.");
        RegistrationPage registrationPage = new RegistrationPage(super.getWebDriver());
        registrationPage.confirmVisibilityOfRegisterPageHeaderTitle();

        //Must add new valid data for registration. Email must be under 20 chars.
        System.out.println("STEP 5: The guest user has provided invalid registration data and has clicked on the Sign In button.");
        registrationPage.fullRegistrationInputsAndActions(USERNAME, EMAIL, "123456");

        System.out.println("Registration has failed, as user is not able to register successfully with invalid data.");
        registrationPage.msgStatusAfterSubmitUnsuccessfullRegistration();
    }

    //Providing a 3rd way to generate random data
    //There is other option to generate some random string with this method bellow

//    public static String generateRandomString() {
//        int length = 3;
//        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
//        Random random = new Random();
//        StringBuilder randomString = new StringBuilder(length);
//
//        for (int i = 0; i < length; i++) {
//            int index = random.nextInt(characters.length());
//            randomString.append(characters.charAt(index));
//        }
//        return randomString.toString();
//    }

}
