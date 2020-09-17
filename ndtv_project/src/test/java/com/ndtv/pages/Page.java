package com.ndtv.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public Page(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(this.driver, 15);
		
	}
	
	// abstract methods
	public abstract String getPageTitle();
	
	public abstract WebElement getElement(By locator);
	
	public abstract void waitForElementPresent(By locator);
	
	public abstract void waitForPageTitle(String title);
	 
}
