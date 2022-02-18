package com.qa.visulon.test;

import org.testng.annotations.Test;

import com.qa.visulon.Utils.Puma_ExcelReader;
import com.qa.visulon.basePackages.baseSetup;

public class VRT_243_ExcelUpload extends baseSetup {

	@Test(priority = 0, dataProvider = "logindata", dataProviderClass = Puma_ExcelReader.class)
	public void Puma_login(String uname, String pwd) {
		lp.loginToPUMA(uname, pwd);

	}

}
