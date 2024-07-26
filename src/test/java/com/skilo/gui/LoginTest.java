package com.skilo.gui;

import com.skillo.POM.*;
import org.testng.annotations.Test;

public class LoginTest extends TestObject {


    @Test
    public void verifyAlreadyRegisteredUserCanSuccessfullyLogin() throws InterruptedException {
        System.out.println("=== > *** Verify a registered user can successfully login in the system with valid credentials *** < ===");

        final String USERNAME = "gandalf";
        final String PASSWORD = "thegray";

        HomePage homePage = new HomePage(super.getWebDriver());

        System.out.println("STEP 1: A guest user has opened the ISkillo HomePage.");
        homePage.openHomePage();
        homePage.verifyHomePageUrlIsCorrect();


        System.out.println("STEP 2: The guest user has navigated to ISkillo LoginPage.");
        homePage.clickOnNavigationLoginButton();

        System.out.println("STEP 3: The guest user has verified that the LoginPage is opened as per requirements.");
        LoginPage loginPage = new LoginPage(super.getWebDriver());
        loginPage.openLoginPage();
        loginPage.verifyLoginPageUrlIsCorrect();
        loginPage.isLoginFormTitleShown();


        System.out.println("STEP 4: The user has provided a valid username.");
        loginPage.provideUserName(USERNAME);

        System.out.println("STEP 5: The user has provided a valid password.");
        loginPage.providePassword(PASSWORD);

        System.out.println("STEP 6: The guest user has selected Remember me option.");
        loginPage.confirmVisibilityOfRememberMeLabelText();
        loginPage.markRememberMeCheckbox();

        System.out.println("STEP 7: The user has clicked on the Sign in button.");
        loginPage.clickSubmitButton();

        System.out.println("STEP 8: The user is successfully logged in the system with valid data.");
        homePage.confirmVisibilityOfProfileLink();
        loginPage.msgStatusAfterSubmitSuccessfulLogin();

        System.out.println("STEP 9: The user has successfully clicked on HomePage Profile link after logging in the system with valid data.");
        loginPage.isUserNameDisplayed("Username is displayed.");


    }

    @Test
    public void verifyAlreadyRegisteredUserCanSuccessfullyLoginAndLogOut() throws InterruptedException {
        System.out.println("=== > *** Verify a registered user can successfully login in the system with valid credentials *** < ===");

        final String USERNAME = "gandalf";
        final String PASSWORD = "thegray";

        HomePage homePage = new HomePage(super.getWebDriver());

        System.out.println("STEP 1: A guest user has opened the ISkillo HomePage.");
        homePage.openHomePage();
        homePage.verifyHomePageUrlIsCorrect();


        System.out.println("STEP 2: The guest user has navigated to ISkillo LoginPage.");
        homePage.clickOnNavigationLoginButton();

        System.out.println("STEP 3: The guest user has verified that the LoginPage is opened as per requirements.");
        LoginPage loginPage = new LoginPage(super.getWebDriver());
        loginPage.openLoginPage();
        loginPage.verifyLoginPageUrlIsCorrect();
        loginPage.isLoginFormTitleShown();


        System.out.println("STEP 4: The user has provided a valid username.");
        loginPage.provideUserName(USERNAME);

        System.out.println("STEP 5: The user has provided a valid password.");
        loginPage.providePassword(PASSWORD);

        System.out.println("STEP 6: The guest user has selected Remember me option.");
        loginPage.confirmVisibilityOfRememberMeLabelText();
        loginPage.markRememberMeCheckbox();

        System.out.println("STEP 7: The user has clicked on the Sign in button.");
        loginPage.clickSubmitButton();

        System.out.println("STEP 8: The user is successfully logged in the system with valid data.");
        homePage.confirmVisibilityOfProfileLink();
        loginPage.msgStatusAfterSubmitSuccessfulLogin();

        System.out.println("STEP 9: The user has successfully clicked on HomePage Profile link after logging in the system with valid data.");
        loginPage.isUserNameDisplayed("Username is displayed.");

        System.out.println("STEP 9: The user has successfully clicked on the LogOut Button.");
        homePage.clickOnLogOutButton();

    }

    @Test
    public void verifyAlreadyRegisteredUserCanNotSuccessfullyLoginWithWrongPassword() throws InterruptedException {
        System.out.println("=== > *** Verify a user cannot successfully login in the system with WRONG PASSWORD *** < ===");

        final String USERNAME = "gandalf";
        final String PASSWORD = "WRONG_PASS";

        HomePage homePage = new HomePage(super.getWebDriver());

        System.out.println("STEP 1: A guest user has opened the ISkillo HomePage.");
        homePage.openHomePage();
        homePage.verifyHomePageUrlIsCorrect();


        System.out.println("STEP 2: The guest user has navigated to ISkillo LoginPage.");
        homePage.clickOnNavigationLoginButton();

        System.out.println("STEP 3: The guest user has verified that the LoginPage is opened as per requirements.");
        LoginPage loginPage = new LoginPage(super.getWebDriver());
        loginPage.openLoginPage();
        loginPage.verifyLoginPageUrlIsCorrect();
        loginPage.isLoginFormTitleShown();


        System.out.println("STEP 4: The user has provided a valid username.");
        loginPage.provideUserName(USERNAME);

        System.out.println("STEP 5: The user has provided an invalid password.");
        loginPage.providePassword(PASSWORD);

        System.out.println("STEP 6: The user has clicked on the Sign In button");
        loginPage.clickSubmitButton();

        System.out.println("STEP 7: The user has provided wrong data and is not logged in the system.");
        loginPage.msgStatusAfterInvalidLoginWithWrongPassword();
        loginPage.verifyLoginPageUrlIsCorrect();


    }

    @Test
    public void verifyAlreadyRegisteredUserCanNotSuccessfullyLoginWithWrongUsername() {
        System.out.println("=== > *** Verify a user cannot successfully login in the system with WRONG USERNAME *** < ===");

        final String USERNAME = "WRONG";
        final String PASSWORD = "correctPassword";

        HomePage homePage = new HomePage(super.getWebDriver());

        System.out.println("STEP 1: A guest user has opened the ISkillo HomePage.");
        homePage.openHomePage();
        homePage.verifyHomePageUrlIsCorrect();


        System.out.println("STEP 2: The guest user has navigated to ISkillo LoginPage.");
        homePage.clickOnNavigationLoginButton();

        System.out.println("STEP 3: The user has verified that the LoginPage is opened as per requirements.");
        LoginPage loginPage = new LoginPage(super.getWebDriver());
        loginPage.openLoginPage();
        loginPage.verifyLoginPageUrlIsCorrect();
        loginPage.isLoginFormTitleShown();


        System.out.println("STEP 4: The user has provided a wrong username.");
        loginPage.provideUserName(USERNAME);

        System.out.println("STEP 5: The user has provided a valid password.");
        loginPage.providePassword(PASSWORD);

        System.out.println("STEP 6: The user has clicked on Sign In button.");
        loginPage.clickSubmitButton();

        System.out.println("STEP 7: The user has provided wrong data and is not logged in the system.");
        loginPage.msgStatusAfterInvalidLoginWithWrongUsername();
        loginPage.verifyLoginPageUrlIsCorrect();

    }

    @Test
    public void verifyAlreadyRegisteredUserCanNotSuccessfullyLoginWithNotProvidedCredentials() throws InterruptedException {
        System.out.println("=== > *** Verify a user cannot successfully login in the system with NO CREDENTIALS *** < ===");

        final String USERNAME = ". ";
        final String PASSWORD = " ";

        HomePage homePage = new HomePage(super.getWebDriver());

        System.out.println("STEP 1: A guest user has open the ISkillo HomePage.");
        homePage.openHomePage();
        homePage.verifyHomePageUrlIsCorrect();


        System.out.println("STEP 2: The guest user has navigated to ISkillo LoginPage.");
        homePage.clickOnNavigationLoginButton();

        System.out.println("STEP 3: The guest user has verified that the LoginPage is opened as per requirements.");
        LoginPage loginPage = new LoginPage(super.getWebDriver());
        loginPage.openLoginPage();
        loginPage.verifyLoginPageUrlIsCorrect();
        loginPage.isLoginFormTitleShown();


        System.out.println("STEP 4: The user has provided an empty username.");
        loginPage.provideUserName(USERNAME);

        System.out.println("STEP 5: The user has provided an empty password.");
        loginPage.providePassword(PASSWORD);

        System.out.println("STEP 6: The user has clicked on Sign In button.");
        loginPage.clickSubmitButton();
        loginPage.verifyLoginPageUrlIsCorrect();

        System.out.println("STEP 7: The user has not provided any login data and is not logged in the system.");
        loginPage.msgStatusAfterInvalidLoginWithEmptyData();
        loginPage.verifyLoginPageUrlIsCorrect();


    }

}
