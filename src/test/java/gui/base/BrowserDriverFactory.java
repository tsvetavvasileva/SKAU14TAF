package gui.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;

public class BrowserDriverFactory {
    public static final String TEST_RESOURCES_DIR = "src/test/resources";
    public static final String DOWNLOAD_DIR = TEST_RESOURCES_DIR.concat("download/");
    private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    private String browser;
    private Logger log;

    public BrowserDriverFactory(String browser) {
        this.browser = browser.toLowerCase();

    }

    protected WebDriver createDriver() {

         System.out.println("Create driver: " + browser);

        switch (browser) {
            case "chrome":
                // System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                WebDriverManager.chromedriver().setup();
                driver.set( new ChromeDriver(configChromeOptions()));
                break;

            case "firefox":
                System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
                driver.set(new FirefoxDriver());
                break;

            default:
                System.out.println("Do not know how to start: " + browser + ", starting chrome.");
                //System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                driver.set( new ChromeDriver(configChromeOptions()));
                break;
        }

        return driver.get();
    }

    private ChromeOptions configChromeOptions() {
        Map<String, Object> prefs = new HashMap<>();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        prefs.put("download.default_directory", System.getProperty("user.dir").concat("\\").concat(DOWNLOAD_DIR));
        chromeOptions.setExperimentalOption("prefs", prefs);

        return chromeOptions;
    }
}
