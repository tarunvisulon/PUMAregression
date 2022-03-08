package com.qa.visulon.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Puma_RFCWriteData {

	public static void ExcelWrite(ExceluploadSettings set) {
		try {

			File f = new File(set.RFC_Excelpath);
		//	System.out.println(f.exists());
			FileInputStream fis = new FileInputStream(f);

			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheet(set.sheetname);
			XSSFRow rowNo = null;

			for (int row = set.rowCount; row < set.maxRow; row++) {

				rowNo = sheet.getRow(row);

				for (int col = set.columnCount; col <= set.maxCol; col++) {

					fillCellvalue(rowNo, col);

				}

			}

			saveExcelfile(f, wb);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void fillCellvalue(XSSFRow rowNo, int col) {
		String value = ElementUtils.getRandomInt();

		XSSFCell cellNo = rowNo.getCell(col, org.apache.poi.ss.usermodel.Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);

		if (cellNo == null) {
			rowNo.createCell(col).setCellValue(value);

		} else {
			cellNo.setCellValue(value);

		}
	}

	private static void saveExcelfile(File f, XSSFWorkbook wb) {
		FileOutputStream fileoutput;
		try {
			fileoutput = new FileOutputStream(f);
			wb.write(fileoutput);
			wb.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
