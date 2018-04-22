package com.examples.pages;


import org.openqa.selenium.WebDriver;

public class Guru99BankHomePage {
	
	WebDriver driver;
	
	public Guru99BankHomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void launchHomePage(String HomePage) {
		driver.get(HomePage);
		driver.manage().window().maximize();
	}
	
	//Get the title of Login Page
	
	public String getLoginTitle() {
		return driver.getTitle();
		
	}
}
