package gui.regression.login;

import com.skillo.POM.HomePage;
import com.skillo.POM.LoginPage;
import gui.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {

    @Test
    public void navigatingAndLoggingIn() {

        final String USERNAME = "gandalf";
        final String PASSWORD = "thegray";

        HomePage homePage = new HomePage(super.driver);

        System.out.println("STEP 1: Not logged in user has open the ISkilo HomePage.");
        homePage.openHomePage();
        boolean isLogOutButtonShown = homePage.isLogOutButtonShown();
        Assert.assertFalse(isLogOutButtonShown);

        System.out.println("STEP 2: The user has navigated to ISkilo LoginPage");
        homePage.clickOnLoginButton();

        System.out.println("STEP 3: The user has verified that the LoginPage is open as per requirements ");
        LoginPage loginPage = new LoginPage(super.driver);
        loginPage.isLoginTitleShown();
        System.out.println("STEP 5: The user has provided a valid username");
        loginPage.provideUserName(USERNAME);

        System.out.println("STEP 6: The user has provided a valid password");
        loginPage.providePassword(PASSWORD);

        System.out.println("STEP 7: The user has clicked on login submit button");
        loginPage.clickSubmitButton();

    }
}
