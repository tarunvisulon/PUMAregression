package com.qa.visulon.pages;

import java.util.Arrays;
import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.visulon.Utils.ConstantData;
import com.qa.visulon.Utils.ElementUtils;
import com.qa.visulon.Utils.ExceluploadSettings;
import com.qa.visulon.Utils.Puma_RFCWriteData;


public class productSearch_RFC_ValidImportTemplate {
	 WebDriver driver;

	public static String Retail_text;
	public static String Wholesale_text;
	public static String Total_RFC;

	@FindBy(xpath = "//div[@class='clientLogo']/parent::div//div[@id='btnProductSearch']")
	private WebElement productSearch;

	@FindBy(id = "btnExcelFileImport")
	private WebElement Excelbtn;

	@FindBy(xpath = "//div[@id='exportReportTab']/parent::div//div[text()='Import Template']")
	private WebElement ImportTemplate;

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

	@FindBy(xpath = "//div[@id='btnPumaKeyInitiatives']/parent::div/div[@id='btnPumaRFC']")
	private WebElement bluei_RFC;

	// @FindBy(xpath = "//td[normalize-space()='Retail
	// [RT]']/following-sibling::td/input[@plntyp='RT']")
	@FindBy(xpath = "//input[@plntyp='RT']")
	private static WebElement fetchRFC_RT;

	@FindBy(xpath = "//input[@plntyp='WS']")
	private static WebElement fetchRFC_WS;

	@FindBy(xpath = "//td[normalize-space()='Total RFC']/following-sibling::td/span[@id='bluei_cgr_rt_total']")
	private static WebElement fetchRFC_Total;
	
	@FindBy(xpath = "//div[@onclick='fnCloseProductSpecificationPopup();']")
	private static WebElement Close_blueI;
	
	@FindBy(xpath = "//div[contains(@class,'blueIArticleDivBtn_Active')]")
	private WebElement get_RFCbtn_color;
	
	@FindBy(tagName = "body")
	private WebElement blank_click;

	public productSearch_RFC_ValidImportTemplate(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public String valid_importTemplate() {
	//	productSearch.click();
		Excelbtn.click();
		ImportTemplate.click();
		String season = SeasonSelection.getText().trim();
		ExceluploadSettings set = new ExceluploadSettings("rfc");
		Puma_RFCWriteData.ExcelWrite(set);
		return season;
	}

	public String RFC_ImportTeplate() throws InterruptedException {

		RFC.click();
		Thread.sleep(3000);
		ElementUtils.getElement(Choosefile, ConstantData.RFC_path);
		Thread.sleep(3000);
		importTempbtn.click();
		Thread.sleep(3000);
		String msg = ElementUtils.getText(ValidSuccessmsg).trim();
		Thread.sleep(3000);
		CloseExcelPopup.click();
		return msg;

	}

	public String RFC_ImportValidation() throws InterruptedException {

		QuickSsearch_box.sendKeys(ConstantData.Common_Article);
		QuickSearch_btn.click();
		Thread.sleep(5000);
		ElementUtils.mouseAction(driver, SelectArticles);
		blueI.click();
		Thread.sleep(3000);
		bluei_RFC.click();
		Thread.sleep(3000);
		blank_click.click();
	    String RFCbtnColor = ElementUtils.getbtncolor(get_RFCbtn_color, "background-color");
	    return RFCbtnColor;

	}

	public static List<String> RFC_ImportValueValidation() throws InterruptedException {

		String RTValue = ElementUtils.getAttribute(fetchRFC_RT, "value");
		Thread.sleep(3000);
		String WSValue = ElementUtils.getAttribute(fetchRFC_WS, "value");
		Thread.sleep(3000);
		String TotalValue = ElementUtils.getText(fetchRFC_Total);
		return Arrays.asList(RTValue, WSValue, TotalValue);
		

	}

}
