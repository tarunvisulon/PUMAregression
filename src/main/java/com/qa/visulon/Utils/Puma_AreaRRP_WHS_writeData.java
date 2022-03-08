package com.qa.visulon.Utils;

import java.io.File;
import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Puma_AreaRRP_WHS_writeData {

	@SuppressWarnings("null")
	public static void writeData(String ExcelPath, String Sheetname, int rowCount, int ColumnCount, String value) {
		try {
			File f = new File(ExcelPath);
		//	System.out.println(f.exists());

			FileInputStream fis = new FileInputStream(f);

			XSSFWorkbook wb = new XSSFWorkbook(fis);

			XSSFSheet sheet = wb.getSheet(Sheetname);

			XSSFRow row = sheet.getRow(rowCount);

			XSSFCell cell = row.getCell(ColumnCount,
					org.apache.poi.ss.usermodel.Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);

			if (cell == null) {

				row.createCell(ColumnCount);
				cell.setCellValue(value);
				

			} else {

				cell.setCellValue(value);
			
			}

			FileOutputStream fio = new FileOutputStream(f);
			wb.write(fio);
			wb.close();
		//	System.out.println("WriteData successfully");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

	//	Puma_AreaRRP_WHS_writeData data = new Puma_AreaRRP_WHS_writeData();
		// data.writeData(ConstantData.AreaRRP_path,"Template", 1, 1,
		// ElementUtils.getRandomInt());
		// data.writeData(ConstantData.WHSPrice_path,"Template", 1,
		// 2,ElementUtils.getRandomInt());
		
	//	data.writeData(ConstantData.RFC_path, "Template", 1, 2 ,3, ElementUtils.getRandomInt());
	}

}
