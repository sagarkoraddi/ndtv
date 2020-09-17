package com.ndtv.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * 
 * @author Sagar
 * This class will store all the locators method of WeatherPage.
 */
public class WeatherPage extends BasePage{
	
	//page locators;
	private By pinCitySearchBox = By.xpath("//input[@id='searchBox']");
	private By bengalurucityDropDown= By.xpath("//body//div[18]");
//	private By bengalurucityDropDown= By.xpath("//label[contains(text(),'Bengaluru')]");
	private By bengaluruOnMap= By.xpath("//div[contains(text(),'Bengaluru')]");
	private By weatherDetails= By.xpath("//div[@class='leaflet-popup-content-wrapper']");

	/**
	 * 
	 * @param driver
	 */
	public WeatherPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * 
	 * @return PinCity
	 */
	public WebElement getPinCitySearchBox() {		
		return getElement(pinCitySearchBox);
	}

	/**
	 * 
	 * @return Bengaluru City
	 */
	public WebElement getBengalurucityDropDown() {
		return getElement(bengalurucityDropDown);
	}

	/**
	 * 
	 * @return Bengaluru
	 */
	public WebElement getBengaluruOnMap() {
		return getElement(bengaluruOnMap);
	}

	/**
	 * 
	 * @return weather details
	 */
	public WebElement getWeatherDetails() {
		return getElement(weatherDetails);
	}
	
	/**
	 * Enter city in the Pin your city field.
	 * @param city
	 */
	public void enterPinYourCity(String city) {
		
		WebElement cityName= getElement(pinCitySearchBox);
		cityName.click();
		cityName.sendKeys(city);
	}

	/**
	 * Click on first filtered city from the dropdown.
	 */
	public void clickOnCityDropdownCheckBox() {
		driver.findElement(bengalurucityDropDown).click();
	}
	
	/**
	 * Click on City map.
	 */
	public void clickOnCityMap() {
		driver.findElement(bengaluruOnMap).click();
	}
	
	
	/**
	 * Get weather details from the Map.
	 * @return
	 * @throws InterruptedException 
	 */
	public String getCityWeatherDetails() throws InterruptedException {
		Thread.sleep(3000);
		String weatherDet= driver.findElement(weatherDetails).getText();	
		return weatherDet;
	}
	
	public String getCityWeatherDetailsFromAPI() {

		 RestAssured.baseURI = "http://api.openweathermap.org/data/2.5/";
		 
		 RequestSpecification httpRequest = RestAssured.given();

		 Response response = httpRequest.queryParam("q","Bengaluru")
	                           .queryParam("appid", "7fe67bf08c80ded756e598d6f8fedaea")
	                           .get("/weather");
		 String jsonString = response.asString();
		 String temp= response.jsonPath().get("temp");
		
		 System.out.println(response.asString());
		 System.out.println(temp); 
		return jsonString;

	}
	
	public String getCityWeatherDetailsFromAPIWithCustomizeParameters() {

		 RestAssured.baseURI = "http://api.openweathermap.org/data/2.5/";
		 
		 RequestSpecification httpRequest = RestAssured.given();

		 Response response = httpRequest.queryParam("q","Bengaluru")
	                           .queryParam("appid", "7fe67bf08c80ded756e598d6f8fedaea")
	                           .get("/weather");
		 String jsonString = response.asString();
		 System.out.println(response.asString());
		 System.out.println(response.getStatusCode()); 
		return jsonString;

	}

}
