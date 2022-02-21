package com.qa.visulon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.visulon.Utils.ElementUtils;

public class productSearch extends ElementUtils{
	
	By productSearch= By.xpath("//div[@class='clientLogo']/parent::div//div[@id='btnProductSearch']");
	
	By Excelbtn= By.id("btnExcelFileImport");
	
	By downloadTemp= By.xpath("//div[@class='downloadTemplate']");
	
	By ArticleSearch= By.xpath("//div[@class='articleSearchBtn']//input[@name='rbExportTemplate']");
	
	By AreaRRP= By.xpath("//div[@class='areaRRPBtn']//input[@name='rbExportTemplate']");
	
	By WHSPrice=By.xpath("//div[@class='areaWHSCountryPriceBtn']//input[@name='rbExportTemplate']");
	
	By RFC= By.xpath("//div[@id='divDownloadTemplateForAreaRFC']//input[@name='rbExportTemplate']");

	By downloadTempbtn= By.xpath("//a[@class='downloadTemplateBtn primaryOrange']");
	
	
	
	public productSearch(WebDriver driver) 
	
	{
		super(driver);
		
	}
	
	public productSearch AllDownloadTemplate()
	{
		click(productSearch);
		click(Excelbtn);
		click(downloadTemp);
		click(ArticleSearch);
		click(downloadTempbtn);
		click(AreaRRP);
		click(downloadTempbtn);
		click(WHSPrice);
		click(downloadTempbtn);
		click(RFC);
		click(downloadTempbtn);
		return this;
	
	}
	
	
	
	
	
	
	
	
	
	

}
