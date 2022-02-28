package com.qa.visulon.Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ElementUtils {

	WebDriver driver;

	public static void getElement(WebElement element, String path) {
		element.sendKeys(path);
	}

	public static void mouseAction(WebDriver driver, WebElement element)

	{
		Actions a = new Actions(driver);
		a.moveToElement(element).build().perform();

	}

	public static String getText(WebElement element) {

		return element.getText();

	}
}
