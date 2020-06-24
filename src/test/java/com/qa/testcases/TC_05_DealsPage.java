package com.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.baseclass.Library;
import com.qa.pages.DealsPage;
import com.qa.pages.LoginPage;
import com.qa.seleniumutils.seleniumutils;

public class TC_05_DealsPage extends Library{
	DealsPage deal;
	LoginPage page;
	seleniumutils selutil;
	
	@BeforeMethod()
	public void startup() {
		logger.info("Launching browser for TC_05_DealsPage");
		browserSetUp();
		page =  new LoginPage(driver);		
		page.login(properties.getProperty("username"),properties.getProperty("password"));
		}
	
		@Test
		public void Dealspage() {
			deal=new DealsPage(driver);
			deal.dealsClick();
			deal.addTitle(properties.getProperty("DealsTitle"));
			deal.addCompAmount(properties.getProperty("company"),properties.getProperty("amount"));			
			deal.cdate();
			deal.status();
			deal.stage();
			
	}
			
	@AfterMethod()
	public void close(){
		logger.info("Closing browser for TC_05_DealsPage");
		selutil = new seleniumutils(driver);
		selutil.getScreenshot();
		deal.logout();
		tearDown();
	}
}
