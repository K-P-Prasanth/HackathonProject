package pageObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.FluentWait;

import utilities.AddingDataToExcel;


public class BookShelvesPage extends BasePage
{
	public BookShelvesPage(WebDriver driver)
	{
		super(driver);
	}
	
	//JavascriptExecutor js = (JavascriptExecutor) driver;
	
	@FindBy(xpath="//input[@id='js-site-search-input']")
	WebElement hover;
	
	@FindBy(xpath="//input[@aria-label='minimum-input']")
	WebElement minimum;
	
	@FindBy(xpath="//input[@aria-label='maximum-input']")
	WebElement maximum;
	
	@FindBy(xpath="//button[@aria-label='right-arrow-icon']")
	WebElement setMinMax;
	
	@FindBy(xpath="//div[@id='product-46']/div")
	WebElement typeEle;
	
	@FindBy(xpath="//div//h6[text()='Type']/following-sibling::div/button")
	WebElement typeClick;
	
	@FindBy(xpath="//h6//div//span[text()='Open Book Shelves']/ancestor::h6/preceding-sibling::span/span/input")
	WebElement open;
	
	@FindBy(xpath="//div[@class='MuiGrid-root jss3537 MuiGrid-item MuiGrid-grid-xs-6 MuiGrid-grid-sm-4']")
	List<WebElement> shelves; 
	
	
	
	public void mouseHover() 
	{
		fluentWait=new FluentWait<>(driver).
				withTimeout(Duration.ofSeconds(10)).
				pollingEvery(Duration.ofSeconds(1)).
				ignoring(Exception.class);
		act.moveToElement(hover).perform();
	}
	public void setMinimum(String val)
	{
		minimum.clear();
		minimum.sendKeys(val);
	}
	
	
	
	public void setMaximum(String val) throws InterruptedException
	{
		maximum.clear();
		maximum.sendKeys(val);
		fluentWait=new FluentWait<>(driver).
				withTimeout(Duration.ofSeconds(10)).
				pollingEvery(Duration.ofSeconds(1)).
				ignoring(Exception.class);
		setMinMax.click();
	}
	
	public void selectType() throws InterruptedException
	{
		js.executeScript("arguments[0].scrollIntoView();",typeEle);
		fluentWait=new FluentWait<>(driver).
				withTimeout(Duration.ofSeconds(10)).
				pollingEvery(Duration.ofSeconds(1)).
				ignoring(Exception.class);
		typeClick.click();
	}
	
	public void selectOpen() throws InterruptedException
	{
		fluentWait=new FluentWait<>(driver).
				withTimeout(Duration.ofSeconds(10)).
				pollingEvery(Duration.ofSeconds(1)).
				ignoring(Exception.class);
		open.click();
	}
	
	public void printShelves() throws IOException
	{
		for(int i=1;i<4;i++)
		{
			String half_xpath="//div[@id='product-"+i+"']";
			String Title_full_xpath=half_xpath+"/div[1]/div[3]";
			WebElement Title=driver.findElement(By.xpath(Title_full_xpath));
			
			String Price_full_xpath=half_xpath+"/div[1]/div[2]//div[2]";
			WebElement Price=driver.findElement(By.xpath(Price_full_xpath));
			String title=Title.getText();
			System.out.print(title+"   ");
			AddingDataToExcel.writeToExcel(i,0,title);
			String price=Price.getText();
			System.out.println(price);
			AddingDataToExcel.writeToExcel(i,1,price);
		}
	}
	
}
