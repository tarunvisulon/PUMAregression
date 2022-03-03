package com.qa.visulon.pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.visulon.Utils.ConstantData;
import com.qa.visulon.Utils.ElementUtils;
import com.qa.visulon.Utils.Puma_writeData;

public class productSearch_WHSPrice_ValidImportTemplate {

	WebDriver driver;

	public static String Indonesiatext_WHS;
	public static String Malaysiatext_WHS;
	public static String Phileppnestext_WHS;
	public static String Singaporetext_WHS;

	@FindBy(xpath = "//div[@class='clientLogo']/parent::div//div[@id='btnProductSearch']")
	private WebElement productSearch;

	@FindBy(id = "btnExcelFileImport")
	private WebElement Excelbtn;

	@FindBy(xpath = "//div[@id='exportReportTab']/parent::div//div[text()='Import Template']")
	private WebElement ImportTemplate;

	@FindBy(xpath = "//div[@class='areaWHSCountryPriceBtn']//input[@name='rbImportTemplate']")
	private WebElement WHSPrice;

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

	@FindBy(xpath = "//span[normalize-space()='WHS Price INDONESIA']/parent::td/following-sibling::td/span[@class='attrContent']")
	private static WebElement fetchWHSPrice_Indonesia;

	@FindBy(xpath = "//span[normalize-space()='WHS Price MALAYSIA']/parent::td/following-sibling::td/span[@class='attrContent']")
	private static WebElement fetchWHSPrice_Malaysia;

	@FindBy(xpath = "//span[normalize-space()='WHS Price PHILIPPINES']/parent::td/following-sibling::td/span[@class='attrContent']")
	private static WebElement fetchWHSPrice_Philippines;

	@FindBy(xpath = "//span[normalize-space()='WHS Price SINGAPORE']/parent::td/following-sibling::td/span[@class='attrContent']")
	private static WebElement fetchWHSPrice_Singapore;

	public productSearch_WHSPrice_ValidImportTemplate(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	public String valid_importTemplate() {
		productSearch.click();
		Excelbtn.click();
		ImportTemplate.click();
		String season = SeasonSelection.getText().trim();
		Indonesiatext_WHS = ElementUtils.getRandomInt();
		Malaysiatext_WHS = ElementUtils.getRandomInt();
		Phileppnestext_WHS = ElementUtils.getRandomInt();
		Singaporetext_WHS = ElementUtils.getRandomInt();

		Puma_writeData.writeData(ConstantData.WHSPrice_path, "Template", 1, 2, Indonesiatext_WHS);
		Puma_writeData.writeData(ConstantData.WHSPrice_path, "Template", 2, 2, Malaysiatext_WHS);
		Puma_writeData.writeData(ConstantData.WHSPrice_path, "Template", 3, 2, Phileppnestext_WHS);
		Puma_writeData.writeData(ConstantData.WHSPrice_path, "Template", 4, 2, Singaporetext_WHS);

		return season;
	}

	public String WHS_ImportTeplate() throws InterruptedException {

		WHSPrice.click();
		Thread.sleep(3000);
		ElementUtils.getElement(Choosefile, ConstantData.WHSPrice_path);
		Thread.sleep(3000);
		importTempbtn.click();
		Thread.sleep(3000);
		String msg = ElementUtils.getText(ValidSuccessmsg).trim();
		Thread.sleep(3000);
		CloseExcelPopup.click();
		return msg;

	}

	public void WHS_ImportValidation() throws InterruptedException {

		QuickSsearch_box.sendKeys(ConstantData.Common_Article);
		QuickSearch_btn.click();
		Thread.sleep(5000);
		ElementUtils.mouseAction(driver, SelectArticles);
		blueI.click();
		Thread.sleep(3000);

	}

	public static List<String> ImportValueValidation() throws InterruptedException {

		String IndonesiaValue = ElementUtils.getText(fetchWHSPrice_Indonesia);

		Thread.sleep(3000);
		String MalaysiaValue = ElementUtils.getText(fetchWHSPrice_Malaysia);

		Thread.sleep(3000);
		String PhilippinesValue = ElementUtils.getText(fetchWHSPrice_Philippines);

		Thread.sleep(3000);
		String SingaporeValue = ElementUtils.getText(fetchWHSPrice_Singapore);

		return Arrays.asList(IndonesiaValue, MalaysiaValue, PhilippinesValue, SingaporeValue);

	}

}
