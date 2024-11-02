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

    @Step("Open login page")
    public void openLoginPage() {
        // Code to open the login page
    }

    @Step("Enter valid credentials")
    public void enterCredentials() {
        // Code to enter credentials
    }

    @Step("Submit login form")
    public void submitForm() {
        // Code to submit the form
    }

    @Test
    public void testValidLogin() {
        openLoginPage();
        enterCredentials();
        submitForm();
        // Assertions to verify login success
    }
}
