package com.learnautomaton.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	WebDriver driver;
	public LoginPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	@FindBy(id="user-name") WebElement username;
	@FindBy(id="password") WebElement Password;
	@FindBy(id="login-button") WebElement LoginBtn;
	
	public void login(String uname, String Pwd)
	{
		try {
			Thread.sleep(4000);
		}catch(Exception e){}
		username.sendKeys(uname);
		Password.sendKeys(Pwd);
		LoginBtn.click();
		System.out.println("Login button clicked");
	}
	
	
	
	

}
