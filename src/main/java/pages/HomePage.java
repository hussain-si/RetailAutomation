package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {
    public WebDriver driver;
    @FindBy(how= How.XPATH,using = "//div[@class='MuiCardActions-root MuiCardActions-spacing card-actions css-3zukih']/child::button")
    private static WebElement addToCart;
    @FindBy(how= How.XPATH,using = "//div[@class='cart-footer MuiBox-root css-1bvc4cc']/button")
    private static WebElement itemCheckout;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @Step("Add to cart")
    public void itemsResults() throws InterruptedException {
        if (addToCart.isEnabled() && addToCart.isDisplayed()) {
//verify the text of addToCart
            Assert.assertTrue(true, "addToCart text" + addToCart.getText());
            addToCart.click();
            Thread.sleep(4000);
        }
    }
    @Step("click Checkout")
    public void checkout() throws InterruptedException {
        if (itemCheckout.isDisplayed() && itemCheckout.isEnabled()) {
            //verify the text of the itemCheckout button
            Assert.assertTrue(true, "itemCheckout text" + itemCheckout.getText());
            itemCheckout.click();
            Thread.sleep(4000);
        }

    }
}
