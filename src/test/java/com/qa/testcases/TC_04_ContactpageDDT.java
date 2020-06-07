package com.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.baseclass.Library;
import com.qa.pages.ContactsPage;
import com.qa.pages.LoginPage;
import com.qa.seleniumutils.seleniumutils;
import com.qa.xlutils.xlutils;

public class TC_04_ContactpageDDT extends Library {
	LoginPage page;
	seleniumutils selutil;
	ContactsPage ctpge;
	@BeforeMethod
	public void init_browser() {
		logger.info("Launching browser for TC_04_ContactPage");
		browserSetUp();
		page =  new LoginPage(driver);	
		page.login(properties.getProperty("username"),properties.getProperty("password"));
	}
	@Test(dataProvider="contacts",priority=1)
	public void AddNewContacts(String firstname,String lastname,String Caddress,String City,String CState) {
		ctpge = new ContactsPage(driver);
		selutil = new seleniumutils(driver);
		ctpge.clickContact();
		ctpge.addcontactDetails(firstname,lastname,Caddress, City,CState);
		selutil.getScreenshot();
		ctpge.clickContact();
		
	}
	@Test(priority=2)
	public void editContacts() {
		ctpge = new ContactsPage(driver);
		selutil = new seleniumutils(driver);
		ctpge.clickContact();
		ctpge.clickedit(properties.getProperty("Cemail"),properties.getProperty("CPhone"));
		ctpge.clickContact();
		}
	@Test(priority=3)
	public void deleteContacts() {
		ctpge = new ContactsPage(driver);
		selutil = new seleniumutils(driver);
		ctpge.clickContact();
		ctpge.delete();
		}
	
	
	@DataProvider(name="contacts")
	  public  Object[][] passData() throws IOException{
		xlutils util =  new xlutils();
		
		  int rowcount = util.getRowCount(properties.getProperty("xlpath"),"Contacts");
		  int CellCnt = util.getcellCount(properties.getProperty("xlpath"),"Contacts",1);
		  
		  Object[][] data = new Object[rowcount][CellCnt];
		  for(int i=1;i<=rowcount;i++) 
			{				  
			  for(int j=0;j<CellCnt;j++) {
				  data[i-1][j] =util.getCelldata(properties.getProperty("xlpath"), "Contacts", i, j);
				  
			 }
			}
	 
		  return data;
		  }
	
	@AfterMethod
	public void closebrowser() {
		selutil.getScreenshot();
		tearDown();
	}
	

}
