package com.skilo.gui;

import com.skillo.POM.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import java.io.File;

public class PostTest extends TestObject{

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
    public void verifyUserCanCreateNewPostAndDeleteIt(String user, String password, String username, File file, String caption) throws InterruptedException {
        System.out.println("=== > *** Verify the user can create a new post and delete the new post *** < ===");

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

        System.out.println("STEP 5: The user has verified the New Post button is visible.");
        homePage.isNewPostButtonToShown();

        System.out.println("STEP 6: The user has clicked on New Post button.");
        homePage.clickOnNewPostButton();


        System.out.println("STEP 7: The user has successfully uploaded a new picture.");
        PostPage postPage = new PostPage(super.getWebDriver());
        postPage.uploadPicture(file);

        System.out.println("STEP 8: Checking if the image is visible after upload.");
        Assert.assertTrue(postPage.isImageVisible(), "The image is visible!");

        System.out.println("STEP 9: Checking if the image name is correct");
        Assert.assertEquals(file.getName(), postPage.getImageName(), "The image name is correct.");

        System.out.println("STEP 10: The user has provided a caption for the new image.");
        postPage.providePostCaption(caption);

        System.out.println("STEP 11: The user has clicked on Submit Button to create the new post.");
        postPage.clickCreatePostButton();

        PostModal postModal = new PostModal(super.getWebDriver());
        postModal.isImagePostVisible();


        System.out.println("Step 12: The user has clicked on the first post.");
        ProfilePage profilePage = new ProfilePage((super.getWebDriver()));
        profilePage.clickPost(0);

        System.out.println("STEP 13: Verifying that the image and Username are visible.");
        Assert.assertTrue(postModal.isImagePostVisible(), "The image is visible");
        Assert.assertTrue(postModal.getPostUser(),"The username is visible!");

        System.out.println("STEP 14: Checking if the post count is correct.");
        profilePage.getPostCount();

        int expectedPostCount = 1;
        int actualPostCount = profilePage.getPostCount();

        Assert.assertEquals(actualPostCount, expectedPostCount,"The number of Posts is incorrect!");
        System.out.println("The actual post count is" + actualPostCount);


        System.out.println("STEP 15: The user has deleted the new post so this test can be repeated.");
        postModal.clickOnBinIcon();
        postModal.confirmYesToDelete();
        Assert.assertTrue(postModal.confirmYesToDelete(),"The image was successfully is deleted.");

    }
}
