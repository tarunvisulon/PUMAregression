package com.qa.visulon.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.visulon.Utils.ConstantData;
import com.qa.visulon.Utils.ElementUtils;

public class productSearch_BlankimportTemplate {

	WebDriver driver;

	@FindBy(xpath = "//div[@class='clientLogo']/parent::div//div[@id='btnProductSearch']")
	private WebElement productSearch;

	@FindBy(id = "btnExcelFileImport")
	private WebElement Excelbtn;

	@FindBy(xpath = "//div[@id='exportReportTab']/parent::div//div[text()='Import Template']")
	private WebElement ImportTemplate;

	@FindBy(xpath = "//div[@class='articleSearchBtn']//input[@name='rbImportTemplate']")
	private WebElement ArticleSearch;

	@FindBy(xpath = "//div[@class='areaRRPBtn']//input[@name='rbImportTemplate']")
	private WebElement AreaRRP;

	@FindBy(xpath = "//div[@class='areaWHSCountryPriceBtn']//input[@name='rbImportTemplate']")
	private WebElement WHSPrice;

	@FindBy(xpath = "//div[@id='divImportTemplateForAreaRFC']//input[@name='rbImportTemplate']")
	private WebElement RFC;

	@FindBy(xpath = "//a[normalize-space()='Import']")
	private WebElement importTempbtn;

	@FindBy(xpath = "//input[@name='file']")
	private WebElement Choosefile;

	@FindBy(xpath = "//span[@id='season']")
	private WebElement SeasonSelection;

	@FindBy(xpath = "//div[@id='SuccessMsg']")
	private WebElement Successmsg;

	public productSearch_BlankimportTemplate(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void Blank_importTemplate() throws InterruptedException {

		productSearch.click();
		Excelbtn.click();
		ImportTemplate.click();
		String season = SeasonSelection.getText();
		System.out.println(season);

	}
	
	// Article Search

	public String Blank_ArticleSearchImport() throws InterruptedException {
		ArticleSearch.click();
		Thread.sleep(3000);
		ElementUtils.getElement(Choosefile, ConstantData.Blank_ArticleSearch_path);
		Thread.sleep(3000);
		importTempbtn.click();
		Thread.sleep(3000);
		return ElementUtils.getText(Successmsg).trim();

	}

	// Area RRP

	public String Blank_AreaRRPImport() throws InterruptedException {

		AreaRRP.click();
		Thread.sleep(3000);
		ElementUtils.getElement(Choosefile, ConstantData.Blank_AreaRRP_path);
		Thread.sleep(3000);
		importTempbtn.click();
		Thread.sleep(3000);
		return ElementUtils.getText(Successmsg).trim();
	}
	// Area WHS

	public String Blank_WHSImport() throws InterruptedException {
		WHSPrice.click();
		Thread.sleep(3000);
		ElementUtils.getElement(Choosefile, ConstantData.Blank_WHSPrice_path);
		Thread.sleep(3000);
		importTempbtn.click();
		Thread.sleep(3000);
		return ElementUtils.getText(Successmsg).trim();
	}
	// Area RFC

	public String Blank_RFCImport() throws InterruptedException {
		RFC.click();
		Thread.sleep(3000);
		ElementUtils.getElement(Choosefile, ConstantData.Blank_RFC_path);
		Thread.sleep(3000);
		importTempbtn.click();
		Thread.sleep(3000);
		return ElementUtils.getText(Successmsg).trim();
	}
}
