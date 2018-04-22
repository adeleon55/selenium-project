package com.examples.pages;

//import com.examples.cofig.GlobalDataStore;
import com.guru99.framework.Guru99WebDriverImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class Guru99LoginPage {
	
	//GlobalDataStore gds = new GlobalDataStore();
	WebDriver driverInstance;
	public static String LogCategory;
	public static Logger logger;
	
	Guru99WebDriverImpl driver;
	//final static Logger logger = Logger.getLogger("GURU99_TESTS");
	
	By homePageUserName = By.xpath("//h2[@class='barone']");
	By user99GuruName = By.xpath("//input[@name='uid']");// useid textfield
	By password99Guru = By.xpath("//input[@type='password']");
	By login = By.xpath("//input[@type='submit']");
	
	
	//By Password=By.xpath("//td[contains(), 'UserID')]//parent::tr/flollow"
	//By Login = By.xpath("//td[contains(text(),
	
	public void setWebDriver(Guru99WebDriverImpl webDriver) {
		
		this.driver = webDriver;		
			
	}

	public String getHomePageDashboardUserName(){
    	logger.info("START: getHomePageDashboardUserName");
      System.out.println("comming here");    
      //System.out.println(" The Text "+driver.FindElement(homePageUserName).getText());
      logger.info("END: getHomePageDashboardUserName");
         return driver.FindElement(homePageUserName).getText();
     }
	
		
	
	/*public void testGuru99Login(String sUserName, String sPassword) throws Exception  {
		// TODO Auto-generated method stub

		logger.info("In Test Login Method ");
		String loginTitle = null;
		
		
	}*/
	
		
 
	public String setUserName(String strUserName){

    //driver.FindElement(user99GuruName).sendKeys(GlobalDataStore.UserName);
		logger.info("START: setUserName");		
		driver.sendKeys(driver.FindElement(user99GuruName), strUserName);				
		logger.info("END: setUserName");
		return strUserName;
		
	}
	
//Set password in password textbox

	public String setPassword(String strPassword){

    // driver.FindElement(password99Guru).sendKeys(GlobalDataStore.Password);
	driver.sendKeys(driver.FindElement(password99Guru), strPassword);
	return strPassword;
	}

//Click on login button

	public void clickLogin(){

        //driver.FindElement(login).click();
        driver.clickElement(driver.FindElement(login));
        
	}

	public  void setLogCategory(String LogFile) {

    LogCategory = LogFile;

    logger = Logger.getLogger(LogCategory);//

	}

}


	
