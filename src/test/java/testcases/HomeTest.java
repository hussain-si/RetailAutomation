package testcases;

import annotations.TestAnnotation;
import base.Browser;
import enums.TestCategory;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.SearchResult;

import java.io.IOException;

public class HomeTest extends Browser {

    @TestAnnotation(author = {"Hussain"}, category = {TestCategory.SMOKE})
    @Test(description = "verifying the Home page where we are adding the items to the Cart and navigating to the checkout page")
    public void itemSearch() throws IOException, InterruptedException {
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
    }


}
