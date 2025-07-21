package pageObjects;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import utilities.AddingDataToExcel;

public class giftCard extends BasePage {
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
    
    public void scrollView() {
    	js.executeScript("window.scrollBy(0, 500);");
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

    public void PrintEmailErrorMessage() throws IOException 
    {
    	String errorMsg=emailErrorMessage.getText();
    	System.out.println("Error Message :");
        System.out.println(errorMsg);
        AddingDataToExcel.writeToExcel(2,1,0,errorMsg);
    }

	

}
