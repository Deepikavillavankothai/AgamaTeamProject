package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.KeyDownAction;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalendarPage {
	WebDriver driver;
	
	public CalendarPage(WebDriver wdriver) {
		driver = wdriver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[contains(text(),'Calendar')]")
	WebElement calendar;
	
	@FindBy(xpath="//button[contains(text(),'New')]")
	WebElement NewBtn;
	@FindBy(xpath="//input[@name='title']")
	WebElement title;
	@FindBy(xpath="//i[@class='dropdown icon']")
	WebElement calen;
	
	@FindBy(xpath="//textarea[@name='location']")
	WebElement location;
	
	@FindBy(xpath="//button[contains(text(),'Save')]")
	WebElement Save;
	
	public void clickCalendar() {
		calendar.click();
	}
	public void ClickNewButton() throws InterruptedException {
		NewBtn.click();
		
		driver.navigate().refresh();
		Thread.sleep(2000);
		driver.navigate().refresh();
		
	}
	public void selcalen(String name) {
		calen.click();
		Actions act= new Actions(driver);
		act.sendKeys(name).perform();
		act.sendKeys(Keys.ENTER).perform();
		
	}
	public void adddetails(String ctitle,String name,String description) {
		title.sendKeys(ctitle);
		selcalen(name);
		location.sendKeys(description);
		Save.click();
		
		
	}
	

}
