package com.qa.visulon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.visulon.Utils.ElementUtils;

public class login_page extends ElementUtils{
   
	
	WebDriver driver;
	
	private By username = By.id("txtUserName");

	private By password = By.id("txtPassword");

	private By lgnbtn = By.id("LinkButton1");

	
	
	public login_page(WebDriver driver)
	{
	
		super(driver);
		
	}
	
	
	public login_page loginToPUMA(String uname, String pwd)
	{
		writeText(username, uname);
		writeText(password, pwd);
		click(lgnbtn);
		return this;
	}
	
	
	
	
	
	
}
