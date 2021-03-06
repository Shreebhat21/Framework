package com.learnautomaton.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.learnautomation.utility.BrowserFactory;
import com.learnautomation.utility.ConfigDataProvider;
import com.learnautomation.utility.ExcelDataProvider;
import com.learnautomation.utility.HelperClass;

public class BaseClass {
	
	 public WebDriver driver;
	 public ExcelDataProvider excel;
	 public ConfigDataProvider config;
	 public ExtentReports report;
	 public ExtentTest logger;
	 
	 @BeforeSuite
	 public void setUpSuite()
	 {
		 excel=new ExcelDataProvider();
		 config=new ConfigDataProvider();
		 Reporter.log("Setting up report and test is getting ready", true);
		 ExtentHtmlReporter extent=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/LoginTest_"+HelperClass.getCurrentDateTime()+".html"));
		 report=new ExtentReports();
		 report.attachReporter(extent);
		 Reporter.log("Settings done and test can be started", true);
	 }
	@BeforeClass
	public void setUp()
	{
		 Reporter.log("Trying to start browser and getting application ready", true);
		driver=BrowserFactory.startApplication(driver, config.getBrowser(), config.getStagingUrl());
		System.out.println(driver.getTitle());
	}
	
	@AfterClass
	public void tearDown()
	{
		BrowserFactory.quitBrowser(driver);
		
	}
	
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException 
	{
		 Reporter.log("Test is about to end", true);
		if(result.getStatus() == ITestResult.FAILURE)
		{
			logger.fail("Testcase failed", MediaEntityBuilder.createScreenCaptureFromPath(HelperClass.captureScreenshot(driver)).build());
		}
		if(result.getStatus() == ITestResult.SUCCESS)
		{
			logger.pass("Testcase passed", MediaEntityBuilder.createScreenCaptureFromPath(HelperClass.captureScreenshot(driver)).build());
		}
		if(result.getStatus() == ITestResult.SKIP)
		{
			logger.fail("Testcase skiped", MediaEntityBuilder.createScreenCaptureFromPath(HelperClass.captureScreenshot(driver)).build());
		}
		
		report.flush();
		 Reporter.log("Test completed>> Reports generated", true);
	}	
}
