package com.orangehrm.utils;

import java.io.InputStream;
import java.util.Properties;

public class TestDataReader {
	
	private static Properties prop = new Properties();
	
	static {
		try {
			InputStream is = TestDataReader.class
					.getClassLoader()
					.getResourceAsStream("testdata.properties");
		
		if (is == null) {
			throw new RuntimeException("testdata.properties not found");
		}
		
		prop.load(is);
		
		}catch(Exception e) {
			throw new RuntimeException("Failed to load test data");
		}
	}
	
	public static String get(String key) {
		String value = prop.getProperty(key);
		if (value == null) {
			throw new RuntimeException("Test data key not found: "+ key);
		} 
		return value;
	}

}
