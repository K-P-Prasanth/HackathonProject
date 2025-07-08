package testCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import testBase.BaseClass;
import pageObjects.BookShelvesPage;

public class TC_001_DisplayNameAndPrice extends BaseClass{
	
	@Test
	public void method() throws InterruptedException, IOException 
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
			logger.info("----- Getting Current URL -----");
			System.out.println(driver.getCurrentUrl());
			logger.info("----- Setting Minimum and Maximum Prices -----");
			bsp.setMinimum("0");
			bsp.setMaximum("15000");
			logger.info("----- Selecting Open type BookShelves -----");
			bsp.selectType();
			bsp.selectOpen();
			logger.info("----- Printing top 3 BookShelves -----");
			bsp.printShelves();

			logger.error("-----TC_001_DisplayNameAndPrice Passed-----");
			Assert.assertTrue(true);

		} catch (Exception e) {

			logger.error("-----TC_001_DisplayNameAndPrice Failed-----");
			logger.debug("----- Debug Logs -----");
			Assert.fail();

		}
	}
}
