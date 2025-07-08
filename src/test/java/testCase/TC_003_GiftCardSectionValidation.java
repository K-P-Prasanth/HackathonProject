package testCase;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.giftCard;
import testBase.BaseClass;

public class TC_003_GiftCardSectionValidation extends BaseClass {

    @Test
    public void validation()  {
        

       

        // Initialize page objects
        HomePage home = new HomePage(driver);
        giftCard gif = new giftCard(driver);

      
        
        home.closePopUp();
        home.clickOnlineGiftCard();

        
        gif.clickNoThanks();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500);");

        gif.selectEmailDeliveryMode();

        gif.giftCardName("Harry");
        gif.giftCardEmail("1233gmail"); // Invalid email
        gif.giftCardMessage("Happy Birthday");

        String errorText = gif.getEmailErrorMessage();
        System.out.println("Error message: " + errorText);

        
    }
}
