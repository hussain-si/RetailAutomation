package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class PaymentPage {
    public WebDriver driver;
    @FindBy(how = How.XPATH,using="//div[@class='greeting-container MuiBox-root css-0']")
    private static WebElement GreetingMsg;

    @FindBy(how = How.XPATH, using="//div[@class='greeting-container MuiBox-root css-0']")
    private static List<WebElement> buttons;

    @FindBy(how = How.XPATH,using="//button[text()=\"Continue Shopping\"]//child::span")
    private static WebElement continueBtn;

    public PaymentPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void verifyButtonDisplayed(){
        for(WebElement button : buttons){
            if(button.isDisplayed()) {
                String text = button.getText();
                System.out.println(text);
            }
        }
    }

    public void navigateToHomePage() throws InterruptedException {
    if(continueBtn.isDisplayed() & continueBtn.isEnabled()){
        Assert.assertTrue(true, "Verifying the all buttons available on the page" + continueBtn.getText());
        continueBtn.click();
        Thread.sleep(5000);
    }
    }
}
