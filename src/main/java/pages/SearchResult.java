package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

public class SearchResult {
    public WebDriver driver;
    @FindBy(xpath = "//input[@name='search' and @placeholder='Search for items/categories']")
    WebElement searchItem;
    //Finding the title of the item(product) that we searched
    @FindBy(xpath = "//div[@class='MuiCardContent-root css-1qw96cp']/p")
    WebElement element;
    //Opening the size chart
    @FindBy(xpath = "//button[normalize-space()='Size chart']")
    WebElement openSizeCharts;
    //closing the size chart
    @FindBy(xpath = "//div[contains(@class,'MuiDialog-container')]/child::div")
    WebElement closeSizeCharts;
    //size chart selecting from dropdown
    @FindBy(xpath = "(//select[@name='age'])[1]")
    WebElement dropDownSizeChart;


    public SearchResult(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getTitleOfItemSearch() {
        //initializing the variable with empty string
        String titleOfSearchItem = "";

        //assigning the title text to the titleOfSearchItem by using getText() method
        titleOfSearchItem = element.getText();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(element));
        return titleOfSearchItem;
    }
    @Step("Search Item")
    public void searchForItems(String item) throws InterruptedException {
        searchItem.sendKeys(item);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(searchItem));
        searchItem.clear();
    }

    public void openSizeChart() throws InterruptedException {
        if (openSizeCharts.isDisplayed() && openSizeCharts.isEnabled()) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.elementToBeClickable(openSizeCharts)).click();
        }
    }

    public void closeSizeChart() throws InterruptedException {
//Create an instance of Actions class
        Actions actions = new Actions(driver);

//Perform a click action on the element
        actions.moveToElement(closeSizeCharts).click().perform();

//Clicking on "ESC" key closes the size chart modal
        actions.sendKeys(Keys.ESCAPE).perform();

        Thread.sleep(4000);
    }

/*public void sizeChartDropDown() throws InterruptedException {
    JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(dropDownSizeChart));
        Select selectShoeSize = new Select(dropDownSizeChart);
        Thread.sleep(4000);
        selectShoeSize.selectByValue("7");
        Thread.sleep(4000);
    }*/


}
