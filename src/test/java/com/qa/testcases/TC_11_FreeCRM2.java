package com.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.baseclass.Library;
import com.qa.pages.FreeCRM2Pages;
import com.qa.seleniumutils.seleniumutils;

public class TC_11_FreeCRM2 extends Library {
	seleniumutils selutils;
	FreeCRM2Pages free;
	@BeforeMethod
	public void init_browser() {
		logger.info("Launching browser for TC_11_CRM");
		browserSetUp();
	}
	@Test(priority=1)
	public void sendMessage() {
		free =  new FreeCRM2Pages(driver);
		free.clickMessenger();
	}
	
	
		
	@AfterMethod
	public void closebrowser() {
		selutils = new seleniumutils(driver);
		selutils.getScreenshot();
		logger.info("Closing browser for TC_11_CRM");
		tearDown();
	}
}
