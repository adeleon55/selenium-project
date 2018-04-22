package week4day2.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.examples.config.GlobalDataStore;
import com.examples.pages.FaceBookHomePage;

public class TestHomePage {
		 
		GlobalDataStore gds = new GlobalDataStore();
		String GecKoDriver;
		String ChromeDriver;
		String SafariDriver;
		WebDriver driver=null;
		String HomePage;
		
		FaceBookHomePage FBPage;

		@Parameters({ "BrowserName" })
		@BeforeClass
		public void setUp() {
			String BrowserName = "chrome";
	       
			System.out.println(" The Browser Name "+BrowserName);
			
			gds.initParameter();
			GecKoDriver=GlobalDataStore.GeckoDriver_MAC;
			ChromeDriver=GlobalDataStore.Chrome_Driver_MAC;
			
			HomePage=GlobalDataStore.HomePage;
			System.out.println("The HomePage " +HomePage);
			System.out.println(" The GeckoDriver " +GecKoDriver);
			System.out.println(" The ChromeDriver "+ChromeDriver);
			
			if(BrowserName.equalsIgnoreCase("firefox")){
				System.setProperty("webdriver.gecko.driver", GecKoDriver);
		          driver= new FirefoxDriver();
			}
			
			else if(BrowserName.equalsIgnoreCase("chrome")){
				System.out.println(" The chrome Driver " +GlobalDataStore.Chrome_Driver_MAC);
				System.setProperty("webdriver.chrome.driver", GlobalDataStore.Chrome_Driver_MAC);
					driver= new ChromeDriver();
					ChromeOptions options = new ChromeOptions();
					options.addArguments("disable-infobars");
					options.addArguments("--start-maximized");
					driver = new ChromeDriver(options);
			}
			else if(BrowserName.equalsIgnoreCase("safari")){	
				driver = new SafariDriver();
				driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		
				// driver.navigate().to(HomePage);
			}
					
		}
			@Test
			@Parameters({"sUsername", "sPassword"})
			public void testUserLogin(String sUsername, String sPassword) {
				System.out.println(" The userName " +sUsername);
				System.out.println("The Password " +sPassword);
				FBPage = new FaceBookHomePage(driver);
					FBPage.launchHomePage(HomePage);
					driver.findElement(By.xpath(".//input[@name='uid']")).sendKeys(sUsername);
					driver.findElement(By.id("pass")).sendKeys(sPassword);
					//driver.findElement(By.id("submit")).sendKeys(u_0_2);
					//driver.findElement(By.xpath(".//input[@name='pass']")).sendKeys(sPassword);
					//driver.findElement(By.name("email")).sendKeys(sUsername);
					//driver.findElement(By.name("pass")).sendKeys(sPassword);
				//driver.findElement(By.cssSelector("#email")).sendKeys(sUsername);
					//driver.findElement(By.cssSelector("#pass")).sendKeys(sPassword);
					
					driver.findElement(By.id("loginbutton")).click();
			}
		
			@Test
			  public void testFaceBookTitleOnPageLoad() {
				  
					//String baseUrl = "http://facebook.com";
					String expectedTitle = "Facebook - Log In or Sign Up";
					String actualTitle = "";
					
					FBPage= new FaceBookHomePage(driver);
					FBPage.launchHomePage(HomePage);
				     actualTitle=FBPage.getLoginTitle();
					Assert.assertEquals(actualTitle, expectedTitle);
			  }
			
			@Test
			public void verifyTextforCreateNewAccount() {
				
				String expectedTitle = "Sign Up";
				String actualTitle = "";
				
				FBPage = new FaceBookHomePage(driver);
					FBPage.launchHomePage(HomePage);
					//driver.findElement(By.id("email"));
					WebElement element=driver.findElement(By.xpath("//h2[contains(text(), 'Sign Up')]"));
					System.out.println("The text " +element.getText());
					 actualTitle=element.getText();
					Assert.assertEquals(actualTitle, expectedTitle);
					
			}
			
			@Test
			public void verifyTextforConnectWithFriends() {
				
				String expectedTitle = "Connect with friends and the";
				String actualTitle = "";
				
				FBPage = new FaceBookHomePage(driver);
					FBPage.launchHomePage(HomePage);
					//driver.findElement(By.id("email"));
					WebElement element=driver.findElement(By.xpath("//h2[contains(text(), ' Connect with friends and the')]"));
					System.out.println("The text " +element.getText());
					
					 actualTitle=element.getText();
					 
					//Assert.assertEquals(actualTitle, expectedTitle);
					Assert.assertTrue(element.getText().contains("Connect with friends"));
					
			}
			
			@Test
			public void verifyForgotAccountLink()
			{
				FBPage = new FaceBookHomePage(driver);
				FBPage.launchHomePage(HomePage);
				WebElement element = driver.findElement(By.linkText("Forgot account?"));
				element.click();
			     String actualTitle = FBPage.getLoginTitle();
				Assert.assertEquals(actualTitle, "Forgot Password | Can't Log In | Facebook");
			
			}	
			
			@Test
			@Parameters({"sFirstName", "sLastName", "sEmail", "sNewPassword", "sEmailConfirm"})
			public void testUserRegistration(String sFirstName, String sLastName, String sEmail, String sNewPassword, String sEmailConfirm) {
			
					System.out.println("The firstname " +sFirstName);
					System.out.println("The lastname " +sLastName);
					System.out.println("The email " +sEmail);
					System.out.println("The new password " +sNewPassword);
					System.out.println("The re-enter email" +sEmailConfirm);
					FBPage = new FaceBookHomePage(driver);
						FBPage.launchHomePage(HomePage);
						//driver.findElement(By.id("email")).sendKeys(sUsername);
						//driver.findElement(By.id("pass")).sendKeys(sPassword);
						//driver.findElement(By.id("submit")).sendKeys(u_0_2);
						//driver.findElement(By.xpath(".//input[@name='pass']")).sendKeys(sPassword);
						driver.findElement(By.name("firstname")).sendKeys(sFirstName);
						driver.findElement(By.name("lastname")).sendKeys(sLastName);
						driver.findElement(By.name("reg_email__")).sendKeys(sEmail);
						driver.findElement(By.name("reg_passwd__")).sendKeys(sNewPassword);//input[@aria-label='New password']
						driver.findElement(By.name("reg_email_confirmation__")).sendKeys(sEmailConfirm);
						
						//input[@type='radio']
						//WebElement element=driver.findElement(By.xpath("//h2[contains(text(), 'Female')]"))
						//driver.findElement(By.xpath("//label[contains(text(), 'Female')]")).click();
						driver.findElement(By.xpath("//label[contains(text(), 'Male')]")).click();
									
						//Select is for choosing an answer from a dropdown 
						Select sel1 = new Select(driver.findElement(By.xpath(".//*[@id='month']")));
							sel1.selectByVisibleText("Oct");
							Select sel2 = new Select(driver.findElement(By.xpath(".//*[@id='day']")));
							sel2.selectByValue("16");
							Select sel3 = new Select(driver.findElement(By.xpath(".//*[@id='year']")));
							sel3.selectByIndex(64);
							WebDriverWait wait = new WebDriverWait(driver, 10);
							WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(text(), 'Female')]")));
							element.click();
							WebElement signUp = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Create Account')]")));
							signUp.click(); 
						    
							//driver.findElement(By.xpath("//button[contains(text(), 'Sign Up')]")).click();
							
							//wait.until(ExpectedConditions.visibilityOfElementLocated(
							//driver.findElement(By.xpath(".//*[@id='reg_pages_msg']/a")).click();
								//driver.navigate().back();
							//driver.findElement(By.id("u_0_s")).click();
			}
				
			@AfterClass
			  public void afterClass() {
				// close Fire fox
				//driver.close();

			  }

	}

