package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.seleniumutils.seleniumutils;

public class FreeCRM {
WebDriver driver;
	
	public FreeCRM(WebDriver wdriver) {
		driver = wdriver;
		PageFactory.initElements(driver, this);
	}

	@FindBy (xpath ="//li[8]//a[1]//img[1]")
	WebElement AppTooltip;
	@FindBy (xpath ="//li[9]//a[1]//img[1]")
	WebElement AndroidTooltip;
	@FindBy (xpath ="//a[@title='free crm home']")
	WebElement logocrm;
	
	@FindBy(xpath="//span[contains(text(),'free')]")
	WebElement textcolor;
	
	@FindBy(xpath="//body/div/header/div/nav/div/div/div/ul/a[1]")
	WebElement textbackcolor;
	seleniumutils selutils;
	
	
	public String verifyAppToolTip() {
		selutils = new seleniumutils(driver);
		return selutils.verifyToolTip(AppTooltip);
		}
	public String verifyAndroidToolTip() {
		selutils = new seleniumutils(driver);
		return selutils.verifyToolTip(AndroidTooltip);
	}
	public boolean logoverfication() {
		return logocrm.isDisplayed();
		
	}
	public String colorofText() {		
		selutils = new seleniumutils(driver);
		 return selutils.verifyColorOfText(textcolor);			
	}
	
	public String backgroundcolorCheck() {
		selutils = new seleniumutils(driver);
		 return selutils.verifyBackgroundcolor(textbackcolor);
		
	}
	

}
