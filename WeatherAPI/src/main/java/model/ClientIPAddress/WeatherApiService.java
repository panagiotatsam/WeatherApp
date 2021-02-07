package model.ClientIPAddress;

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

import model.weatherdb.WeatherInfo;

public class WeatherApiService {
	

	public static WeatherInfo GetWeather(double lat, double lon) {

		DefaultHttpClient httpClient = new DefaultHttpClient();

		try {
			HttpGet getRequest = new HttpGet("http://api.openweathermap.org/data/2.5/onecall?lat=" + lat
					+ "&lon=" + lon + "&exclude=minutely&appid=60278b3d9ec4bbe903d10e5b6aa3e777");
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

}
