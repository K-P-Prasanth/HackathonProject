package pageObjects;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import utilities.AddingDataToExcel;
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
	@FindBy(xpath="//div[contains(@class, 'slick-slide slick-active')]") List<WebElement> itemElements;
	List<String> itemNames = new ArrayList<>();
	
	public void getHomeAccessoriesItems()
	{
		wait.until(ExpectedConditions.visibilityOf(slickList));
	    for (WebElement item: itemElements) 
	    {
	    	itemNames.add(item.getText());
	    }
	 }
	
	public void printHomeAccessoriesItems() throws IOException
	{
		System.out.println("Home Accessories Sub-Menu Items:");
		for(int i=0;i<itemNames.size();i++)
		{
			System.out.println(itemNames.get(i));
			AddingDataToExcel.writeToExcel(1,i+1,0,itemNames.get(i));
		}
	}
	
}
