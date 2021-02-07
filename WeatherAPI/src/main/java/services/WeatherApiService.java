package services;

import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.weatherdb.CityInfo;
import model.weatherdb.IpAddressLocation;
import model.weatherdb.WeatherInfo;

public class WeatherApiService {
	
	private String units;
	
	private static String apiKey = "60278b3d9ec4bbe903d10e5b6aa3e777";
	
	public WeatherApiService(String units) {
		this.units = units;
	}

	public WeatherInfo GetWeather(double lat, double lon) {
		DefaultHttpClient httpClient = new DefaultHttpClient();
		
		if (lat > 90 || lat <-90 || lon >180 || lon < -180) {
			return null;
		}

		try {
			HttpGet getRequest = new HttpGet("http://api.openweathermap.org/data/2.5/onecall?lat=" + lat
					+ "&lon=" + lon + "&exclude=minutely&appid="+apiKey+"&units="+units);
			getRequest.addHeader("accept", "application/json");

			HttpResponse response = httpClient.execute(getRequest);

			WeatherInfo c = null;

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			c = mapper.readValue(response.getEntity().getContent(), WeatherInfo.class);
            return c;
			

		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new WeatherInfo();
	}
		
	public IpAddressLocation GetLocationFromIp() {
		DefaultHttpClient httpClient = new DefaultHttpClient();

		try {
			HttpGet getRequest = new HttpGet("https://ipapi.co/json/");
			getRequest.addHeader("accept", "application/json");

			HttpResponse response = httpClient.execute(getRequest);

			IpAddressLocation c = null;

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			c = mapper.readValue(response.getEntity().getContent(), IpAddressLocation.class);
            return c;			

		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new IpAddressLocation();
	}
	
	public CityInfo[] GetCityInfo(String cityName) {
		DefaultHttpClient httpClient = new DefaultHttpClient();
		CityInfo[] c = null;
		cityName = cityName.replace(" ", "+");
		try {
			String x = "http://api.openweathermap.org/geo/1.0/direct?q="+cityName+"&limit=1&appid="+apiKey;
			HttpGet getRequest = new HttpGet("http://api.openweathermap.org/geo/1.0/direct?q="+cityName+"&limit=1&appid="+apiKey);
			getRequest.addHeader("accept", "application/json");

			HttpResponse response = httpClient.execute(getRequest);


			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			c = mapper.readValue(response.getEntity().getContent(), CityInfo[].class);
            return c;			

		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return c;
	}
}
