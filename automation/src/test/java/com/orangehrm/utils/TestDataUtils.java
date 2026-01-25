package com.orangehrm.utils;

public class TestDataUtils {
	public static String getRandomFirstName() {
		return "Froze" + System.currentTimeMillis();
	}
	
	public static String getRandomLastName() {
		return "Wick" + System.currentTimeMillis();
	}
	
	public static String getRandomEmployeeId() {
		return String.valueOf(System.currentTimeMillis()).substring(9);
	}
}
