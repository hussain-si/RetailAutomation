package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Config;

import java.io.IOException;

public class HomePage {
public WebDriver driver;
@FindBy(xpath="//div[@class='MuiCardActions-root MuiCardActions-spacing card-actions css-3zukih']/child::button")
WebElement addToCart;
@FindBy(xpath="//div[@class='cart-footer MuiBox-root css-1bvc4cc']/button")
WebElement itemCheckout;

public HomePage(WebDriver driver){
this.driver=driver;
PageFactory.initElements(driver,this);
}

public void itemsResults() throws InterruptedException {
   if(addToCart.isEnabled() && addToCart.isDisplayed())  {
       //verify the text of addToCart

       addToCart.click();
       Thread.sleep(4000);
   }
}

public void checkout() throws InterruptedException {
    if(itemCheckout.isDisplayed() && itemCheckout.isEnabled()){
        itemCheckout.click();
        Thread.sleep(4000);
    }

}
}
