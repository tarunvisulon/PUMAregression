package com.qa.visulon.Utils;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;

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

	public static String getAttribute(WebElement element, String value) {

		return element.getAttribute(value);
	}

	public static String getRandomInt() {

		String SALTCHARS = "1234567890";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 2) { // length of the random string.
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		return salt.toString();
	}

	public static String getbtncolor(WebElement element, String cssproperty) {

		String color = element.getCssValue(cssproperty);

		String hexValue = Color.fromString(color).asHex();

		return hexValue;

	}

}
