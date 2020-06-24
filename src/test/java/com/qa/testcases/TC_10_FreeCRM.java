package com.qa.testcases;



import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.baseclass.Library;
import com.qa.pages.FreeCRM;
import com.qa.seleniumutils.seleniumutils;

public class TC_10_FreeCRM extends Library{
	
	seleniumutils selutils;
	FreeCRM free;
	@BeforeMethod
	public void init_browser() {
		logger.info("Launching browser for TC_10_CRM");
		browserSetUp();
	}
	@Test(priority=1)
	public void checkpageTitle() {
		selutils = new seleniumutils(driver);
		String text = selutils.getpageTitle();
		Assert.assertEquals(text, "Free CRM #1 cloud software for any business large or small");				
	}
	@Test(priority=2)
	public void VerifyTooltip() {
		free = new FreeCRM(driver);
		String text = free.verifyAppToolTip();
		Assert.assertEquals(text, "free crm app for itunes");
		String androidtip = free.verifyAndroidToolTip();
		Assert.assertEquals(androidtip, "app for freecrm android");
		}
	@Test(priority=3)
	public void logoTest() {
		free = new FreeCRM(driver);
		boolean flag = free.logoverfication();
		Assert.assertTrue(flag);
		}
	@Test(priority=4)
	public void verifyTextColor() {
		free = new FreeCRM(driver);
		String textcolor = free.colorofText();
		Assert.assertEquals(textcolor, "#43ca83");
		}
	@Test(priority=5)
	public void verifyBackgroundColor() {
		free = new FreeCRM(driver);
		 String backcolor= free.backgroundcolorCheck();
		Assert.assertEquals(backcolor, "#ea6c56");
		}	
	
	@AfterMethod
	public void closebrowser() {
		selutils = new seleniumutils(driver);
		selutils.getScreenshot();
		logger.info("Closing browser for TC_10_CRM");
		tearDown();
	}

}
