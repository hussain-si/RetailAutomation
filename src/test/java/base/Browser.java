package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.Config;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Browser {
    public WebDriver driver;
    public  Config config ;

   @BeforeClass
    public void setup() throws IOException {
     config = new Config();
        if (config.getProperties("browser").equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().clearResolutionCache().setup();
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
            driver = new ChromeDriver(options);
        } else if (config.getProperties("browser").equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().clearResolutionCache().setup();


            EdgeOptions options = new EdgeOptions();
            options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
            driver = new EdgeDriver(options);
        }else
        if (config.getProperties("browser").equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().clearResolutionCache().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.addPreference("dom.webnotifications.enabled", false); // Example to disable notifications
            options.addPreference("privacy.trackingprotection.enabled", true); // Example to enable tracking protection
            driver = new FirefoxDriver(options);
        }
        else if (config.getProperties("browser").equalsIgnoreCase("remote")) {
            WebDriverManager.edgedriver().setup();


            EdgeOptions options = new EdgeOptions();
            options.addArguments("--headless"); // Enable headless mode
            options.addArguments("--no-sandbox");
            driver = new EdgeDriver(options);
        }
        driver.get(config.getProperties("testSite"));
        driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperties("implicitWait")), TimeUnit.SECONDS);

    }

    @AfterClass
    public void closeDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
