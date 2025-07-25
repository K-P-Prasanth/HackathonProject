package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import testBase.BaseClass;
import pageObjects.BookShelvesPage;

public class TC_001_DisplayNameAndPrice extends BaseClass{
	
	@Test(priority=1)
	public void DisplayNameAndPrice()
	{
		try {
			logger.info("-----Starting TC_001_DisplayNameAndPrice-----");
			HomePage hp = new HomePage(driver);
			BookShelvesPage bsp = new BookShelvesPage(driver);
			logger.info("----- CLosing PoP-Ups -----");
			hp.closePopUp();
			logger.info("----- Searching BookShelves -----");
			hp.searchBookShelves();
			bsp.mouseHover();
			logger.info("----- Setting Minimum and Maximum Prices -----");
			bsp.setMinimum("0");
			bsp.setMaximum("15000 ");
			logger.info("----- Selecting Open type BookShelves -----");
			bsp.selectType();
			bsp.selectOpen();
			logger.info("----- Printing top 3 BookShelves -----");
			bsp.printShelves();

			logger.info("-----TC_001_DisplayNameAndPrice Passed-----");
			Assert.assertTrue(true);

		} catch (Exception e) {

			logger.error("-----TC_001_DisplayNameAndPrice Failed-----");
			logger.debug("----- Debug Logs -----");
			Assert.fail();

		}
	}
}
