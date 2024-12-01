package pages;

import com.relevantcodes.extentreports.LogStatus;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage {

    public WebDriver driver;
    @FindBy(how= How.XPATH,using= "//div[@class='css-vb6e92']/child::button[1]")
    private static WebElement login;
    @FindBy(how= How.XPATH,using= "//input[@id='username' and @name='username']")
    private static WebElement username;
    @FindBy(how= How.XPATH,using = "//input[@id='password']")
    private static WebElement password;
    @FindBy(how= How.XPATH,using = "//button[@type='button' and text()='Login to QKart']")
    private static WebElement loginBtn;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Login Page")
    public void doLogin(String username, String password) throws InterruptedException {
        if (login.isDisplayed() && login.isEnabled()) {
            Assert.assertTrue(true, "Login text" + login.getText());
            login.click();
        }
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        if (loginBtn.isDisplayed() && loginBtn.isEnabled()) {
            Assert.assertTrue(true, "Login Button" + loginBtn.getText());
            loginBtn.click();
        }


        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);

    }
}
