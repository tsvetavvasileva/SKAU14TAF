package gui.e2e;

import com.skillo.POM.*;
import gui.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class EndToEnd extends BaseTest {

    /*


    //The test case will fail due to the fact that this file is not provided yet
    File postPicture = new File("src\\test\\resources\\upload\\testImg.jpg");
    String caption = "Testing create post caption";


    @Test
    public void endToEndTest() {

        final String NEWUSERNAME = "PROVIDE YOUR OWN CREDS HERE";
        final String EMAIL = "PROVIDE YOUR OWN CREDS HERE";
        final String REGPASSWORD = "PROVIDE YOUR OWN CREDS HERE";
        final String CONFIRMPASSWORD = "PROVIDE YOUR OWN CREDS HERE";


        HomePage homePage = new HomePage(super.driver);
        System.out.println();
        System.out.println("STEP 1: Open iSkilo site.");
        homePage.openHomePage();
        System.out.println("Result: The website is open.");
        boolean isLogOutButtonShown = homePage.isLogOutButtonShown();
        Assert.assertFalse(isLogOutButtonShown);


        System.out.println("STEP 2: Navigate to Registration page.");

        System.out.println("RESULT: The Page is open and title is visible.");

        System.out.println("STEP 3: Checking the place holders of the fields");

        System.out.println("STEP 4: Making a registration.");

        System.out.println("RESULT: The registration is successful.");

        System.out.println("STEP 5: Checking that the user is log in after registration.");

        homePage.isUrlLoaded("http://training.skillo-bg.com:4200/posts/all");

//        System.out.println("STEP:6 Login out");
//        homePage.clickOnLogOutButton();
//        System.out.println("RESULT: The user is log out");


        LoginPage loginPage = new LoginPage(super.driver);
        System.out.println("STEP 7: Verify that the user is on login page.");

        System.out.println("STEP 8: Checking the placeholders of the login page.");

        System.out.println("STEP 9: Marking the \"remember me\" check box.");

        System.out.println("STEP 10: Entering credentials of the newly registered user and submitting.");

        System.out.println("STEP 11: Verifying the submit message.");

        System.out.println("STEP 12: Verifying that the user is log in.");

        System.out.println("STEP 13: Navigating to \"New post\".");

        // Init new PostPageObject here

        System.out.println("STEP 14: Upload new post picture.");


        System.out.println("STEP 15: Enter caption.");

        System.out.println("STEP 16: Create the new post.");

        System.out.println("STEP 17: Verifying the post count.");

        System.out.println("STEP 18: Open the new post.");

        //initit PostModalPage here

        System.out.println("STEP 19: Verifying that the image is visible and the username is correct.");

        System.out.println("STEP 20: Deleting the new post");
;
        System.out.println("RESULT: The post is deleted");

    }


     */
}
