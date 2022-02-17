package com.qa.visulon.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;



public class ConfigReader {

	private Properties prop;
	public Properties propertyFile() {

		
		
		try {
			FileInputStream file = new FileInputStream(ConstantData.Config_Path);
			prop= new Properties();
			try {
				prop.load(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return prop;
	}
	
	

}
