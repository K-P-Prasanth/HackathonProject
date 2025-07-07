package testCase;

import java.io.IOException;

import org.testng.annotations.Test;
import pageObjects.HomePage;
import testBase.BaseClass;
import pageObjects.BookShelvesPage;

public class TC_001_DisplayNameAndPrice extends BaseClass{
	
	@Test
	public void method() throws InterruptedException, IOException 
	{
		HomePage hp = new HomePage(driver);
		BookShelvesPage bsp=new BookShelvesPage(driver);
		hp.closePopUp();
		hp.searchBookShelves();
		System.out.println(driver.getCurrentUrl());
		bsp.setMinimum("0");
		bsp.setMaximum("15000");
		bsp.selectType();
		bsp.selectOpen();
		bsp.printShelves();
	}
}
