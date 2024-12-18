package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class CheckoutPage {
 public WebDriver driver;
@FindBy(how= How.XPATH,using="(//p[@class = 'MuiTypography-root MuiTypography-body1 css-yg30e6'])[1]")
private static WebElement selectAddedAddress;
@FindBy(how= How.XPATH,using= "(//p[normalize-space()='Delete'])[1]")
private static WebElement  deleteBtn;
@FindBy(how= How.XPATH,using= "//button[@id='add-new-btn']")
private static WebElement  addNewAddress;
@FindBy(how= How.XPATH,using= "//textarea[@placeholder='Enter your complete address']")
private static WebElement  addAddressBox;
@FindBy(how= How.XPATH,using="//button[text() = 'Add']")
private static WebElement addBtn;
@FindBy(how= How.XPATH,using= "//div[@class='MuiBox-root css-17t5ffy']//following-sibling::button")
private static WebElement placeOrderBtn;

public CheckoutPage(WebDriver driver){
 this.driver=driver;
 PageFactory.initElements(driver,this);
}

    public void deleteAddress() throws InterruptedException {
        if(deleteBtn.isDisplayed() && deleteBtn.isEnabled()) {
            //verify the text of delete button
            
            deleteBtn.click();
            Thread.sleep(5000);
        }
    }

public void addAddress(String addressString) throws InterruptedException {
if(addNewAddress.isDisplayed() && addNewAddress.isEnabled()){
    //verify the text of the addNewAddress button
   
    addNewAddress.click();
    Thread.sleep(7000);
    //verify that address box is displayed to enter the new address
    if(addAddressBox.isEnabled() && addAddressBox.isDisplayed()){
    //verifying the text of the addAddressBox
    
    addAddressBox.sendKeys(addressString);
    //click on ADD button to add address
    addBtn.click();
    Thread.sleep(6000);
    }
}
}

public void selectAddress() throws InterruptedException {
if(selectAddedAddress.isDisplayed()) {
//verify the text of added address
 
selectAddedAddress.click();
Thread.sleep(4000);
}
}

public void confirmOrder() throws InterruptedException {
if(placeOrderBtn.isEnabled()) {
  
placeOrderBtn.click();
/*Thread.sleep(5000);
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
wait.until(ExpectedConditions.elementToBeClickable(placeOrderBtn)).click();*/
Thread.sleep(3000);
}
}

}
