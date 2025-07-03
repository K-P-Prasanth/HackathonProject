package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(id="moe-dontallow_button") 
	WebElement popup;
	
	@FindBy(xpath="//input[@id='js-site-search-input' and @type='search']")
	WebElement searchBar;
	
	Actions act = new Actions(driver);
	
	public void closePopUp() {
		popup.click();	
	}
	
	public void searchBookShelves() {
		searchBar.sendKeys("book shelves");
		act.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
	}
}
