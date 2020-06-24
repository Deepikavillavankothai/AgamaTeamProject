package com.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.baseclass.Library;
import com.qa.pages.LoginPage;
import com.qa.pages.TasksPage;
import com.qa.seleniumutils.seleniumutils;

public class TC_07_TasksPage extends Library{
	TasksPage Tpage;
	LoginPage page;
	seleniumutils selutil;
	@BeforeMethod
	public void intiBrowser()
	{
		logger.info("Launching browser for TC_07_Taskspage");
		browserSetUp();
		page=new LoginPage(driver);
		page.login(properties.getProperty("username"),properties.getProperty("password"));	
		
	}
	@Test
	public void task_Tab()
	{
		Tpage=new TasksPage(driver);
		selutil = new seleniumutils(driver);
		Tpage.clickTasks();
		Tpage.clickNewTask();
		Tpage.enter_Title(properties.getProperty("TaskTitle"));
		Tpage.clickType(properties.getProperty("TaskType"));
		Tpage.adddetails();
		Tpage.selclosedate();
		Tpage.save_Icon();
		Tpage.clickTasks();
		Tpage.clickTasks();
	}
	@AfterMethod
	public void close()
	{
		selutil.getScreenshot();
		logger.info("Closing browser for TC_07_Taskspage");
		tearDown();
	}

}
