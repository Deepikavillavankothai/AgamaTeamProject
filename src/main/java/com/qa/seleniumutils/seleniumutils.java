package com.qa.seleniumutils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class seleniumutils {
	WebDriver driver;
	
	public seleniumutils(WebDriver driver) {
		this.driver = driver;
	}

	public void getScreenshot() {
		
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshots/FreeCrm" + System.currentTimeMillis() + ".png";
		System.out.println(path);
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			System.out.println("Capture Failed " + e.getMessage());
		}
	}
	
	public String getpageTitle() {
		String path = driver.getTitle();
		return path;
		
	}
	

}
