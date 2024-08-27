package testcases;

import base.Browser;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.SearchResult;

import java.io.IOException;

public class HomeTest  extends Browser{

@Test
public void itemSearch() throws IOException, InterruptedException {
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
}




}
