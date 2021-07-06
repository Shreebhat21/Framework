package com.learnautomation.utility;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class HelperClass {
	
	
	public static String captureScreenshot(WebDriver driver)
	{
		String screenshotPath=System.getProperty("user.dir")+"./Screenshots/Login_"+getCurrentDateTime()+".png"; 
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(src, new File(screenshotPath));
			System.out.println("Screenshot taken");
		}
		catch(Exception e)
		{
			System.out.println("Unable to take screenshot"+e.getMessage());
		}
		return screenshotPath;
	}
	
	public static String getCurrentDateTime()
	{
		DateFormat customFormat=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		
		Date currentDate=new Date();
		return customFormat.format(currentDate);
	}
}
