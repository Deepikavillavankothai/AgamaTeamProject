package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmailPage {
	
	WebDriver driver;
	
	public EmailPage(WebDriver wdriver) {
		driver = wdriver;
		PageFactory.initElements(driver, this);
	}

	@FindBy (xpath ="//div[@id='main-nav']//span[contains(text(),'Email')]")
	WebElement email;
	
	@FindBy(xpath="//button[contains(text(),'Compose')]")
	WebElement compose;
	
	@FindBy(xpath="//div[@name='to']//input")
	WebElement sendto;
	
	@FindBy(xpath="//input[@name='subject']")
	WebElement mailsubject;
	
	@FindBy(className="editor")
	WebElement mailcontent;
	
	@FindBy(xpath="//div[contains(text(),'Send')]")
	WebElement mailsend;
	
	
	
	public void clickemail() {
		email.click();
		
	}
	
	public void sendingmail() {
		compose.click();
		sendto.sendKeys("itsmanjudinesh@gmail.com");
		System.out.println("mail id written");
		mailsubject.sendKeys("Meeting");
		mailcontent.sendKeys("After noon 2pm meeting with client");
		mailsend.click();
	}

}
