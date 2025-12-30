package com.orangehrm.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerLoad {
	private static Logger logger;
	
	public static Logger getLogger(Class<?> cls) {
		logger = LogManager.getLogger(cls);
		return logger;
	}
}
