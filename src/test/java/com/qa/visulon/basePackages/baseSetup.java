package com.qa.visulon.basePackages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.qa.visulon.Utils.ConfigReader;
import com.qa.visulon.factory.Driverfactory;
import com.qa.visulon.pages.login_page;
import com.qa.visulon.pages.productSearch_BlankimportTemplate;
import com.qa.visulon.pages.productSearch_DownloadTemplate;
import com.qa.visulon.pages.productSearch_WHSPrice_ValidImportTemplate;
import com.qa.visulon.pages.productSearch_AreaRRP_ValidImportTemplate;

public class baseSetup {

	private WebDriver driver;

	public Driverfactory df;

	public ConfigReader cf;

	public Properties prop;

	public login_page lp;

	public productSearch_DownloadTemplate ps;

	public productSearch_BlankimportTemplate it;
	
	public productSearch_AreaRRP_ValidImportTemplate area;
	
	public productSearch_WHSPrice_ValidImportTemplate whs;

	@BeforeClass
	public void browserSetup() {

		df = new Driverfactory();
		cf = new ConfigReader();
		prop = cf.propertyFile();
		driver = df.init_browser(prop);

		lp = new login_page(driver);

		ps = new productSearch_DownloadTemplate(driver);

		it = new productSearch_BlankimportTemplate(driver);
		
		area = new productSearch_AreaRRP_ValidImportTemplate(driver);
		
		whs= new productSearch_WHSPrice_ValidImportTemplate(driver);

	}

	@AfterClass
	public void browserClose() {
		if (driver != null) {

			System.out.println("Browser Closed");

			driver.quit();

		}

	}

}
