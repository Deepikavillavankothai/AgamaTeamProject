package com.qa.testcases;



import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.baseclass.Library;
import com.qa.pages.LoginPage;
import com.qa.seleniumutils.seleniumutils;

public class TC_01_Loginpage extends Library{
	LoginPage page;
	seleniumutils selutil;
	
	@BeforeMethod
	public void init_browser() {
		logger.info("Launching browser for TC_01_loginpage");
		browserSetUp();
	}
	
	@Test(priority=1)
	public void FreeCrmLogin() {
		logger.info("Entering userid and password");
		page =  new LoginPage(driver);		
		page.login(properties.getProperty("username"),properties.getProperty("password"));
		selutil = new seleniumutils(driver);
		
		String PageTitle = selutil.getpageTitle();
		Assert.assertEquals(PageTitle, "Cogmento CRM");
		page.clickHome();
		selutil.getScreenshot();
		page.logout();
		
	}
	
	@AfterMethod
	public void closebrowser() {
		logger.info("Closing browser for TC_01_loginPage");
		tearDown();
	}
	
	
}
