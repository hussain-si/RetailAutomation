package testcases;

import annotations.TestAnnotation;
import base.Browser;
import enums.TestCategory;
import org.testng.annotations.Test;
import pages.*;

public class PaymentPageTest extends Browser {
    @TestAnnotation(author = {"Reshma"}, category = {TestCategory.REGRESSION})
    @Test(description = "verifying the Payment page where we get confirmation of order placed ")
    public void placeOrder() throws InterruptedException {
        LoginPage login = new LoginPage(driver);
        login.doLogin(config.getProperties("username"), config.getProperties("password"));
        SearchResult result = new SearchResult(driver);
        result.getTitleOfItemSearch();
        result.searchForItems(config.getProperties("item1"));
        result.openSizeChart();
        result.closeSizeChart();
        HomePage home = new HomePage(driver);
        home.itemsResults();
        home.checkout();
        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.deleteAddress();
        checkout.addAddress(config.getProperties("address"));
        checkout.selectAddress();
        checkout.confirmOrder();
        PaymentPage payment = new PaymentPage(driver);
        payment.verifyButtonDisplayed();
        payment.navigateToHomePage();
    }
}
