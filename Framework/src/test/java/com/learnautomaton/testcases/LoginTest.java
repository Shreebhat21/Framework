package com.learnautomaton.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.learnautomation.utility.BrowserFactory;
import com.learnautomation.utility.ExcelDataProvider;
import com.learnautomaton.pages.BaseClass;
import com.learnautomaton.pages.LoginPage;

public class LoginTest extends BaseClass {

	
	@Test
	public void loginApp()
	{
		logger=report.createTest("Login to Swaglabs");
		LoginPage loginPage=PageFactory.initElements(driver, LoginPage.class);
		logger.info("Application started");
		System.out.println("enterning login credentials");
		logger.info("enterning login credentials");
		loginPage.login(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));
		
		
	}
	
	
}
