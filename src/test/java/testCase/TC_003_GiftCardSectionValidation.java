package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.giftCard;
import testBase.BaseClass;

public class TC_003_GiftCardSectionValidation extends BaseClass {

    @Test(priority=3)
    public void GiftCardSectionValidation()  
    {
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

			logger.info("----- Scrolling to required element -----");
			gif.scrollView();

			logger.info("----- Selecting the delivery mode -----");
			gif.selectEmailDeliveryMode();

			logger.info("----- Entering the details on Gift Card -----");
			gif.giftCardName("Harry");
			gif.giftCardEmail("1233gmail"); // Invalid email
			gif.giftCardMessage("Happy Birthday");

			logger.info("----- Printing the Error message -----");
			gif.PrintEmailErrorMessage();

			logger.info("-----TC_003_GiftCardSectionValidation Passed-----");
			Assert.assertTrue(true);

		} catch (Exception e) {
			logger.error("-----TC_003_GiftCardSectionValidation Failed-----");
			logger.debug("----- Debug Logs -----");
			Assert.fail();
		}
    }
}
