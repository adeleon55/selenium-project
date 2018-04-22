package com.guru99.framework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface Guru99WebDriver {
	
//NOTE:  All methods declared here do not have any body, thus the absence of the curly backets.
	
	//declaration of init method.
	void init(String Browser);

	//declaration of navigateTo method.
	Boolean navigateTo(String urlString);
	
	//declaration of FindElement method.
	public WebElement FindElement(By element);
	
	//declare 
	public void quitDriver();
	
	public void clickElement(WebElement element);
	
	public void sendKeys(By element, String strUserName);
	
	public void sendKeys(WebElement webElement, String strUserName);
	
	public void clickSeleniumDropDownOnPage();
	
	public List<WebElement> findElements(By checksibling);
	
}
