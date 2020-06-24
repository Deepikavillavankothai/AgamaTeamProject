package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CallsPage {
	 WebDriver driver;

	public CallsPage(WebDriver rdriver) {
		this.driver=rdriver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//span[contains(text(),'Calls')]")
	WebElement calls;
	@FindBy(xpath="//button[contains(text(),'New')]")
	WebElement newbtn;
	@FindBy(xpath="//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/form/div[1]/div[1]/div/div[1]/div/input")
	WebElement calltime;
	@FindBy(xpath="//div[@class='react-datepicker__day react-datepicker__day--017']")
	WebElement calldate;
	@FindBy(xpath="//li[contains(text(),'15:45')]")
	WebElement callpicktime;
	@FindBy(xpath="//div[@name='type']")
	WebElement type;
	@FindBy(xpath="//span[contains(text(),'SKYPE')]")
	WebElement skype;
	
	@FindBy(xpath="//input[@name='duration']")
	WebElement duration;
	@FindBy(xpath="//div[@class='ui active visible fluid selection dropdown']")
	WebElement assginedto;
	@FindBy(xpath="//span[@class='text'][contains(text(),'Manjula S')]")
	WebElement assginedname;
	@FindBy(xpath="//button[@class='ui linkedin button']")
	WebElement savebtn;
	public void clickCallsTab() {
		calls.click();
		newbtn.click();
		driver.navigate().refresh();
		driver.navigate().refresh();
		
	}
	public void setcallTime() {
		calltime.click();
		calldate.click();
		callpicktime.click();
	}
	public void addcalldetails(String callduration) {
		type.click();
		Actions act = new Actions(driver);
		act.moveToElement(skype).click().build().perform();
		assginedto.click();
		//assginedname.click();
		duration.sendKeys(callduration);
		savebtn.click();
		calls.click();
	}

}
