package com.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.baseclass.Library;
import com.qa.pages.DocumentsPage;
import com.qa.pages.LoginPage;
import com.qa.seleniumutils.seleniumutils;

public class TC_08_DocumentsPage extends Library{
	LoginPage page;
	DocumentsPage Dpage;
	seleniumutils selutil;
	@BeforeMethod
	public void intiBrowser_Login()
	{
		logger.info("Launching browser for TC_08_Documentspage");
		browserSetUp();
		page=new LoginPage(driver);
		page.login(properties.getProperty("username"),properties.getProperty("password"));
		
		
	}
	@Test(priority=1)
	public void documents_Tab()
	{
		Dpage=new DocumentsPage(driver);
		Dpage.documents_Tab();
		Dpage.folder();
		Dpage.enter_Title(properties.getProperty("DocTitle"));
//		Dpage.enter_Tag(properties.getProperty("DocTags"));
		Dpage.enter_Description(properties.getProperty("Docdescription"));
		Dpage.upload_File(properties.getProperty("docFile"));
		Dpage.enter_Identifier(properties.getProperty("Identifier"));
		Dpage.hit_Save();
		
	}
	
	@Test(priority=2)
	public void NewFolder()
	
	{
		Dpage=new DocumentsPage(driver);
		Dpage.clickNewFolder(properties.getProperty("DocFoldername"));
	}
	@AfterMethod
	public void close() 
	{
		selutil = new seleniumutils(driver);
		selutil.getScreenshot();
		tearDown();
	}


}
