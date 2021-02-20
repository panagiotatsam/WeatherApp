package services;

import java.io.IOException;
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
	//personal apikey
	private static String apiKey = "60278b3d9ec4bbe903d10e5b6aa3e777";
	
	public WeatherApiService(String units) {
		this.units = units;
	}
    
	//One call API for current, daily and hourly temperatures
	public WeatherInfo GetWeather(double lat, double lon) {
		//create a pre-configured HTTPClient
		DefaultHttpClient httpClient = new DefaultHttpClient();
		
		//boundaries of latitude and longitude
		if (lat > 90 || lat <-90 || lon >180 || lon < -180) {
			return null;
		}

		try {
			//create a HTTPGet object (method get) with parameter(URI)
			HttpGet getRequest = new HttpGet("http://api.openweathermap.org/data/2.5/onecall?lat=" + lat
					+ "&lon=" + lon + "&exclude=minutely&appid="+apiKey+"&units="+units);
			//API MEDIA Type of HTTP accept with <<application/json>>
			getRequest.addHeader("accept", "application/json");
            //get the request with execute method and save it in response
			HttpResponse response = httpClient.execute(getRequest);

			WeatherInfo c = null;

			ObjectMapper mapper = new ObjectMapper();
            //deserialize json response and save into a variable c
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			c = mapper.readValue(response.getEntity().getContent(), WeatherInfo.class);
            return c;
			
         //JsonMappingException when the JSON doesn't match exactly what Jackson is looking for
		} catch (JsonMappingException e) {
			e.printStackTrace();
	    //ClientProtocolException when the server could not understand the request due to invalid syntax.
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		// IOException when URI is not correct
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new WeatherInfo();
	}
		
	//API for finding user's IP address 
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
	
	//API for finding lat and lon by giving city name
	public CityInfo[] GetCityInfo(String cityName) {
		DefaultHttpClient httpClient = new DefaultHttpClient();
		CityInfo[] c = null;
		cityName = cityName.replace(" ", "+");
		try {
			
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
