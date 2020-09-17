package com.ndtv.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.ndtv.pages.WeatherPage;

/**
 * 
 * @author Sagar
 *
 */
public class WeatherTest extends BaseTest {

	String city = "Bengaluru";
	@Test
	public void getDetailsFromWeather() throws InterruptedException {
		WeatherPage weatherPage = new WeatherPage(driver);
		weatherPage.enterPinYourCity(city);
		weatherPage.clickOnCityMap();
		String weatherDetails = weatherPage.getCityWeatherDetails();
		System.out.println("Weather Details ::" + weatherDetails);
		
		Assert.assertTrue(weatherDetails.contains(city), city+" :: City is not listed in the Map" );
		Assert.assertTrue(!weatherDetails.isEmpty(), "Weather details is not showing up any details");
		
		System.out.println("***************Validating it from API*******************");
		String jsonString =  weatherPage.getCityWeatherDetailsFromAPI();
		Assert.assertEquals(jsonString.contains("Bengaluru"),true);
	    Assert.assertEquals(jsonString.contains("temp"),true);
		
		
	}

}
