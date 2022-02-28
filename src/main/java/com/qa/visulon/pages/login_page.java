package com.qa.visulon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class login_page {

	WebDriver driver;

	@FindBy(id = "txtUserName")
	private WebElement userName;

	@FindBy(id = "txtPassword")
	private WebElement password;

	@FindBy(id = "LinkButton1")
	private WebElement lgnbtn;

	public login_page(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void loginToPUMA(String uname, String pwd) {
		userName.sendKeys(uname);
		password.sendKeys(pwd);
		lgnbtn.click();

	}

}
