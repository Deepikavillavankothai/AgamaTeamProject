package com.qa.pages;

import java.awt.Desktop.Action;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ContactsPage {
	WebDriver driver;
	
	public ContactsPage(WebDriver wdriver) {
		driver = wdriver;
		PageFactory.initElements(driver, this);
	}

	@FindBy (xpath ="//span[contains(text(),'Contacts')]")
	WebElement contacts;
	
	@FindBy (xpath ="//span[contains(text(),'Home')]")
	WebElement home;
	
	@FindBy(xpath="//button[contains(text(),'New')]")
	WebElement addNew;
	
	@FindBy(xpath="//input[@name='first_name']")
	WebElement fname;
	
	@FindBy(xpath="//input[@name='last_name']")
	WebElement lname;
	
	
	
	@FindBy(xpath="//input[@name='address']")
	WebElement address;
	@FindBy(xpath="//input[@name='city']")
	WebElement city;	
	@FindBy(xpath="//input[@placeholder='State / County']")
	WebElement state;
	@FindBy(xpath="//div[@name='category']")
	WebElement category;
	@FindBy(xpath="//span[contains(text(),'Lead')]")
	WebElement selLead;
	@FindBy(xpath="//div[@name='status']")
	WebElement status;
	@FindBy(xpath="//div[@name='status']//div[3]")
	WebElement statusActive;
	
	@FindBy(xpath="//button[contains(text(),'Save')]")
	WebElement save;
	@FindBy(xpath="//tr[1]//td[8]//a[2]//button[1]//i[1]")
	WebElement editbtn;
	
	@FindBy(xpath="//input[@placeholder='Email address']")
	WebElement email;
	@FindBy(xpath="//input[@placeholder='Number']")
	WebElement phone;
	
	@FindBy(xpath="//tr[1]//td[8]//div[1]//button[1]//i[1]")
	WebElement delete;
	
	@FindBy(xpath="//button[text()='Delete']")
	WebElement cdel;
	
	public void clickContact() {
		contacts.click();
		
	}
	public void addcontactDetails(String firstname,String lastname,String Caddress,String City,String CState) {
		
		addNew.click();
		fname.sendKeys(firstname);
		lname.sendKeys(lastname);
		category();
		contactstatus();
		address.sendKeys(Caddress);
		city.sendKeys(City);
		state.sendKeys(CState);
		save.click();
		home.click();
		
	}
	public void category() {
		category.click();
		Actions act = new Actions(driver);
		act.moveToElement(selLead).click().build().perform();
	}
	
	public void contactstatus() {
		status.click();
		Actions act = new Actions(driver);
		act.moveToElement(statusActive).click().build().perform();
		
	}
	public void clickedit(String cemail,String cphone) {
		
		editbtn.click();
		email.sendKeys(cemail);
		phone.sendKeys(cphone);
		save.click();
		contacts.click();
		home.click();
	}
	public void delete(){
		delete.click();
		cdel.click();		
		home.click();
		contacts.click();
		
	}
	

}
