package testcases;

import annotations.TestAnnotation;
import base.Browser;
import enums.TestCategory;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.SearchResult;

public class SearchResultTest extends Browser {

    @TestAnnotation(author = {"Reshma Nayak"}, category = {TestCategory.SMOKE})
    @Test(description = "searching the particular items ")
    public void resultSearch() throws InterruptedException {
        LoginPage login = new LoginPage(driver);
        login.doLogin(config.getProperties("username"),config.getProperties("password"));
        SearchResult result = new SearchResult(driver);
        result.searchForItems(config.getProperties("item1"));
        result.getTitleOfItemSearch();
        result.openSizeChart();
        result.closeSizeChart();




    }
}
