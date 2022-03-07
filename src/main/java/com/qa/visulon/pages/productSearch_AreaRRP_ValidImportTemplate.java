package com.qa.visulon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.visulon.Utils.ConstantData;
import com.qa.visulon.Utils.ElementUtils;
import com.qa.visulon.Utils.Puma_writeData;

public class productSearch_AreaRRP_ValidImportTemplate {

	WebDriver driver;
	
	public static String text_AreaRRP;

	@FindBy(xpath = "//div[@class='clientLogo']/parent::div//div[@id='btnProductSearch']")
	private WebElement productSearch;

	@FindBy(id = "btnExcelFileImport")
	private WebElement Excelbtn;

	@FindBy(xpath = "//div[@id='exportReportTab']/parent::div//div[text()='Import Template']")
	private WebElement ImportTemplate;

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
	private WebElement ValidSuccessmsg;

	@FindBy(xpath = "//div[@onclick=\"$('.importExpFilePopupWrapper, #ImportFileExcelPopupDiv').hide()\"]//span[@class='modernPopupCloseIcon']")
	private WebElement CloseExcelPopup;

	@FindBy(xpath = "(//input[@id='ContentPlaceHolder1_txtSearch'])[1]")
	private WebElement QuickSsearch_box;

	@FindBy(xpath = "(//input[@id='ContentPlaceHolder1_btnSearch'])[1]")
	private WebElement QuickSearch_btn;

	@FindBy(xpath = "//div[@class='ProductSearch_CanceledArticle']//img")
	private WebElement SelectArticles;

	@FindBy(xpath = "//img[@id='imgProductSpecs']")
	private WebElement blueI;

	@FindBy(xpath = "//span[normalize-space()='Area RRP']/parent::td/following-sibling::td/span[@class='attrContent']")
	private WebElement fetchAreaRRP;
	
	@FindBy(xpath = "//div[@onclick='fnCloseProductSpecificationPopup();']")
	private WebElement Close_blueI;

	public productSearch_AreaRRP_ValidImportTemplate(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public String valid_importTemplate() {
		productSearch.click();
		Excelbtn.click();
		ImportTemplate.click();
		String season = SeasonSelection.getText().trim();
		text_AreaRRP=ElementUtils.getRandomInt();
		Puma_writeData.writeData(ConstantData.AreaRRP_path, "Template", 1, 1, text_AreaRRP);
		return season;
	}

	public String AreaRRP_ImportTeplate() throws InterruptedException {

		AreaRRP.click();
		Thread.sleep(3000);
		ElementUtils.getElement(Choosefile, ConstantData.AreaRRP_path);
		Thread.sleep(3000);
		importTempbtn.click();
		Thread.sleep(3000);
		String msg = ElementUtils.getText(ValidSuccessmsg).trim();
		Thread.sleep(3000);
		CloseExcelPopup.click();
		return msg;

	}

	public String AreaRRP_ImportValidation() throws InterruptedException {

		QuickSsearch_box.sendKeys(ConstantData.Common_Article);
		QuickSearch_btn.click();
		Thread.sleep(5000);
		ElementUtils.mouseAction(driver, SelectArticles);
		blueI.click();
		Thread.sleep(3000);
		String RRPvalue=ElementUtils.getText(fetchAreaRRP);
		Thread.sleep(3000);
		Close_blueI.click();
		return RRPvalue;
		

	}

}
