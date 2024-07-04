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
       //We need to verify that the user is on the Home page - done
        // We can check examples in lecture 15 for further assistance

        System.out.println("STEP 2: The guest user has navigated to ISkillo LoginPage.");
        homePage.clickOnNavigationLoginButton();

        System.out.println("STEP 3: The guest user has verified that the LoginPage is opened as per requirements.");
        LoginPage loginPage = new LoginPage(super.getWebDriver());
        loginPage.openLoginPage();
        loginPage.verifyLoginPageUrlIsCorrect();
        loginPage.isLoginFormTitleShown();
        //We need to do some verifications here - done
        //How about checking Lecture 14/15 and get verification by url contains ?

        System.out.println("STEP 4: The user has provided a valid username.");
        loginPage.provideUserName(USERNAME);

        System.out.println("STEP 5: The user has provided a valid password.");
        loginPage.providePassword(PASSWORD);

        System.out.println("STEP 6: The guest user has selected Remember me option.");
        loginPage.confirmVisibilityOfrememberMeLabelText();
        loginPage.markRememberMeCheckbox();

        System.out.println("STEP 7: The user has clicked on the Sign in button.");
        loginPage.clickSubmitButton();

        System.out.println("STEP 8: The user is successfully logged in the system with valid data.");
        homePage.confirmVisibilityOfProfileLink();
        loginPage.msgStatusAfterSubmitSuccessfulLogin();

        System.out.println("STEP 9: The user has successfully clicked on HomePage Profile link after logging in the system with valid data.");
        loginPage.isUserNameDisplayed("Username is displayed.");

        //This test case needs a final assertion - done
        //How should we verify that the user is logged in
        //1 Can we verify the url that contains the user id ?
        //2. Can we check on profile page that the username matches the user with the related credentials ?
        //3. What else can we try to check in order to confirm that the user is successfully login (successful login msg?)
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
        //We need to verify that the user is on the Home page - done
        // We can check examples in lecture 15 for further assistance

        System.out.println("STEP 2: The guest user has navigated to ISkillo LoginPage.");
        homePage.clickOnNavigationLoginButton();

        System.out.println("STEP 3: The guest user has verified that the LoginPage is opened as per requirements.");
        LoginPage loginPage = new LoginPage(super.getWebDriver());
        loginPage.openLoginPage();
        loginPage.verifyLoginPageUrlIsCorrect();
        loginPage.isLoginFormTitleShown();
        //We need to do some verifications here - done
        //How about checking Lecture 14/15 and get verification by url contains ?

        System.out.println("STEP 4: The user has provided a valid username.");
        loginPage.provideUserName(USERNAME);

        System.out.println("STEP 5: The user has provided a valid password.");
        loginPage.providePassword(PASSWORD);

        System.out.println("STEP 6: The guest user has selected Remember me option.");
        loginPage.confirmVisibilityOfrememberMeLabelText();
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
        //We need to verify that the user is on the Home page - done
        // We can check examples in lecture 15 for further assistance

        System.out.println("STEP 2: The guest user has navigated to ISkillo LoginPage.");
        homePage.clickOnNavigationLoginButton();

        System.out.println("STEP 3: The guest user has verified that the LoginPage is opened as per requirements.");
        LoginPage loginPage = new LoginPage(super.getWebDriver());
        loginPage.openLoginPage();
        loginPage.verifyLoginPageUrlIsCorrect();
        loginPage.isLoginFormTitleShown();
        //We need to do some verifications here - done
        //How about checking Lecture 14/15 and get verification by url contains ?

        System.out.println("STEP 4: The user has provided a valid username.");
        loginPage.provideUserName(USERNAME);

        System.out.println("STEP 5: The user has provided an invalid password.");
        loginPage.providePassword(PASSWORD);

        System.out.println("STEP 6: The user has clicked on the Sign In button");
        loginPage.clickSubmitButton();

        System.out.println("STEP 7: The user has provided wrong data and is not logged in the system.");
        loginPage.msgStatusAfterInvalidLoginWithWrongPassword();
        loginPage.verifyLoginPageUrlIsCorrect();

        //This test case needs a final assertion - done
        //How should we verify that the user is logged in or not ?
        //1 Can we verify the url that contains the user id is not shown ?
        //2. Can we check on profile cannot be opened when not longed-in ?
        //3. What else can we try to check in order to confirm that the user is successfully login (not successful login msg?)
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
        //We need to verify that the user is on the Home page - done
        // We can check examples in lecture 15 for further assistance

        System.out.println("STEP 2: The guest user has navigated to ISkillo LoginPage.");
        homePage.clickOnNavigationLoginButton();

        System.out.println("STEP 3: The user has verified that the LoginPage is opened as per requirements.");
        LoginPage loginPage = new LoginPage(super.getWebDriver());
        loginPage.openLoginPage();
        loginPage.verifyLoginPageUrlIsCorrect();
        loginPage.isLoginFormTitleShown();
        //We need to do some verifications here - done
        //How about checking Lecture 14/15 and get verification by url contains ?

        System.out.println("STEP 4: The user has provided a wrong username.");
        loginPage.provideUserName(USERNAME);

        System.out.println("STEP 5: The user has provided a valid password.");
        loginPage.providePassword(PASSWORD);

        System.out.println("STEP 6: The user has clicked on Sign In button.");
        loginPage.clickSubmitButton();

        System.out.println("STEP 7: The user has provided wrong data and is not logged in the system.");
        loginPage.msgStatusAfterInvalidLoginWithWrongUsername();
        loginPage.verifyLoginPageUrlIsCorrect();

        //This test case needs a final assertion - done
        //How should we verify that the user is logged in or not ?
        //1 Can we verify the url that contains the user id is not shown ?
        //2. Can we check on profile cannot be opened when not longed-in ?
        //3. What else can we try to check in order to confirm that the user is successfully login (not successful login msg?)
    }

    @Test
    public void verifyAlreadyRegisteredUserCanNotSuccessfullyLoginWithNotProvidedCredentials() throws InterruptedException {
        System.out.println("=== > *** Verify a user cannot successfully login in the system with NO CREDENTIALS *** < ===");

        final String USERNAME = ". "; //empty or one dot provided for login info
        final String PASSWORD = " "; //

        HomePage homePage = new HomePage(super.getWebDriver());

        System.out.println("STEP 1: A guest user has open the ISkillo HomePage.");
        homePage.openHomePage();
        homePage.verifyHomePageUrlIsCorrect();
        //We need to verify that the user is on the Home page - done
        // We can check examples in lecture 15 for further assistance

        System.out.println("STEP 2: The guest user has navigated to ISkillo LoginPagel");
        homePage.clickOnNavigationLoginButton();

        System.out.println("STEP 3: The guest user has verified that the LoginPage is opened as per requirements.");
        LoginPage loginPage = new LoginPage(super.getWebDriver());
        loginPage.openLoginPage();
        loginPage.verifyLoginPageUrlIsCorrect();
        loginPage.isLoginFormTitleShown();
        //We need to do some verifications here - done
        //How about checking Lecture 14/15 and get verification by url contains ?

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

        //This test case needs a final assertion - done
        //How should we verify that the user is logged in or not ?
        //1 Can we verify the url that contains the user id is not shown ?
        //2. Can we check on profile cannot be opened when not longed-in ?
        //3. What else can we try to check in order to confirm that the user is successfully login (not successful login msg?)
    }

}
