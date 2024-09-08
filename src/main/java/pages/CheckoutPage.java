package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class CheckoutPage {
 public WebDriver driver;
@FindBy(xpath="(//p[@class = 'MuiTypography-root MuiTypography-body1 css-yg30e6'])[1]")
WebElement selectAddedAddress;
@FindBy(xpath = "(//p[normalize-space()='Delete'])[1]")
WebElement  deleteBtn;
@FindBy(xpath = "//button[@id='add-new-btn']")
WebElement  addNewAddress;
@FindBy(xpath = "//textarea[@placeholder='Enter your complete address']")
WebElement  addAddressBox;
@FindBy(xpath="//button[text() = 'Add']")
WebElement addBtn;
@FindBy(xpath = "//button[text() = 'PLACE ORDER']")
WebElement placeOrderBtn;

public CheckoutPage(WebDriver driver){
 this.driver=driver;
 PageFactory.initElements(driver,this);
}

    public void deleteAddress() throws InterruptedException {
        if(deleteBtn.isDisplayed() && deleteBtn.isEnabled()) {
            //verify the text of delete button
            Assert.assertTrue(true,"Delete Button text"+deleteBtn.getText());
            deleteBtn.click();
            Thread.sleep(4000);
        }
    }

public void addAddress(String addressString) throws InterruptedException {
if(addNewAddress.isDisplayed() && addNewAddress.isEnabled()){
    //verify the text of the addNewAddress button
    Assert.assertTrue(true,"addNewAddress Button text"+addNewAddress.getText());
    addNewAddress.click();
    Thread.sleep(7000);
    //verify that address box is displayed to enter the new address
    if(addAddressBox.isEnabled() && addAddressBox.isDisplayed()){
    //verifying the text of the addAddressBox
    Assert.assertTrue(true,"addAddressBox Button text"+addAddressBox.getText());
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
 Assert.assertTrue(true,"added address text"+selectAddedAddress.getText());
selectAddedAddress.click();
Thread.sleep(4000);
}
}

public void confirmOrder() throws InterruptedException {
if(placeOrderBtn.isDisplayed() && selectAddedAddress.isSelected()) {
placeOrderBtn.getText();
Thread.sleep(5000);
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
wait.until(ExpectedConditions.elementToBeClickable(placeOrderBtn)).click();
Thread.sleep(10000);
}
}

}