package pageObjects;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomeAccessoriesPage extends BasePage
{
	public HomeAccessoriesPage(WebDriver driver)
	{
		super(driver);
	}
	
	//WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(25));
	
	@FindBy(className = "slick-list") WebElement slickList;
	@FindBy(id = "l1-image-div") List<WebElement> itemElements;
	
	public List<String> getHomeAccessoriesItems() 
	{
		wait.until(ExpectedConditions.visibilityOf(slickList));
	    List<String> itemNames = new ArrayList<>();
	    for (WebElement item : itemElements) 
	    {
	    	itemNames.add(item.getText());
	    }
	    return itemNames;
	 }
	
	
}
