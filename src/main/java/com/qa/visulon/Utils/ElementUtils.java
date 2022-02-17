package com.qa.visulon.Utils;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {

	public WebDriver driver;
	public WebDriverWait wait;

	// Constructor
	public ElementUtils(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver,0);
	}

	// Click Method
	public void click(By by) {
		waitVisibility(by).click();
	}

	// Write Text
	public void writeText(By by, String text) {
		waitVisibility(by).sendKeys(text);
	}

	// Read Text
	public String readText(By by) {
		return waitVisibility(by).getText();
	}

	// Wait
	public WebElement waitVisibility(By by) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

}
