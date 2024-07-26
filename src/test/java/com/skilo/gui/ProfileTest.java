package com.skilo.gui;

import com.skillo.POM.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;


public class ProfileTest extends TestObject {

    @DataProvider(name = "PostTestDataProvider")
    public Object[][] getUsers() {
        File postPicture = new File("src\\test\\resources\\uploads\\testUpload.jpg");
        String caption = "Testing create post caption";

        Object[][] objects = {{
                "testingDemos", "testing",
                "testingDemos", postPicture, caption},
        };
        return objects;
    }

    @Test(dataProvider = "PostTestDataProvider")
    public void verifyUserCanPostProfilePicture (String user, String password, String username, File file, String caption) throws InterruptedException {

        final String HOME_PAGE_URL = "posts/all";
        final String LOGIN_PAGE_URL = "users/login";

        System.out.println("STEP 1: A guest user has opened ISkillo website home page.");
        HomePage homePage = new HomePage(super.getWebDriver());
        homePage.openHomePage();
        homePage.isUrlLoaded(HOME_PAGE_URL);

        System.out.println("STEP 2: The user has clicked on Login button.");
        homePage.clickOnNavigationLoginButton();

        System.out.println("STEP 3: The HomePage URL is fully loaded.");
        homePage.isUrlLoaded(LOGIN_PAGE_URL);


        System.out.println("STEP 4: The user has provided correct credentials and has logged in successfully.");
        LoginPage loginPage = new LoginPage(super.getWebDriver());
        loginPage.loginWithUserAndPassword(user, password);

        System.out.println("STEP 5: The user has verified the Profile Link is visible.");
        System.out.println("STEP 6: The user has clicked on Profile Link.");
        homePage.confirmVisibilityOfProfileLink();

        System.out.println("STEP 7: The user has successfully uploaded a new Profile picture.");
        ProfilePage profilePage = new ProfilePage(super.getWebDriver()); // error here !!
        profilePage.uploadProfilePic(file);

        profilePage.isProfilePicDisplayed();
        System.out.println("STEP 8: Checking if the image is visible after upload.");

    }

}
