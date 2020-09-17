package com.ndtv.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.ndtv.pages.BasePage;
import com.ndtv.pages.Page;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author Sagar
 *
 */
public class BaseTest {
	
	WebDriver driver;
	public Page page;
	String url = "https://social.ndtv.com/static/Weather/report/";
	
	@BeforeMethod
	@Parameters(value= {"browser"})
	public void setUpTest(String browser) {
		
		if(browser.equals("chrome")) {
			 String exeChromePath = "C:\\drivers\\chromedriver_win32\\chromedriver.exe";
			 System.setProperty("webdriver.chrome.driver", exeChromePath);
			driver = new ChromeDriver();			
		}			
		
		else if(browser.equals("firefox")) {
			String exeFirefoxPath="C:\\drivers\\geckodriver-v0.27.0-win64\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver",exeFirefoxPath);
			driver = new FirefoxDriver();			
		}
		driver.manage().window().maximize();
		driver.get(url);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		page = new BasePage(driver);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
		
	

}
