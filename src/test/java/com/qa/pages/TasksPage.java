package com.qa.pages;

import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TasksPage {
	WebDriver driver;
	
	public TasksPage(WebDriver wdriver) {
		driver = wdriver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[contains(text(),'Tasks')]")
	WebElement tasks;
	@FindBy(xpath="//button[contains(text(),'New')]")
	WebElement newEntry;

	@FindBy(xpath="//*[@name='title']")
	WebElement title;

	@FindBy(xpath="//div[@name='type']")
	WebElement type;
			
	@FindBy(xpath="//span[contains(text(),'General Support')]")
	WebElement picktype;
	
	@FindBy(xpath="//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/form/div[3]/div[1]/div/div[1]/div/input")
	WebElement duedate;
	
	@FindBy(xpath="//div[contains(text(),'18')]")
	WebElement seldate;
	
	@FindBy(xpath="//li[contains(text(),'17:00')]")
	WebElement seltime;		
	
	@FindBy(xpath="//div[@name='status']")
	WebElement status;
@FindBy(xpath="//span[contains(text(),'Enquiring')]")
WebElement selstatus;

@FindBy(xpath="//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/form/div[5]/div[1]/div/div[1]/div/input")
WebElement closedate;
@FindBy(xpath="//div[contains(text(),'25')]")
WebElement selclosedate;
@FindBy(xpath="//li[contains(text(),'18:30')]")
WebElement selclosetime;

@FindBy(xpath="//*[@class='save icon']")
WebElement save;
@FindBy(xpath="//div[@class='ui basic button floating item dropdown']")
WebElement settings;

@FindBy(xpath="//span[contains(text(),'Log Out')]")
WebElement logoff;

public void clickTasks()
{
	tasks.click();
	
	
}
public void clickNewTask()
{
	newEntry.click();
	}

public void enter_Title(String Title)
{
	title.sendKeys(Title);
	
}

public void clickType(String pick_type)
{
	type.click();
	Actions action =new Actions(driver);
	action.moveToElement(picktype).click().build().perform();
	
	
}

public void adddetails() {
	status.click();
	Actions act=new Actions(driver);
	act.moveToElement(selstatus).click().build().perform();
	
	duedate.click();
	seldate.click();
	seltime.click();
}
public void selclosedate() {
	closedate.click();
	selclosedate.click();
	selclosetime.click();
}

public void save_Icon() 
{
	save.click();
}
public void logoff() 
{
	settings.click();	
	logoff.click();
}



}
