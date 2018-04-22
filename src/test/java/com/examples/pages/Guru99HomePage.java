package com.examples.pages;

import com.examples.config.GlobalDataStore;
import com.guru99.framework.Guru99WebDriverImpl;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class Guru99HomePage {
	
	GlobalDataStore gds = new GlobalDataStore();
	WebDriver driverInstance;
	public static String LogCategory;
	public static Logger logger;
	
	Guru99WebDriverImpl driver;
	

	By homePageUserName = By.xpath("//h2[@class='barone']");
	By generateAccess = By.xpath("//h4[@class='barone']");
	By checkSeleniumDropDown=By.xpath("ul[@class='nav navbar-nav']/li[1]/a[1]");
	By checkSiblings = By.xpath("//ul[@class='nav navbar-nav']//li[1]/ul/li[1]/following-sibling::li");
	By checkLinkFromDropdown = By.xpath("//a[@href='../../test/table.html']");
	
	
	//By Password=By.xpath("//td[contains(), 'UserID')]//parent::tr/flollow"
	//By Login = By.xpath("//td[contains(text(),
	
	public void setWebDriver(Guru99WebDriverImpl webDriver) {
		
		this.driver = webDriver;		
			
	}

	public String getHomePageDashboardUserName(){
    	logger.info("START: getHomePageDashboardUserName");
      System.out.println("coming here getHomePageDashboardUserName ");    
      //System.out.println(" The Text "+driver.FindElement(homePageUserName).getText());
      logger.info("END: getHomePageDashboardUserName");
         return driver.FindElement(homePageUserName).getText();
     }
	
	public String getGenerateAccess(){
    	logger.info("START: getGenerateAccess");
      System.out.println("Steps to Generate Access ");    
      //System.out.println(" The Text "+driver.FindElement(homePageUserName).getText());
      logger.info("END: getGenerateAccess");
         return driver.FindElement(generateAccess).getText();
	}
	     
         
	public  void setLogCategory(String LogFile) {

        LogCategory = LogFile;

        logger = Logger.getLogger(LogCategory);//

	}
	
	/*public void getDropdownList() {
	WebElement dropDown = driver.findElement(dropDownName);
	List<WebElement> options = dropDown.findElements(dropDownMenu);
		int itemCount = options.row.size();
		System.out.println("Item Count: " +itemCount);
	       
	    for(WebElement option : options)
	    {
	        System.out.println(option.  getText());
	 
	    }  
	}*/
	
	public int getCountOfAllLinks() {
	WebElement element = driver.FindElement(checkSeleniumDropDown);
	
		driver.clickElement(element);
		List<WebElement>elements = driver.findElements(checkSiblings);
		System.out.println("The elements Size " +elements.size());
		return elements.size();
	}
	
	public void checkLinkFromDropdown() {
	WebElement element = driver.FindElement(checkLinkFromDropdown);
		
		driver.clickElement(element);
	}
	
	public void clickSeleniumSelectElementFromDropDownOnPage(String Text){
		   String Path= 	"//ul[@class='nav navbar-nav']/li[1]/ul//a[contains(text()," + "'"+Text+ "'" +")]";
		   By checkText=By.xpath(Path);
		 	   WebElement element= driver.FindElement(checkText);
		 		   driver.clickElement(element);
		 	   }

	public void clickSeleniumDropDownOnPage() {
		// TODO Auto-generated method stub
		
	}
}
