package com.skilo.gui;

import com.skillo.POM.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class EndToEndTest extends TestObject {

    /* ***************************************
        The test case will fail if you are not providing a picture with file name testImg.jpg
        you have to navigate to
        1. SRC (root directory )
        1.1. Go to "test" folder
        1.2. After that open "java"
        1.3. Nxt open "resources"
        1.4. Over there you have to provide picture testImg or 6420.jpeg
       ***************************************
    */
    File postPicture = new File("src\\test\\resources\\uploads\\testImg.jpg");
    String caption = "Testing create post caption";

    @Test
    public void endToEndTest() {
        System.out.println("\n _________________________________________________");
        System.out.println("=== > *** THE IS A END TO END SCENARIO  *** < ===");

        final String NEWUSERNAME = "PROVIDE YOUR OWN CREDS HERE";
        final String EMAIL = "PROVIDE YOUR OWN CREDS HERE";
        final String REGPASSWORD = "PROVIDE YOUR OWN CREDS HERE";
        final String CONFIRMPASSWORD = "PROVIDE YOUR OWN CREDS HERE";

        /*
         ***************************************
         Do we need to start with the registration of a new user
         Should we keep the new username , password , email data
         So we can proceed with the next steps
         Or even more can we print the data so when we read the logs from the run
         we can try to follow the script if needed for debugging
        ***************************************
         */

        HomePage homePage = new HomePage(super.getWebDriver());
        System.out.println();
        System.out.println("STEP 1: Open iSkilo site.");
        homePage.openHomePage();
        System.out.println("Result: The website is open.");

        System.out.println("STEP 2: Navigate to Registration page.");

        System.out.println("RESULT: The Page is open and title is visible.");

        System.out.println("STEP 3: Checking the place holders of the fields");

        System.out.println("STEP 4: Making a registration.");

        System.out.println("RESULT: The registration is successful.");

        System.out.println("STEP 5: Checking that the user is log in after registration.");


        //How to refactor this in a better way -> should we use const with the suffix and the base url
        //Can we create a getBaseUrlMethod in ISkilo
        homePage.isUrlLoaded("http://training.skillo-bg.com:4200/posts/all");

        //***************************************
        //        System.out.println("STEP:6 Login out");
        //        homePage.clickOnLogOutButton();
        //        System.out.println("RESULT: The user is log out");
        //***************************************

        LoginPage loginPage = new LoginPage(super.getWebDriver());
        System.out.println("STEP 7: Verify that the user is on login page.");

        System.out.println("STEP 8: Checking the placeholders of the login page.");

        System.out.println("STEP 9: Marking the \"remember me\" check box.");

        System.out.println("STEP 10: Entering credentials of the newly registered user and submitting.");

        System.out.println("STEP 11: Verifying the submit message.");

        System.out.println("STEP 12: Verifying that the user is log in.");

        System.out.println("STEP 13: Navigating to \"New post\".");

        //***************************************
        //Missing page object initialization
        //How to init a class -. MyClass myclass = new MyClass(super.rakia);
        //Init new PostPageObject here
        //***************************************

        System.out.println("STEP 14: Upload new post picture.");

        System.out.println("STEP 15: Enter caption.");

        System.out.println("STEP 16: Create the new post.");

        System.out.println("STEP 17: Verifying the post count.");

        System.out.println("STEP 18: Open the new post.");

        //***************************************
        //init PostModalPage here
        //***************************************

        System.out.println("STEP 19: Verifying that the image is visible and the username is correct.");

        System.out.println("STEP 20: Deleting the new post");

        System.out.println("RESULT: The post is deleted");
    };
}
