package testCase;

import java.util.List;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;
import pageObjects.HomeAccessoriesPage;

public class TC_002_RetriveSubMenuItems extends BaseClass
{
	@Test
	public void method()
	{
		HomePage hp=new HomePage(driver);
		HomeAccessoriesPage hap=new HomeAccessoriesPage(driver);
		
		hp.closePopUp();	
		hp.Homeaccesories();
		hap.getHomeAccessoriesItems();
		
		List<String> items = hap.getHomeAccessoriesItems();
        System.out.println("Home Accessories Sub-Menu Items:");
        for (String name : items) 
        System.out.println(name);
	}
	
}
