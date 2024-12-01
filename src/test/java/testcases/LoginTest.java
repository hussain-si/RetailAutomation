package testcases;

import annotations.TestAnnotation;
import base.Browser;
import enums.TestCategory;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends Browser {

    @TestAnnotation(author = {"Reshma"}, category = {TestCategory.SMOKE})
    @Test(description = "verifying the login page where we are logging in using the valid credentials which was provided in the config property file")
    public void login() throws InterruptedException {
        LoginPage login = new LoginPage(driver);
        login.doLogin(config.getProperties("username"), config.getProperties("password"));
        Thread.sleep(3000);

    }

}
