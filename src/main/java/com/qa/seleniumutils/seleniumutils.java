package com.qa.seleniumutils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

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
	
	public String verifyBackgroundcolor(WebElement element) {
		String color = element.getCssValue("background-color");
		System.out.println(color);
		String backColorhex = Color.fromString(color).asHex();
		System.out.println(backColorhex);
		return backColorhex;
		
	}
	public String verifyColorOfText(WebElement element) {		
		String color = element.getCssValue("color");
		System.out.println(color);
		
		String color_hex[];  
		 color_hex = color.replace("rgba(", "").split(",");       
		 String actual_hex = String.format("#%02x%02x%02x",
							 Integer.parseInt(color_hex[0].trim()),
							 Integer.parseInt(color_hex[1].trim()),
							 Integer.parseInt(color_hex[2].trim()));		 
		 System.out.println(actual_hex);
		
		return actual_hex;		
	}
	
	public String verifyToolTip(WebElement element) {
		String actualtooltip = element.getAttribute("title");
		System.out.println(actualtooltip);
		return actualtooltip;
	}
	
	public void pageScrollDown(String x,String y) {
		String variable = "window.scrollBy(x,y)";
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript(variable);
		
	}
	
	
	

}
