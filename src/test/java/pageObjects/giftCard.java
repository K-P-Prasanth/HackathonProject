package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class giftCard extends BasePage {
	 //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	public giftCard(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "wzrk-cancel")
    WebElement noThanksButton;

    @FindBy(xpath = "//*[@for='deliveryModeEmail']")
    WebElement deliveryModeEmail;

    @FindBy(id = "name")
    WebElement nameField;

    @FindBy(id = "email")
    WebElement emailField;

    @FindBy(id = "message")
    WebElement messageField;

    @FindBy(xpath = "//div[@class='invalid-feedback']")
    WebElement emailErrorMessage;
    
    public void clickNoThanks() {
        wait.until(ExpectedConditions.elementToBeClickable(noThanksButton)).click();
    }

    public void selectEmailDeliveryMode() {
    	wait.until(ExpectedConditions.elementToBeClickable(deliveryModeEmail)).click();
        
    }

    public void giftCardName(String name) {
    	nameField.sendKeys(name);
        
    }

    public void giftCardEmail(String email) {
        emailField.sendKeys(email);
    }

    public void giftCardMessage(String message) {
        messageField.sendKeys(message);
    }

    public String getEmailErrorMessage() {
        return emailErrorMessage.getText();
    }

	

}
