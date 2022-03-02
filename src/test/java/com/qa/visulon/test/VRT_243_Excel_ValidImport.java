package com.qa.visulon.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.visulon.Utils.ConstantData;
import com.qa.visulon.Utils.Puma_ExcelReader;
import com.qa.visulon.basePackages.baseSetup;
import com.qa.visulon.pages.productSearch_ValidImportTemplate;

public class VRT_243_Excel_ValidImport extends baseSetup{
	

	@Test(priority = 0, dataProvider = "logindata", dataProviderClass = Puma_ExcelReader.class)
	public void Puma_login(String uname, String pwd) throws InterruptedException {
		lp.loginToPUMA(uname, pwd);

	}
	
	
	@Test(priority = 1)
	public void ValidImportExcel() throws InterruptedException
	{
		Assert.assertEquals(vd.valid_importTemplate(), ConstantData.Season);
		Assert.assertEquals(vd.AreaRRP_ImportTeplate(),ConstantData.Valid_SuccessImportmsg);
	  //System.out.println(productSearch_ValidImportTemplate.text_AreaRRP  +".00 INR");
	    Assert.assertEquals(vd.AreaRRP_ImportValidation(), productSearch_ValidImportTemplate.text_AreaRRP +".00 INR");
		
		
	}
	
	
	
	

}
