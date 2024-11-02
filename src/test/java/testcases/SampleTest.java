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
        System.out.println("Login page opened");
    }

    @Step("Enter valid credentials")
    public void enterCredentials() {
        System.out.println("Credentials entered");
    }

    @Step("Submit login form")
    public void submitForm() {
        System.out.println("Form submitted");
    }

    @Description("Test login with valid credentials")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void testValidLogin() {
        openLoginPage();
        enterCredentials();
        submitForm();
        Assert.assertTrue(true); // Replace with actual verification logic
    }
}
