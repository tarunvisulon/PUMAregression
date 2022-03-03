package com.qa.visulon.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.tika.parser.ParseContext;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.visulon.Utils.ConstantData;
import com.qa.visulon.Utils.Puma_ExcelReader;
import com.qa.visulon.basePackages.baseSetup;
import com.qa.visulon.pages.productSearch_AreaRRP_ValidImportTemplate;
import com.qa.visulon.pages.productSearch_WHSPrice_ValidImportTemplate;

public class VRT_243_Excel_ValidImport extends baseSetup{
	

	@Test(priority = 0, dataProvider = "logindata", dataProviderClass = Puma_ExcelReader.class)
	public void Puma_login(String uname, String pwd) throws InterruptedException {
		lp.loginToPUMA(uname, pwd);

	}
	
	
	@Test(priority = 1,enabled = false)
	public void AreaRRP_ValidImportExcel() throws InterruptedException
	{
		Assert.assertEquals(area.valid_importTemplate(), ConstantData.Season);
		Assert.assertEquals(area.AreaRRP_ImportTeplate(),ConstantData.Valid_SuccessImportmsg_AreaRRP);
	 // System.out.println(productSearch_ValidImportTemplate.text_AreaRRP  +".00 EUR");
	    Assert.assertEquals(area.AreaRRP_ImportValidation(), productSearch_AreaRRP_ValidImportTemplate.text_AreaRRP +".00 EUR");
		
		
	}
	
	@Test(priority = 2)
	public void WHS_ValidImportExcel() throws InterruptedException
	{
		Assert.assertEquals(whs.valid_importTemplate(), ConstantData.Season);
		Assert.assertEquals(whs.WHS_ImportTeplate(),ConstantData.Valid_SuccessImportmsg_WHSPrice);
		whs.WHS_ImportValidation();
		
		List<String> newValue = productSearch_WHSPrice_ValidImportTemplate.ImportValueValidation();
		System.out.println(newValue);
		System.out.println(newValue.size());
		
		/*
		 * for (int i = 0; i < newValue.size(); i++) {
		 * 
		 * System.out.println(newValue.get(i)); String
		 * tempvalue=productSearch_WHSPrice_ValidImportTemplate.Indonesiatext_WHS
		 * +".00 IDR";
		 * 
		 * System.out.println(tempvalue); Assert.assertEquals(newValue.get(i),
		 * tempvalue); }
		 */
	    Assert.assertEquals(newValue.get(0), Integer.toString(Integer.parseInt(productSearch_WHSPrice_ValidImportTemplate.Indonesiatext_WHS)) +".00 IDR");
	    Assert.assertEquals(newValue.get(1), Integer.toString(Integer.parseInt(productSearch_WHSPrice_ValidImportTemplate.Malaysiatext_WHS)) +".00 MYR");
	    Assert.assertEquals(newValue.get(2), Integer.toString(Integer.parseInt(productSearch_WHSPrice_ValidImportTemplate.Phileppnestext_WHS)) +".00 PHP");
	    Assert.assertEquals(newValue.get(3), Integer.toString(Integer.parseInt(productSearch_WHSPrice_ValidImportTemplate.Singaporetext_WHS)) +".00 SGD");
	}
	
	

}
