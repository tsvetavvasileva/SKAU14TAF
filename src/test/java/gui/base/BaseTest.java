package gui.base;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;


public class BaseTest {

    public static final String MAIN_RESOURCES_DIR = "src/test/resources/";
    public static final String DOWNLOAD_DIR = MAIN_RESOURCES_DIR.concat("download/");
    public static final String SCREENSHOTS_DIR = MAIN_RESOURCES_DIR.concat("screenshots/");
    public static final String REPORTS_DIR = MAIN_RESOURCES_DIR.concat("reports/");
    public WebDriver driver;
    public Logger log;

    @BeforeSuite
    protected final void setupTestSuite() throws IOException {
//        cleanDirectory(REPORTS_DIR);
//        cleanDirectory(SCREENSHOTS_DIR);
    }

    @Parameters({ "browser" })

    @BeforeMethod(alwaysRun = true)

    public void setUp(@Optional("chrome") String browser, Method method) {

        BrowserDriverFactory factory = new BrowserDriverFactory(browser);
        driver = factory.createDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult testResult) throws IOException {
        System.out.println("Close driver");

        takeScreenshot(testResult);

        if (!(driver ==null)){
             System.out.println("The driver is about to be closed.");
            driver.quit();
            Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
        }
    }

    @AfterSuite
    public void deleteDownloadedFiles() throws IOException {
        cleanDirectory(DOWNLOAD_DIR);
    }

    private void cleanDirectory(String directoryPath) throws IOException {

        File directory = new File(directoryPath);

        Assert.assertTrue(directory.isDirectory(), "Invalid directory!");
        //Assert.assertFalse(directory.isDirectory(), "Invalid directory!");

        FileUtils.cleanDirectory(directory);
        String[] fileList = directory.list();
        if (fileList != null && fileList.length == 0) {
            System.out.printf("All files are deleted in Directory: %s%n", directoryPath);
        } else {
            System.out.printf("Unable to delete the files in Directory:%s%n", directoryPath);
        }
    }

    private void takeScreenshot(ITestResult testResult) {
        if (ITestResult.FAILURE == testResult.getStatus()) {
            try {
                TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
                File screenshot = takesScreenshot.getScreenshotAs(OutputType.FILE);
                String testName = testResult.getName();
                FileUtils.copyFile(screenshot, new File(SCREENSHOTS_DIR.concat(testName).concat(".jpg")));
            } catch (IOException e) {
                System.out.println("Unable to create a screenshot file: " + e.getMessage());
            }
        }
    }

}
