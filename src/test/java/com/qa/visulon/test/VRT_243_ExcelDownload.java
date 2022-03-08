package com.qa.visulon.test;

import org.testng.annotations.Test;


import com.qa.visulon.Utils.Puma_Login_ExcelReader;
import com.qa.visulon.basePackages.baseSetup;

public class VRT_243_ExcelDownload extends baseSetup {

	@Test(priority = 0, dataProvider = "logindata", dataProviderClass = Puma_Login_ExcelReader.class)
	public void Puma_login(String uname, String pwd) throws InterruptedException {
		lp.loginToPUMA(uname, pwd);

	}

	@Test(priority = 1)
	public void DownloadTepmlate() throws InterruptedException 
	{

		ps.AllDownloadTemplate();

	}

}