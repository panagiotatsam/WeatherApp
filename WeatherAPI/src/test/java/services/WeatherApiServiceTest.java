package services;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import model.weatherdb.CityInfo;
import model.weatherdb.IpAddressLocation;
import model.weatherdb.WeatherInfo;

public class WeatherApiServiceTest {
	
	
           //boundaries of latitude and longitude
	@Test  //check that city with lat=38 & lon=22 in unitSystem=metric exists and API will give us results for daily temperature
	public void GetWeatherAPI() {
		WeatherApiService weatherService = new WeatherApiService("metric");
		WeatherInfo c = weatherService.GetWeather(38, 22);
		Assert.assertFalse(c.getDaily().isEmpty());
	}
	       //boundaries of latitude and longitude
	@Test  //check that city with lat=91 and lon=22 in unitSystem=metric does not exists and API will not give us anything
	public void GetWeatherAPILatInvalid() {
		WeatherApiService weatherService = new WeatherApiService("metric");
		WeatherInfo c = weatherService.GetWeather(91, 22);
		Assert.assertTrue(c == null);
	}
	
	
	@Test //check that Athens city in unitSystem=metric exists and API will give us results for Athens
	public void GetLocationExists() {
		WeatherApiService weatherService = new WeatherApiService("metric");
		CityInfo[] c = weatherService.GetCityInfo("Athens");
		Assert.assertTrue(c.length >0);
	}
	
	@Test //check that dsfdsgdhdgnfg city in unitSystem=metric does not exists and API will not give us anything
	public void GetLocationNotExists() {
		WeatherApiService weatherService = new WeatherApiService("metric");
		CityInfo[] c = weatherService.GetCityInfo("dsfdsgdhdgnfg");
		Assert.assertTrue(c.length == 0);
	}
}
