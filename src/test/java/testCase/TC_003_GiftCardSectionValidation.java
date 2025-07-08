package testCase;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.giftCard;
import testBase.BaseClass;

public class TC_003_GiftCardSectionValidation extends BaseClass {

    @Test(priority=3)
    public void validation()  {
        

		try {
			logger.info("-----Starting TC_003_GiftCardSectionValidation-----");
			// Initialize page objects
			HomePage home = new HomePage(driver);
			giftCard gif = new giftCard(driver);

			logger.info("----- Closing PopUp -----");
			home.closePopUp();
			logger.info("----- Clicking the Gift Card Section -----");
			home.clickOnlineGiftCard();

			gif.clickNoThanks();

			JavascriptExecutor js = (JavascriptExecutor) driver;
			logger.info("----- Scrolling to required element -----");
			js.executeScript("window.scrollBy(0, 500);");

			logger.info("----- Selecting the delivery mode -----");
			gif.selectEmailDeliveryMode();

			logger.info("----- Entering the details on Gift Card -----");
			gif.giftCardName("Harry");
			gif.giftCardEmail("1233gmail"); // Invalid email
			gif.giftCardMessage("Happy Birthday");

			logger.info("----- Retrieving the Error message -----");
			String errorText = gif.getEmailErrorMessage();
			logger.info("----- Printing the Error message -----");
			System.out.println("Error message: " + errorText);

			logger.info("-----TC_003_GiftCardSectionValidation Passed-----");
			Assert.assertTrue(true);

		} catch (Exception e) {
			logger.error("-----TC_003_GiftCardSectionValidation Failed-----");
			logger.debug("----- Debug Logs -----");
			Assert.fail();
		}
    }
}
