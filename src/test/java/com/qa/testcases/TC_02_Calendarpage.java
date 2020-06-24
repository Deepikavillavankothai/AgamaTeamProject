package com.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.baseclass.Library;
import com.qa.pages.CalendarPage;
import com.qa.pages.LoginPage;
import com.qa.seleniumutils.seleniumutils;

public class TC_02_Calendarpage extends Library{
	LoginPage page;
	seleniumutils selutil;
	CalendarPage calpge;
	
	@BeforeMethod
	public void init_browser() {
		logger.info("Launching browser for TC_02_CalendarPage");
		browserSetUp();
		page =  new LoginPage(driver);	
		page.login(properties.getProperty("username"),properties.getProperty("password"));
	}
	@Test
	public void addNewCalenderInvite() throws InterruptedException {
		calpge = new CalendarPage(driver);
		selutil = new seleniumutils(driver);
		calpge.clickCalendar();
		calpge.ClickNewButton();
		calpge.adddetails(properties.getProperty("title"),properties.getProperty("name"),properties.getProperty("description"));
		selutil.getScreenshot();
		calpge.clickCalendar();
	}
	
	@AfterMethod
	public void closebrowser() {
		logger.info("Closing browser for TC_02_CalendarPage");
		selutil.getScreenshot();
		tearDown();
	}

}
