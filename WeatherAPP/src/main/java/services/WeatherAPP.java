package services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.weatherdb.CityInfo;
import model.weatherdb.WeatherClientIPAddress;
import model.weatherdb.WeatherInfo;
import model.weatherdb.Weather__;
import services.WeatherApiServiceTODELETE;

public class WeatherAPP {

	// List of user's cities.
	static String[] cities = new String[] { "Athens", "London", "Barcelona", "Paris", "Berlin", "Krakow", "Rome",
			"Budapest", "Lisbon", "Amsterdam" };
	static double[] lat = new double[] { 37.983810, 51.509865, 41.390205, 48.864716, 52.520008, 50.049683, 41.902782,
			47.497913, 38.736946, 52.377956 };
	static double[] lon = new double[] { 23.727539, -0.118092, 2.154007, 2.349014, 13.404954, 19.944544, 12.496366,
			19.040236, -9.142685, 4.897070 };
	
	static String unitSystem = null;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("****Weather APP****");
		System.out.println("Hello user!");

		unitSystem = unitsSelection(s);

		while (true) {
			citySelection(s);			
		}
	}

	private static String unitsSelection(Scanner s) {

		System.out.println("In which unit system would you like to view the temperatures?");
		System.out.println("1. Metric system (Celsius)");
		System.out.println("2. Imperial system (Farenheit)");

		String unitSystem = null;
		try {
			int unitsUserSelection = s.nextInt();

			while (unitsUserSelection != 1 && unitsUserSelection != 2) {
				System.out.println("Please select from the avaialble options");
				unitsUserSelection = s.nextInt();
			}
			if (unitsUserSelection == 1) {
				unitSystem = "metric";
			} else {
				unitSystem = "imperial";
			}
		} catch (Exception e) {
			System.out.println("WRONG SELECTION, APPLICATION MUST END");
			System.exit(1);
		}

		return unitSystem;
	}

	private static void citySelection(Scanner s) {
		System.out.println("");
		System.out.println("Select an option:");
		System.out.println("1. Get weather in your location");
		System.out.println("2. Select from the predifined cities");
		System.out.println("3. Type your city ;)");
		System.out.println("4. Exit application");

		int selection = s.nextInt();
		while (selection != 1 && selection != 2 && selection != 3 && selection != 4) {
			System.out.println("Please select from the avaialble options");
			selection = s.nextInt();
		}
		switch (selection) {
		case 1:
			PrintCurrentWeatherFromIp();
			break;
		case 2:
			GetFromPredifiendCities(s);
			break;
		case 3:
			GetFromTypedCities(s);
			break;			
		case 4:
			System.out.println("Thank you for using WeatherAPP!");
			System.exit(0);
			break;
		default:
			break;
		}
	}

	private static void PrintCurrentWeatherFromIp() {
		WeatherApiServiceTODELETE weatherService = new WeatherApiServiceTODELETE(unitSystem);
		WeatherClientIPAddress locationFromIp = weatherService.GetLocationFromIp();
		System.out.println("You are connected from "+ locationFromIp.getCity() + ", " +locationFromIp.getCountry());
		WeatherInfo c = weatherService.GetWeather(locationFromIp.getLatitude(), locationFromIp.getLongitude());
		
		printCurrentTemp(c);
	}

	private static void GetFromPredifiendCities(Scanner s) {
		System.out.println("Please insert city from the list: ");
		for (int index = 0; index < cities.length; index++) {
			System.out.println(index + ". " + cities[index]);
		}

		int cityIndex = s.nextInt();

		while (cityIndex > cities.length) {
			System.out.println("Please select from the numbers");
			cityIndex = s.nextInt();
		}

		WeatherApiServiceTODELETE weatherService = new WeatherApiServiceTODELETE(unitSystem);

		WeatherInfo c = weatherService.GetWeather(lat[cityIndex], lon[cityIndex]);

		System.out.println("Weather info for " + cities[cityIndex]);
		printCurrentTemp(c);
		printDailyTemperatures(c);
		printHourlyTemperatures(c);
	}

	private static void GetFromTypedCities(Scanner s) {
		System.out.println("Please insert city name");
		WeatherApiServiceTODELETE weatherService = new WeatherApiServiceTODELETE(unitSystem);
		s.nextLine();
		String cityName = s.nextLine();
		CityInfo[] cityInfo = weatherService.GetCityInfo(cityName);	
		
		while (cityInfo != null && cityInfo.length < 1 ) {	
			System.out.println("No city with given name found, please type another city");
			cityName = s.nextLine();
			cityInfo = weatherService.GetCityInfo(cityName);			
		}
		
		WeatherInfo c = weatherService.GetWeather(cityInfo[0].getLat(), cityInfo[0].getLon());	
		
		System.out.println("Weather info for " + cityInfo[0].getName() + ", " + cityInfo[0].getCountry());
		printCurrentTemp(c);
		printDailyTemperatures(c);
		printHourlyTemperatures(c);
	}
	
	private static void printCurrentTemp(WeatherInfo c) {
		double temp = c.getCurrent().getTemp();
		long humidity = c.getCurrent().getHumidity();
		String description = c.getCurrent().getWeather().get(0).getDescription();
		double windSpeed = c.getCurrent().getWindSpeed();
		long windDeg = c.getCurrent().getWindDeg();
		long Dt = c.getCurrent().getDt();
		
		System.out.println("  Current temp:" +temp);
		System.out.println("  Humidity rate:" +humidity);
		System.out.println("  Description:" +description);
		System.out.println("  Wind speed:" +windSpeed);
		System.out.println("  Wind direction:" +windDeg);
		System.out.println("  Time of the forecasted data:" + new Date(Dt*1000));
	}
	
	private static void printDailyTemperatures( WeatherInfo c) {
		// Daily temperature for cities from user's list.
		for (int i = 0; i < 5; i++) {
			double day = c.getDaily().get(i).getTemp().getDay();
			double min = c.getDaily().get(i).getTemp().getMin();
			Date date = new Date(c.getDaily().get(i).getDt() * 1000);
			double max = c.getDaily().get(i).getTemp().getMax();
			String description = c.getDaily().get(i).getWeather().get(0).getDescription();
			long pop = c.getDaily().get(i).getPop();
			long humidity = c.getDaily().get(i).getHumidity();
			double windSpeed = c.getDaily().get(i).getWindSpeed();
			long windDeg = c.getDaily().get(i).getWindDeg();
			long Dt = c.getDaily().get(i).getDt();

			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			
			System.out.println("");
			System.out.println("Daily temp for " + df.format(date));
			System.out.println("  Temp:" + day);
			System.out.println("  Min:" + min);
			System.out.println("  Max:" + max);
			System.out.println("  Description:" + description);
			System.out.println("  Posibility of rain:" + pop);
			System.out.println("  Humidity rate:" + humidity);
			System.out.println("  Wind Speed:" + windSpeed);
			System.out.println("  Wind Direction:" + windDeg);
			System.out.println("  Time of the forecasted data:" + new Date(Dt*1000));
		}
	}
	
	private static void printHourlyTemperatures( WeatherInfo c) {
		// Hourly temperature for cities from user's list.	
		double sum = 0;
		for (int i = 0; i < 47; i++) {
			double temp = c.getHourly().get(i).getTemp();
			sum += temp;
			Date date = new Date(c.getHourly().get(i).getDt() * 1000);
			String description = c.getHourly().get(i).getWeather().get(0).getDescription();
			long Dt = c.getHourly().get(i).getDt();
			
			DateFormat df = new SimpleDateFormat("HH:mm");
			
			System.out.println("");
			System.out.println("Temp for " + df.format(date));
			System.out.println("  Temp:" + temp);
			System.out.println("  Description:" + description);
			System.out.println("  Time of the forecasted data:" + new Date(Dt*1000));
		}
		System.out.println("Average temperature for the next 48 hours:" + sum /48);
	}
}
