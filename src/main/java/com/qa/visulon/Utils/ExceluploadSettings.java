package com.qa.visulon.Utils;

public class ExceluploadSettings {

	public String RFC_Excelpath = "";
	public String sheetname = "Template";
	public int rowCount = 1;
	public int columnCount = 1;

	public int maxRow = 2;
	public int maxCol = 2;

	public ExceluploadSettings(String settingfor) {
		if (settingfor == "rfc") {
			RFC_Excelpath = ConstantData.RFC_path;

		} else if (settingfor == "arearrp") {
			RFC_Excelpath = ConstantData.AreaRRP_path;
			rowCount = 1;
			columnCount = 1;

			maxRow = 1;
			maxCol = 1;

		}

	}

}
