package com.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.baseclass.Library;
import com.qa.pages.CallsPage;

import com.qa.pages.LoginPage;
import com.qa.seleniumutils.seleniumutils;

public class TC_09_CallsPage extends Library{
	LoginPage page;
	seleniumutils selutil;
	CallsPage calpge;
	@BeforeMethod
	public void init_browser() {
		logger.info("Launching browser for TC_09_CallsPage");
		browserSetUp();
		page =  new LoginPage(driver);	
		page.login(properties.getProperty("username"),properties.getProperty("password"));
	}
	@Test
	public void callregister() {
		calpge = new CallsPage(driver);
		calpge.clickCallsTab();
		calpge.setcallTime();
		calpge.addcalldetails("2 hour");
		
	}
	@AfterMethod
	public void close() 
	{
		selutil = new seleniumutils(driver);
		selutil.getScreenshot();
		logger.info("Closing browser for TC_09_CallsPage");
		tearDown();
	}
}
