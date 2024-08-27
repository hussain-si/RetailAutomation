package testcases;

import base.Browser;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.LoginPage;
import utils.Config;

import java.io.IOException;

public class LoginTest extends Browser {

    @Test
public void login() throws InterruptedException {
LoginPage login = new LoginPage(driver);
login.doLogin(config.getProperties("username"), config.getProperties("password"));
Thread.sleep(3000);

    }

}
