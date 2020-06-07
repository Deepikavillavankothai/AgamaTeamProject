package com.qa.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.baseclass.Library;
import com.qa.pages.EmailPage;
import com.qa.pages.LoginPage;
import com.qa.seleniumutils.seleniumutils;

public class TC_03_EmailPage extends Library {
	LoginPage page;
	seleniumutils selutil;
	EmailPage epage;
	
	@BeforeMethod
	public void init_browser() {
		logger.info("Launching browser for TC_03_EmailPage");
		browserSetUp();
		page =  new LoginPage(driver);	
		page.login(properties.getProperty("username"),properties.getProperty("password"));
	}
	@Test
	public void sendingEmail() {
		epage = new EmailPage(driver);
		epage.clickemail();
		epage.sendingmail();
	}

}
