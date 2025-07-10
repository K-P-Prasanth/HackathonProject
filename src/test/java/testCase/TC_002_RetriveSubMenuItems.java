package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;
import pageObjects.HomeAccessoriesPage;

public class TC_002_RetriveSubMenuItems extends BaseClass
{
	@Test(priority=2)
	public void RetriveSubMenuItems()
	{
		try {
			logger.info("-----Starting TC_002_RetriveSubMenuItems-----");
			HomePage hp = new HomePage(driver);
			HomeAccessoriesPage hap = new HomeAccessoriesPage(driver);
			logger.info("----- Closing PopUp -----");
			hp.closePopUp();
			logger.info("----- Clicking Home Accessories -----");
			hp.Homeaccesories();
			logger.info("----- Listing Items From Home Accessories Section -----");
			hap.getHomeAccessoriesItems();
			logger.info("----- Printing Items From Home Accessories Section -----");
			hap.printHomeAccessoriesItems();
			logger.info("-----TC_002_RetriveSubMenuItems Passed-----");
			Assert.assertTrue(true);

		} catch (Exception e) {
			logger.error("-----TC_002_RetriveSubMenuItems Failed-----");
			logger.debug("----- Debug Logs -----");
			Assert.fail();
		}
	}
		

}
