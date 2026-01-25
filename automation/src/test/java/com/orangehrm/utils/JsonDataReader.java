package com.orangehrm.utils;

import java.io.InputStream;

import javax.management.RuntimeErrorException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonDataReader {
	
	private static JsonNode rootNode;
	
	static {
		try {
			ObjectMapper mapper = new ObjectMapper();
			InputStream is = JsonDataReader.class
					.getClassLoader()
					.getResourceAsStream("loginData.json");
			
			if(is == null) {
				throw new RuntimeException("loginData.jsonnot found");
			}
			rootNode = mapper.readTree(is);
		}catch(Exception e) {
			throw new RuntimeException("Failed to load loginData.json",e);
		}
	}
	
	public static JsonNode getValidUser() {
		return rootNode.get("validUser");
	}
	
	public static JsonNode getInvalidUsers() {
		return rootNode.get("invalidUsers");
	}

}
