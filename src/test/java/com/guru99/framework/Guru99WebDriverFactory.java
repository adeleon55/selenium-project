package com.guru99.framework;

import java.net.MalformedURLException;

/* Below is Srini's version
public class Guru99WebDriverFactory {
	
	*//**
     * Get a Web Driver instance.
     * @return An instance of a web webDriver.
     * @param BrowserName
	 * @throws MalformedURLException 
     *//*
    public static Guru99WebDriverImpl getWebDriverInstance(String BrowserName) throws MalformedURLException {
    	
    	Guru99WebDriverImpl webDriver = new Guru99WebDriverImpl();
        webDriver.init(BrowserName);
    	      //webDriver.intSauceLabs(BrowserName);
    		//webDriver.init(BrowserName);
   
        return webDriver;      
                }	

}*/

//Below is my version shadowing Srini's to stick the concept in my brain

public class Guru99WebDriverFactory {
	
	public static Guru99WebDriverImpl getWebDriverInstance(String BrowserName) throws MalformedURLException {
		
		//create an instance of Guru99WebDriverImpl to be able to access its method, in this case the init() method
		Guru99WebDriverImpl webDriver = new Guru99WebDriverImpl();
			webDriver.init(BrowserName);
			return webDriver;
	}
}