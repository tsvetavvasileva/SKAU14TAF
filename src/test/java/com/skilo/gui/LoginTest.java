package com.skilo.gui;

import com.skillo.POM.*;
import org.testng.annotations.Test;


public class LoginTest extends TestObject {

    @Test
    public void verifyAlreadyRegisteredUserCanSuccessfullyLogin() {
        System.out.println("\n _________________________________________________");
        System.out.println("=== > *** Verify already registered user can successfully login in the system  *** < ===");

        final String USERNAME = "gandalf";
        final String PASSWORD = "thegray";

        HomePage homePage = new HomePage(super.getWebDriver());

        System.out.println("STEP 1: Not logged in user has open the ISkilo HomePage.");
        homePage.openHomePage();
       //We need to verify that the user is on the Home page
        // We can check examples in lecture 15 for further assistance

        System.out.println("STEP 2: The user has navigated to ISkilo LoginPage");
        homePage.clickOnNavigationLoginButton();

        System.out.println("STEP 3: The user has verified that the LoginPage is open as per requirements ");
        LoginPage loginPage = new LoginPage(super.getWebDriver());
        //We need to do some verifications here
        //How about checking Lecture 14/15 and get verification by url contains ?

        System.out.println("STEP 5: The user has provided a valid username");
        loginPage.provideUserName(USERNAME);

        System.out.println("STEP 6: The user has provided a valid password");
        loginPage.providePassword(PASSWORD);

        System.out.println("STEP 7: The user has clicked on login submit button");
        loginPage.clickSubmitButton();

        //This test case needs a final assertion
        //How should we verify that the user is logged in
        //1 Can we verify the url that contains the user id ?
        //2. Can we check on profile page that the username matches the user with the related credentials ?
        //3. What else can we try to check in order to confirm that the user is successfully login (successful login msg?)
    }


    @Test
    public void verifyAlreadyRegisteredUserCanNotSuccessfullyLoginWithWrongPassword() {
        System.out.println("\n _________________________________________________");
        System.out.println("=== > *** Verify already registered user can NOT successfully login in the system  with WRONG PASSWORD *** < ===");

        final String USERNAME = "gandalf";
        final String PASSWORD = "WRONG_PASS";

        HomePage homePage = new HomePage(super.getWebDriver());

        System.out.println("STEP 1: Not logged in user has open the ISkilo HomePage.");
        homePage.openHomePage();
        //We need to verify that the user is on the Home page
        // We can check examples in lecture 15 for further assistance

        System.out.println("STEP 2: The user has navigated to ISkilo LoginPage");
        homePage.clickOnNavigationLoginButton();

        System.out.println("STEP 3: The user has verified that the LoginPage is open as per requirements ");
        LoginPage loginPage = new LoginPage(super.getWebDriver());
        //We need to do some verifications here
        //How about checking Lecture 14/15 and get verification by url contains ?

        System.out.println("STEP 5: The user has provided a valid username");
        loginPage.provideUserName(USERNAME);

        System.out.println("STEP 6: The user has provided a valid password");
        loginPage.providePassword(PASSWORD);

        System.out.println("STEP 7: The user has clicked on login submit button");
        loginPage.clickSubmitButton();

        //This test case needs a final assertion
        //How should we verify that the user is logged in or not ?
        //1 Can we verify the url that contains the user id is not shown ?
        //2. Can we check on profile cannot be opened when not longed-in ?
        //3. What else can we try to check in order to confirm that the user is successfully login (not successful login msg?)
    };

    @Test
    public void verifyAlreadyRegisteredUserCanNotSuccessfullyLoginWithWrongUsername() {
        System.out.println("\n _________________________________________________");
        System.out.println("=== > *** Verify already registered user can NOT successfully login in the system  with WRONG USERNAME *** < ===");

        final String USERNAME = "WRONG";
        final String PASSWORD = "correctPassword";

        HomePage homePage = new HomePage(super.getWebDriver());

        System.out.println("STEP 1: Not logged in user has open the ISkilo HomePage.");
        homePage.openHomePage();
        //We need to verify that the user is on the Home page
        // We can check examples in lecture 15 for further assistance

        System.out.println("STEP 2: The user has navigated to ISkilo LoginPage");
        homePage.clickOnNavigationLoginButton();

        System.out.println("STEP 3: The user has verified that the LoginPage is open as per requirements ");
        LoginPage loginPage = new LoginPage(super.getWebDriver());
        //We need to do some verifications here
        //How about checking Lecture 14/15 and get verification by url contains ?

        System.out.println("STEP 5: The user has provided a valid username");
        loginPage.provideUserName(USERNAME);

        System.out.println("STEP 6: The user has provided a valid password");
        loginPage.providePassword(PASSWORD);

        System.out.println("STEP 7: The user has clicked on login submit button");
        loginPage.clickSubmitButton();

        //This test case needs a final assertion
        //How should we verify that the user is logged in or not ?
        //1 Can we verify the url that contains the user id is not shown ?
        //2. Can we check on profile cannot be opened when not longed-in ?
        //3. What else can we try to check in order to confirm that the user is successfully login (not successful login msg?)
    };

    @Test
    public void verifyAlreadyRegisteredUserCanNotSuccessfullyLoginWithNotProvidedCredentials() {
        System.out.println("\n _________________________________________________");
        System.out.println("=== > *** Verify already registered user can NOT successfully login in the system  with NO CREDENTIALS *** < ===");

        final String USERNAME = " "; //empty or one space provided for login info
        final String PASSWORD = " "; //

        HomePage homePage = new HomePage(super.getWebDriver());

        System.out.println("STEP 1: Not logged in user has open the ISkilo HomePage.");
        homePage.openHomePage();
        //We need to verify that the user is on the Home page
        // We can check examples in lecture 15 for further assistance

        System.out.println("STEP 2: The user has navigated to ISkilo LoginPage");
        homePage.clickOnNavigationLoginButton();

        System.out.println("STEP 3: The user has verified that the LoginPage is open as per requirements ");
        LoginPage loginPage = new LoginPage(super.getWebDriver());
        //We need to do some verifications here
        //How about checking Lecture 14/15 and get verification by url contains ?

        System.out.println("STEP 5: The user has provided a valid username");
        loginPage.provideUserName(USERNAME);

        System.out.println("STEP 6: The user has provided a valid password");
        loginPage.providePassword(PASSWORD);

        System.out.println("STEP 7: The user has clicked on login submit button");
        loginPage.clickSubmitButton();

        //This test case needs a final assertion
        //How should we verify that the user is logged in or not ?
        //1 Can we verify the url that contains the user id is not shown ?
        //2. Can we check on profile cannot be opened when not longed-in ?
        //3. What else can we try to check in order to confirm that the user is successfully login (not successful login msg?)
    };
}
