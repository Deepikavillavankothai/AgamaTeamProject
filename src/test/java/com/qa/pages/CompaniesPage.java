package com.qa.pages;

import java.awt.AWTException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CompaniesPage {
	WebDriver driver;
	public CompaniesPage(WebDriver Cdriver) 
	{
		this.driver=Cdriver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//span[contains(text(),'Companies')]")
    WebElement companies;
	
	@FindBy(xpath="//button[contains(text(),'New')]")
	WebElement newEntry;
	
	@FindBy(xpath="//input[@autocomplete='new-password' and @name='name']")
	//@FindBy(xpath="//*[@class='ui label label right corner']")
	WebElement name;
	
	@FindBy(xpath="//button[contains(text(),'Save')]")
	WebElement save;
	
	@FindBy(xpath="//input[@name='url']")
	WebElement website;
	
	@FindBy(xpath="//button[contains(text(),'Fetch')]")
	WebElement fetch;
	
	@FindBy(xpath="//input[ @placeholder='Street Address']")
	WebElement streetaddress;
	
	@FindBy(name="city")
	WebElement cityaddress;
	
	@FindBy(name="state")
	WebElement stateaddress;
	
	@FindBy(name="zip")
	WebElement zipcode;	
	
	//@FindBy(xpath="//div[ @name='country']")////div[@name='Country' and @class='ui fluid search selection dropdown']
	@FindBy(xpath="//div[@name='country']")
	WebElement country;
	
	@FindBy(xpath="//div[@name='country']//div//div//span[contains(text(),'United States')]")
	WebElement selUS;
		
	@FindBy(xpath="//div[@name='status']")
	WebElement status;
	@FindBy(xpath="//div[@name='status']//div[3]")
	WebElement statusActive;
	@FindBy(xpath="//body//div[@name='status']//div//div[2]")
	WebElement statusNew;
	@FindBy(xpath="//input[@name='image']")
	WebElement image;
		
	public void companies_Tab()  
	{
		companies.click();
//		WebDriverWait wait = new WebDriverWait(driver,30);
//	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@href='/companies/new']")));
		newEntry.click();

	}
	public void enterName(String Name)
	{
//		driver.navigate().refresh();
//		driver.navigate().refresh();
		name.sendKeys(Name);		
	}
		
	public void enterWebsite(String Website)
	{
		website.sendKeys(Website);
	}
	public void fetchWeb()
	{		
		fetch.click();
    }	
	public void address(String street,String city,String state,String zip) 
	{
		streetaddress.sendKeys(street);
		cityaddress.sendKeys(city);
		stateaddress.sendKeys(state);
		zipcode.sendKeys(zip);
	}
	public void selectCountry() throws AWTException
	{
		country.click();	  
		Actions act = new Actions(driver);
		act.moveToElement(selUS).click().build().perform();
	}
	
	public void selectStatus(String cstatus) 
	{
		status.click();
		Actions action =new Actions(driver);
		if (cstatus.equalsIgnoreCase("Active"))	{	
		action.moveToElement(statusActive).click().build().perform();
		}else if(cstatus.equalsIgnoreCase("New")) {
			action.moveToElement(statusNew).click().build().perform();
		}
	}
		
	public void image_upload(String path)
	{
		image.sendKeys(path);
	}
		
	public void save_Tab()
	{
		save.click();
		companies.click();
		companies.click();

	}
}
