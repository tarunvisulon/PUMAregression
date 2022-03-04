package com.qa.visulon.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelToDataTable {
	
	
	public static String[][] Get(String filePath, String Sheetname) throws IOException {

		File f = new File(filePath);
		System.out.println(f.exists());
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(Sheetname);
		int rowNumber = sheet.getPhysicalNumberOfRows();
		int columnNumber = sheet.getRow(0).getLastCellNum();

		String[][] userData = new String[rowNumber - 1][columnNumber - 1];

		for (int i = 0; i < rowNumber - 1; i++) {
			for (int j = 0; j < columnNumber-1; j++) {

				userData[i][j] = sheet.getRow(i + 1).getCell(j+1).getStringCellValue();

			}

		}

		fis.close();
		workbook.close();
        
		return userData;
	}
	
	
	
	

}
