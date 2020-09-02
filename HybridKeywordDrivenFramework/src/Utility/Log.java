package Utility;

import org.apache.log4j.Logger;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.log4j.LogManager;

public class Log 
{
    static final Logger logger = LogManager.getLogger(Log.class.getName());
	
    
	
	public static void main(String[] args) throws FileNotFoundException, IOException
	{
		 
		
		logger.info("initiated");
		logger.debug("debug");
		logger.error("Error.....");
	}
}
