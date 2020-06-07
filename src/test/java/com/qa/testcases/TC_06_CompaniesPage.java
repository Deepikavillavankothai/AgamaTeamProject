package com.qa.testcases;

import java.awt.AWTException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.baseclass.Library;
import com.qa.pages.CompaniesPage;
import com.qa.pages.LoginPage;
import com.qa.seleniumutils.seleniumutils;

public class TC_06_CompaniesPage extends Library{
	CompaniesPage Cpage;
	LoginPage page;
	seleniumutils selutil;
	@BeforeMethod
	public void intiBrowser_Login()
	{
		logger.info("Launching browser for TC_06_Companiespage");
		browserSetUp();
		page=new LoginPage(driver);
		page.login(properties.getProperty("username"),properties.getProperty("password"));
			
	}
	@Test
	public void companies_TabClick() throws AWTException
	{
		
		Cpage=new CompaniesPage(driver);
		Cpage.companies_Tab();		
		logger.info("Add New Entry");
		
		Cpage.enterName(properties.getProperty("CompName"));
		Cpage.enterWebsite(properties.getProperty("website"));
		
		//Cpage.fetchWeb();
		Cpage.address(properties.getProperty("compStreet"),properties.getProperty("city"),properties.getProperty("state"),properties.getProperty("zip"));
		Cpage.selectCountry();
		
		Cpage.selectStatus(properties.getProperty("CStatus"));
		
		Cpage.image_upload(properties.getProperty("xlpath"));
		Cpage.save_Tab();
	}	
	
	@AfterMethod
	public void close()
	{
		selutil = new seleniumutils(driver);
		selutil.getScreenshot();
		tearDown();
	}


}
