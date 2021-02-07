package services;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import model.weatherdb.CityInfo;
import model.weatherdb.IpAddressLocation;
import model.weatherdb.WeatherInfo;

public class WeatherApiServiceTest {

	@Test
	public void GetWeatherAPI() {
		WeatherApiService weatherService = new WeatherApiService("metric");
		WeatherInfo c = weatherService.GetWeather(38, 22);
		Assert.assertFalse(c.getDaily().isEmpty());
	}
	
	@Test
	public void GetWeatherAPILatInvalid() {
		WeatherApiService weatherService = new WeatherApiService("metric");
		WeatherInfo c = weatherService.GetWeather(90, 22);
		Assert.assertFalse(c == null);
	}
	
	
	@Test
	public void GetLocationExists() {
		WeatherApiService weatherService = new WeatherApiService("metric");
		CityInfo[] c = weatherService.GetCityInfo("Athens");
		Assert.assertTrue(c.length >0);
	}
	
	@Test
	public void GetLocationNotExists() {
		WeatherApiService weatherService = new WeatherApiService("metric");
		CityInfo[] c = weatherService.GetCityInfo("dsfdsgdhdgnfg");
		Assert.assertTrue(c.length == 0);
	}
}
