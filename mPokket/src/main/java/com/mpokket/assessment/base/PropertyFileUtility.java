package com.mpokket.assessment.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtility {
	
	public static String getPropertyValue(String key) {
		Properties prop=new Properties();
		try {
			FileInputStream file=new FileInputStream(".\\src\\test\\resources\\APICredentials.properties");
			 prop=new Properties();
			prop.load(file);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop.getProperty(key);
	}

}
