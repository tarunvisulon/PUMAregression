package com.qa.visulon.test;

import java.io.IOException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.visulon.Utils.ConstantData;


import com.qa.visulon.Utils.Puma_Login_ExcelReader;
import com.qa.visulon.Utils.RFC_ExcelToDataTable;
import com.qa.visulon.basePackages.baseSetup;
import com.qa.visulon.pages.productSearch_AreaRRP_ValidImportTemplate;
import com.qa.visulon.pages.productSearch_RFC_ValidImportTemplate;
import com.qa.visulon.pages.productSearch_WHSPrice_ValidImportTemplate;

public class VRT_243_Excel_ValidImport extends baseSetup {

	@Test(priority = 0, dataProvider = "logindata", dataProviderClass = Puma_Login_ExcelReader.class)
	public void Puma_login(String uname, String pwd) throws InterruptedException {
		lp.loginToPUMA(uname, pwd);

	}

	@Test(priority = 1, enabled = true)
	public void AreaRRP_ValidImportExcel() throws InterruptedException {
		Assert.assertEquals(area.valid_importTemplate(), ConstantData.Season);
		Assert.assertEquals(area.AreaRRP_ImportTeplate(), ConstantData.Valid_SuccessImportmsg_AreaRRP);
		// System.out.println(productSearch_ValidImportTemplate.text_AreaRRP +".00
		// EUR");
		Assert.assertEquals(area.AreaRRP_ImportValidation(),
				Integer.toString(Integer.parseInt(productSearch_AreaRRP_ValidImportTemplate.text_AreaRRP)) + ".00 EUR");
         
	}

	@Test(priority = 2, enabled = true)
	public void WHS_ValidImportExcel() throws InterruptedException {
		Assert.assertEquals(whs.valid_importTemplate(), ConstantData.Season);
		Assert.assertEquals(whs.WHS_ImportTeplate(), ConstantData.Valid_SuccessImportmsg_WHSPrice);
		whs.WHS_ImportValidation();

		List<String> newValue = productSearch_WHSPrice_ValidImportTemplate.ImportValueValidation();

		Assert.assertEquals(newValue.get(0),
				Integer.toString(Integer.parseInt(productSearch_WHSPrice_ValidImportTemplate.Indonesiatext_WHS))
						+ ".00 IDR");
		Assert.assertEquals(newValue.get(1),
				Integer.toString(Integer.parseInt(productSearch_WHSPrice_ValidImportTemplate.Malaysiatext_WHS))
						+ ".00 MYR");
		Assert.assertEquals(newValue.get(2),
				Integer.toString(Integer.parseInt(productSearch_WHSPrice_ValidImportTemplate.Phileppnestext_WHS))
						+ ".00 PHP");
		Assert.assertEquals(newValue.get(3),
				Integer.toString(Integer.parseInt(productSearch_WHSPrice_ValidImportTemplate.Singaporetext_WHS))
						+ ".00 SGD");
	}

	@Test(priority = 3)
	public void RFC_validImportExcel() throws InterruptedException, IOException {

		Assert.assertEquals(rfc.valid_importTemplate(), ConstantData.Season);
		Assert.assertEquals(rfc.RFC_ImportTeplate(), ConstantData.Valid_SuccessImportmsg_RFC);
		Assert.assertEquals(rfc.RFC_ImportValidation(), ConstantData.RFC_btncolor);

		List<String> newValue = productSearch_RFC_ValidImportTemplate.RFC_ImportValueValidation();

		//System.out.println(newValue);

		String[][] excelData = RFC_ExcelToDataTable.Get_RFC(ConstantData.RFC_path, "Template");

		Assert.assertEquals(newValue.get(0), Integer.toString(Integer.parseInt(excelData[0][0])));

		Assert.assertEquals(newValue.get(1), Integer.toString(Integer.parseInt(excelData[0][1])));

		Assert.assertEquals(newValue.get(2),
				Integer.toString(Integer.parseInt(excelData[0][0]) + Integer.parseInt(excelData[0][1])));
		


	}

}
