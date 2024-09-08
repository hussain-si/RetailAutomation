package testcases;

import annotations.TestAnnotation;
import base.Browser;
import enums.TestCategory;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.SearchResult;

import java.io.IOException;

public class CheckoutPageTest extends Browser {

@TestAnnotation(author = {"Reshma Nayak"}, category = {TestCategory.SMOKE})
@Test(description = "verifying the checkout page where we are adding the shipping address and confirming the payment")
public void placeOrder() throws InterruptedException {
LoginPage login = new LoginPage(driver);
login.doLogin(config.getProperties("username"),config.getProperties("password"));
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
}
}
