package week4day2.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.examples.config.GlobalDataStore;

public class FirefoxTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		basicTest();

	}
	
	public static void basicTest() {
		GlobalDataStore gds = new GlobalDataStore();
		gds.initParameter();
		String GecKoDriver=GlobalDataStore.GeckoDriver_MAC;
		String HomePage=GlobalDataStore.HomePage;
		System.out.println("The HomePage " +HomePage);
		System.out.println("The GeckoDriver " +GecKoDriver);
		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver"); //hard coded the path
		System.out.println("webdriver.gecko.drivper " +GecKoDriver); // this is using the properties file
		WebDriver driver = new FirefoxDriver(); //webdriver is an interface
		String baseUrl = "http://facebook.com";
		String expectedTitle = "Facebook - Log In or Sign Up";
		//String baseUrl = "https://training.mulesoft.com";
		//String expectedTitle = "Training home page - MuleSoft Training & Certification";
		String actualTitle = "";
		
		//launch Fire Fox and direct it to the Base URL
		driver.get(baseUrl);
		
		//get the actual value of the title
		actualTitle = driver.getTitle();
		//String actualURL =
		actualTitle=actualTitle.trim();
		System.out.println(" The actual Title:  " +actualTitle);
		
		/*
		 * compare the actual title of the page with the expected one and pring
		 * the result as "Passed" or ""Failed"
		 */
		if (actualTitle.contentEquals(expectedTitle) ) {
			System.out.println("Test Passed");			
		} else {
			System.out.println("Test Failed");
		}
		//close Fire Fox
		//driver.close();
	}

}
