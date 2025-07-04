package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	JavascriptExecutor js=(JavascriptExecutor) driver;
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(25));
	
	@FindBy(id="moe-dontallow_button") 
	WebElement popup;
	
	@FindBy(xpath="//input[@id='js-site-search-input' and @type='search']")
	WebElement searchBar;
	
	@FindBy(xpath ="//div[@id='footer-menu-wrapper']//a[text()='Home Accessories']")
	//@FindBy(xpath = "//a[contains(@href, 'decor-homeaccessories')]")
	WebElement homeacces;
	
	Actions act = new Actions(driver);
	
	public void closePopUp() {
		popup.click();	
	}
	
	public void searchBookShelves() {
		searchBar.sendKeys("book shelves");
		act.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
	}
	
	public void Homeaccesories() 
    {

        wait.until(ExpectedConditions.visibilityOf(homeacces));
        js.executeScript("arguments[0].scrollIntoView(true);", homeacces);
        js.executeScript("arguments[0].click();", homeacces);
    }
}
