package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage
{
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	//Actions act = new Actions(driver);
	
	//JavascriptExecutor js=(JavascriptExecutor) driver;
	//WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(25));
	
	@FindBy(id="moe-dontallow_button") 
	WebElement popup;
	
	@FindBy(xpath="//input[@id='js-site-search-input' and @type='search']")
	WebElement searchBar;

    @FindBy(xpath = "//a[text()='Online Gift Card']")
    WebElement onlineGiftCardLink;
	
	@FindBy(xpath ="//div[@id='footer-menu-wrapper']//a[text()='Home Accessories']")
	//@FindBy(xpath = "//a[contains(@href, 'decor-homeaccessories')]")
	WebElement homeacces;
	
	
	public void closePopUp() {
		popup.click();	
	}
	
	public void searchBookShelves() 
	{
		searchBar.sendKeys("book shelves");
		act.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
	}
	
	public void Homeaccesories() 
    {

        wait.until(ExpectedConditions.visibilityOf(homeacces));
        js.executeScript("arguments[0].scrollIntoView(true);", homeacces);
        js.executeScript("arguments[0].click();", homeacces);
	}
	public void clickOnlineGiftCard() {
        onlineGiftCardLink.click();
    }
}
