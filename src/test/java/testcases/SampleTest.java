package testcases;
import io.qameta.allure.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SampleTest {


    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        // Initialize WebDriver, e.g., ChromeDriver
    }

    @Test(description = "Test login with valid credentials")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Login Feature")
    @Story("User logs in with valid credentials")
    public void testValidLogin() {
        login("username", "password");
        Assert.assertTrue(isLoggedIn());
    }

    @Step("Login with username {0} and password {1}")
    public void login(String username, String password) {
        // Logic for login steps
    }

    @Step("Check if user is logged in")
    public boolean isLoggedIn() {
        // Check login success logic
        return true;
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
