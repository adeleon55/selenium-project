package com.examples.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class GlobalDataStore {

	public static String GeckoDriver_MAC;
	public static String GeckoDriver_WIN;
	public static String HomePage;
	//public static String ChromeDriver_MAC;
	public static String Chrome_Driver_MAC;
	public static String ChromeDriver_WIN;
	public static String Guru99HomePage;
	
	
	private Properties configFile= new Properties();
	

	public void initParameter() {
		//logger.info("START: Global Data Store initParameters Method");
		
		String propFile="selenium.properties";
		FileInputStream fis = null;
		
		String baseDir= System.getProperty("user.dir");
		
		try{
			
			///Users/srinivasnayani/Documents/SQAToolsAutomation/SQASeleniumProject/src/test/resources/selelium.properties
			fis=new FileInputStream(baseDir+ "/" +"src/test/resources/" +propFile);			
		    configFile.load(fis);
			
		    GeckoDriver_MAC=configFile.getProperty("GECKO_DRIVER_MAC");

		    //logger.info("GeckoDriver_MAC Value " +GeckoDriver_MAC);
		    GeckoDriver_WIN=configFile.getProperty("GECKO_DRIVER_WIN");
		    //HomePage=configFile.getProperty("BASE_URL");
		    HomePage=configFile.getProperty("BASE_URL_GURU");
		    Chrome_Driver_MAC=configFile.getProperty("CHROME_DRIVER_MAC");
		    System.out.println("The Chrome Driver Path " +Chrome_Driver_MAC);
		    Guru99HomePage=configFile.getProperty("GURU99_HOMEPAGE");

		}catch(FileNotFoundException e){
	    	
		System.out.println("File not Found" +e.getMessage());
		
	    }catch(IOException e){
	    	
		System.out.println("IO Exception " +e.getMessage());
		
	 }
		//logger.info("END:Global Data Store initParameters Method");
	}



	public static void setLogCategory(String string) {
		// TODO Auto-generated method stub
		
	}

}
