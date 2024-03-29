package com.qa.visulon.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.visulon.Utils.ConstantData;

import com.qa.visulon.Utils.Puma_Login_ExcelReader;
import com.qa.visulon.basePackages.baseSetup;

public class VRT_243_Excel_BLankImport extends baseSetup 
{

	@Test(priority = 0, dataProvider = "logindata", dataProviderClass = Puma_Login_ExcelReader.class)
	public void Puma_login(String uname, String pwd) throws InterruptedException {
		lp.loginToPUMA(uname, pwd);

	}
	
	@Test(priority = 1)
	
	public void blank_ExcelImport() throws InterruptedException
	{
		
		it.Blank_importTemplate();
		Assert.assertEquals(it.Blank_ArticleSearchImport(),ConstantData.NoRecord_SuccessImportmsg);
		Assert.assertEquals(it.Blank_AreaRRPImport(),ConstantData.NoRecord_SuccessImportmsg);
		Assert.assertEquals(it.Blank_WHSImport(), ConstantData.NoRecord_SuccessImportmsg);
		Assert.assertEquals(it.Blank_RFCImport(), ConstantData.NoRecord_SuccessImportmsg);
	  
		
	}
	
	
	
	

}
