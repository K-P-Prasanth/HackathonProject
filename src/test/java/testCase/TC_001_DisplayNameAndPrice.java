package testCase;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_DisplayNameAndPrice extends BaseClass{
	
	@Test
	public void metho() {
		HomePage hp = new HomePage(driver);
		hp.closePopUp();
		hp.searchBookShelves();
		System.out.println(driver.getCurrentUrl());
	}
}
