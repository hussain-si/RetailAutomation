package testcases;

import base.Browser;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.SearchResult;

public class SearchResultTest extends Browser {

    @Test
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
