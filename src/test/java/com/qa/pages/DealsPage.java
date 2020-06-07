package com.qa.pages;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DealsPage {
	
	@FindBy(xpath="//span[contains(text(),'Deals')]")
	WebElement Deals;
	@FindBy(xpath="//button[contains(text(),'New')]")
	WebElement New;
	@FindBy(xpath="//input[@name='title']")
	WebElement Title;
	@FindBy(xpath="//div[@name='company']//input")
	WebElement Company;
	@FindBy(xpath="//input[@name='amount']")
	WebElement Amount;
	
	@FindBy(xpath="//div[@name='status']")
	WebElement Status;
	@FindBy(xpath="//span[contains(text(),'Active')]")
	WebElement StatusNew;
	
	@FindBy(xpath="//div[@name='stage']")
	WebElement dealstage;
	@FindBy(xpath="//span[contains(text(),'Qualify')]")
	WebElement dealsQualify;
	
	
	@FindBy(xpath="//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/form/div[4]/div[1]/div/div[1]/div/input")
	WebElement cdate;
	@FindBy(xpath="//div[contains(text(),'11')]")
	WebElement Date;
	@FindBy(xpath="//li[contains(text(),'16:30')]")
	WebElement Time;
	@FindBy(xpath="//button[contains(text(),'Save')]")
	WebElement save;
	@FindBy(xpath="//span[contains(text(),'Home')]")
	WebElement home;
	
	@FindBy(xpath="//i[@class='settings icon']")
	WebElement setting;
	@FindBy(xpath="//span[contains(text(),'Log Out')]")
	WebElement Logout;
	
	 WebDriver driver;

	public DealsPage(WebDriver rdriver) {
		this.driver=rdriver;
		PageFactory.initElements(driver,this);
	}
	
	
	public void dealsClick() {
		Deals.click();
		New.click();
	}
	public void addTitle(String name) {
		Title.sendKeys(name);
		
	}
	public void addCompAmount(String com,String amt) {
		Company.sendKeys(com);
		Amount.sendKeys(amt);
	}
	public void status() {
     Status.click();
     StatusNew.click();
	}
	public void cdate() {
		cdate.click();
		Date.click();
		Time.click();
	}
	public void stage() {
		dealstage.click();
		Actions act = new Actions(driver);
		act.moveToElement(dealsQualify).click().build().perform();
		save.click();
		home.click();
		Deals.click();
		home.click();
		Deals.click();
		}
	public void logout() {
		setting.click();
		Logout.click();
	}

}