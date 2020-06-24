package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FreeCRM2Pages {
	
	WebDriver driver;
	
	public FreeCRM2Pages(WebDriver wdriver) {
		driver = wdriver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="//*[contains(@d,'M28 32s-4.')]")
	WebElement message;
	
	@FindBy (xpath="//*[contains(text(),'Apps')]")
	WebElement appbtn;
	
	@FindBy(xpath="//input[@placeholder='Search our articles']")
	WebElement search;
	
	public void clickMessenger() {
		message.click();
		driver.switchTo().frame("intercom-messenger-frame");
		search.sendKeys("testing");		
	}

	}
