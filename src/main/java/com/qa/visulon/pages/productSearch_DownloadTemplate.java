package com.qa.visulon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.visulon.Utils.ElementUtils;

public class productSearch_DownloadTemplate {

	WebDriver driver;

	@FindBy(xpath = "//div[@class='clientLogo']/parent::div//div[@id='btnProductSearch']")
	private WebElement productSearch;

	@FindBy(id = "btnExcelFileImport")
	private WebElement Excelbtn;

	@FindBy(xpath = "//div[@class='downloadTemplate']")
	private WebElement downloadTemp;

	@FindBy(xpath = "//div[@class='articleSearchBtn']//input[@name='rbExportTemplate']")
	private WebElement ArticleSearch_Download;

	@FindBy(xpath = "//div[@class='areaRRPBtn']//input[@name='rbExportTemplate']")
	private WebElement AreaRRP_Download;

	@FindBy(xpath = "//div[@class='areaWHSCountryPriceBtn']//input[@name='rbExportTemplate']")
	private WebElement WHSPrice_Download;

	@FindBy(xpath = "//div[@id='divDownloadTemplateForAreaRFC']//input[@name='rbExportTemplate']")
	private WebElement RFC_Download;

	@FindBy(xpath = "//a[@class='downloadTemplateBtn primaryOrange']")
	private WebElement downloadTempbtn;

	@FindBy(xpath = "//span[@id='season']")
	private WebElement SeasonSelection;

	@FindBy(xpath = "//div[@onclick=\"$('.importExpFilePopupWrapper, #ImportFileExcelPopupDiv').hide()\"]//span[@class='modernPopupCloseIcon']")
	private WebElement Closepopup;
	
	@FindBy(xpath = "//div[@id='NavUserName']")
	private WebElement userSetting;
	
	@FindBy(xpath = "//div[@id='NavUserName']/parent::div//a[@id='LogoutID']")
	private WebElement logout;
	

	public productSearch_DownloadTemplate(WebDriver driver)

	{

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void AllDownloadTemplate() throws InterruptedException {
		productSearch.click();
		Excelbtn.click();
		downloadTemp.click();
		String season = SeasonSelection.getText();
		System.out.println(season);
		ArticleSearch_Download.click();
		Thread.sleep(3000);
		downloadTempbtn.click();
		AreaRRP_Download.click();
		Thread.sleep(3000);
		downloadTempbtn.click();
		WHSPrice_Download.click();
		Thread.sleep(3000);
		downloadTempbtn.click();
		RFC_Download.click();
		Thread.sleep(3000);
		downloadTempbtn.click();
		Closepopup.click();
		ElementUtils.mouseAction(driver, userSetting);
		logout.click();

	}
	
	

}
