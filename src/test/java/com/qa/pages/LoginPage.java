package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver wdriver) {
		driver = wdriver;
		PageFactory.initElements(driver, this);
	}

	@FindBy (xpath ="//span[contains(text(),'Log In')]")
	WebElement login;
	
	
	@FindBy (xpath ="//input[@name='email']")
	WebElement email;
	
	@FindBy (xpath ="//input[@name='password']")
	WebElement passwd;
	
	@FindBy (xpath ="//div[contains(text(),'Login')]")
	WebElement submit;
	
	@FindBy(xpath ="//span[contains(text(),'Home')]")
	WebElement home;
	
	@FindBy(xpath="//i[@class='settings icon']")
	WebElement settings;
	
	@FindBy(xpath="//span[contains(text(),'Log Out')]")
	WebElement logout;
	
	public void login(String user,String pass) {
		login.click();
		email.sendKeys(user);
		passwd.sendKeys(pass);
		submit.click();
	}
	public void clickHome() {
		home.click();
	}
	public void logout() {
		settings.click();
		logout.click();
	}
	
	
	
}
