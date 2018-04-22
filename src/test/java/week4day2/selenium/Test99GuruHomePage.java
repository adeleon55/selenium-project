package week4day2.selenium;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.examples.config.GlobalDataStore;
import com.examples.pages.FaceBookHomePage;
import com.examples.pages.Guru99HomePage;
import com.examples.pages.Guru99LoginPage;
import com.guru99.framework.Guru99WebDriverFactory;
import com.guru99.framework.Guru99WebDriverImpl;

public class Test99GuruHomePage {
	

final static Logger logger = Logger.getLogger("GURU99_TESTS");

	
	Guru99WebDriverImpl driver;
	GlobalDataStore gds = new GlobalDataStore();
	String BankHomePage;
	Boolean HomePageLaunch=false;
	Guru99HomePage objHomePage;
	Guru99LoginPage objLoginPage;
	
	
	
	@Parameters({ "BrowserName" })
	@BeforeClass
	public void setUp(@Optional("FireFox") String BrowserName) throws MalformedURLException {
    	    logger.info("START: In set-up Method");
    	    GlobalDataStore.setLogCategory("GURU99_TESTS");
    	    gds.initParameter();
    	     //calls the init Method in getWebDriverInstance and gets the WebDriverImpl Object driver..   
        driver = Guru99WebDriverFactory.getWebDriverInstance(BrowserName);       
        BankHomePage=GlobalDataStore.Guru99HomePage;
       HomePageLaunch= driver.navigateTo(BankHomePage);
      // objHomePage= new Guru99HomePage(driver);
        //driver.get("http://demo.guru99.com/V4/");
       objHomePage= new Guru99HomePage();
       objHomePage.setLogCategory("GURU99_TESTS");
       objHomePage.setWebDriver(driver);  
       logger.info("END: In set-up Method");
       objLoginPage = new Guru99LoginPage();
       objLoginPage.setLogCategory("GURU99_TESTS");
       objLoginPage.setWebDriver(driver);  
    }
	
	/* This Test verifies the DashBoard Page...It confirms that Page is launched successfully.
    * 
    */
   @Test
   public void test_Home_Page_DashBoard_UserName(){
   	
   	logger.info("START: test_Home_Page_DashBoard_UserName");
   //	objHomePage.setLogCategory("GURU99_TESTS");
   	
   	  if(HomePageLaunch==true){
   	
           String loginPageTitle =objHomePage.getHomePageDashboardUserName();
           logger.info(" The login Title " +loginPageTitle); 
           Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));
   	  }
   	  logger.info("END: test_Home_Page_DashBoard_UserName");

  // Assert.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mgr123"));

   }
   
   @Test
   public void test_Get_Access(){
   	
   	logger.info("START: test_Get_Access");
   //	objHomePage.setLogCategory("GURU99_TESTS");
   	
   	  if(HomePageLaunch==true){
   	
           String generateAccess=objHomePage.getGenerateAccess();
           logger.info("Step to Generate Access " +generateAccess); 
           Assert.assertTrue(generateAccess.toLowerCase().contains("steps to generate access"));
   	  }
   	  logger.info("END: test_Get_Access");

  // Assert.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mgr123"));

   }
   
   @Test
   public void test_Home_Page_DashBoard_clickSeleniumDropdown_CheckMenu() {
	   
	   if(HomePageLaunch==true) {
		   
		   objHomePage.clickSeleniumDropDownOnPage();
		   objHomePage.clickSeleniumSelectElementFromDropDownOnPage("Flash");
		   String Url=driver.getCurrentUrl();
		   Url=Url.trim();
		   System.out.println(" The url " +Url);
		   String ExpectedUrl="http://demo.guru99.com/test/flash";
		   Assert.assertEquals(Url, ExpectedUrl);
	   }
   }
   
   
   
   @Parameters({ "strUserName" })
   @Test
   public void test_Set_User_Name(String strUserName){
	   
	   System.out.println("The userName " +strUserName);
	   String userName=objLoginPage.setUserName(strUserName);
       logger.info("User Name" +userName); 
	   //Guru99LoginPage userName= new Guru99LoginPage();
	   //userName.setUserName(strUserName);			   
	   System.out.println("Value of userName in Test99GuruHomePage " +userName);
		}
 
   @Parameters({ "strPassword" })
   @Test
   public void test_Set_Password(String strPassword){

	  System.out.println("The userName " +strPassword);
	   String userPassword=objLoginPage.setPassword(strPassword);
	   logger.info("User Password" +userPassword); 
	   System.out.println("Value of userPassword in Test99GuruHomePage " +userPassword);	   
		}
  
   @Test
  public void test_Click_Login(){

      //Guru99LoginPage login= new Guru99LoginPage();
      objLoginPage.clickLogin();
      
	}
   
   
  /* @AfterClass
   public void teardown() { 
   // user logout  
   this.driver.quitDriver();
   }*/
}
