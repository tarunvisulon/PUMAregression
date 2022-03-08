package com.qa.visulon.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class Puma_Login_ExcelReader {

	@DataProvider
	public  String[][] logindata() throws IOException {

		File f = new File(ConstantData.Excel_path);
		//System.out.println(f.exists());
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Userlogin");
		int rowNumber = sheet.getPhysicalNumberOfRows();
		int columnNumber = sheet.getRow(0).getLastCellNum();

		String[][] userData = new String[rowNumber - 1][columnNumber];

		for (int i = 0; i < rowNumber - 1; i++) {
			for (int j = 0; j < columnNumber; j++) {

				userData[i][j] = sheet.getRow(i + 1).getCell(j).getStringCellValue();

			}

		}

		fis.close();
		workbook.close();
        
		return userData;
	}
	
}
