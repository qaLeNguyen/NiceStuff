package common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebDriverUtil {
    private static final Logger logger = LogManager.getLogger(WebDriverUtil.class);
    private static WebDriver driver;
    private static WebDriverWait wait;
    private static WebDriverWait click;

    private WebDriverUtil() {
    }

    static String browser = System.getProperty("browser", "EDGE").toUpperCase();

    public static WebDriver getDriver() {
        if (driver == null) {

            switch (browser) {
                case "FIREFOX":
                    System.setProperty("webdriver.gecko.driver", "D:\\5. Webdriver\\geckodriver-v0.34.0-win-aarch64\\geckodriver.exe");
                    driver = new FirefoxDriver();
                    break;
                case "CHROME":
                    System.setProperty("webdriver.chrome.driver", "D:\\5. Webdriver\\chromedriver-win64\\chromedriver.exe");
                    driver = new ChromeDriver();
                    break;
                case "EDGE":
                    System.setProperty("webdriver.edge.driver", "D:\\5. Webdriver\\edgedriver_win64\\msedgedriver.exe");
                    driver = new EdgeDriver();
                    break;
                default:
                    throw new IllegalArgumentException("Unsupported browser: " + browser);
            }
            driver.manage().window().maximize();
            logger.info("WebDriver initialized: {}", browser);

        }
        return driver;
    }

    public static WebDriverWait getWait() {
        if (wait == null && driver != null) {
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }
        return wait;
    }

    public static WebDriverWait getClick() {
        if (click == null && driver != null) {
            click = new WebDriverWait(driver, Duration.ofSeconds(20));
        }
        return click;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
            wait = null;
            logger.info("WebDriver quit");
        }
    }

}
