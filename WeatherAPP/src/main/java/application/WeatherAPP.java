package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import java.util.Scanner;

import model.weatherdb.CityInfo;
import model.weatherdb.IpAddressLocation;
import model.weatherdb.WeatherInfo;
import services.WeatherApiService;

public class WeatherAPP {

	static ArrayList<String> cities;

	static String unitSystem = null;

	public static void main(String[] args) {
		// create a new scanner which reads from the standard input (given from the
		// keyboard)
		Scanner s = new Scanner(System.in);
		cities = getCitiesListFromFile();
		// welcome message for user
		System.out.println("****Weather APP****");
		System.out.println("Hello user!");

		unitSystem = unitsSelection(s);

		while (true) {
			citySelection(s);
		}

	}

	private static ArrayList<String> getCitiesListFromFile() {
		File file = new File("citiesList.txt"); // create  or open a text file
		BufferedReader reader;
		// create new arrayList of cities
		ArrayList<String> cities = new ArrayList<String>();

		try {
			// read the text file
			reader = new BufferedReader(new FileReader("citiesList.txt"));
			String line = reader.readLine();
			while (line != null) {

				cities.add(line); // add cities to file

				line = reader.readLine(); // read each line of file
			}
			reader.close();
			// Error message: file not found
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return cities;
	}

	// save cities list to file
	private static void saveListToFile(ArrayList<String> cities) {
		try {
			// write to text file
			BufferedWriter writer = new BufferedWriter(new FileWriter("citiesList.txt"));
			for (int i = 0; i < cities.size(); i++) {
				writer.write(cities.get(i));
				writer.newLine();
			}
			writer.close();
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}

	private static String unitsSelection(Scanner s) {

		// choose in which unit system would you like to view the temperatures
		System.out.println("In which unit system would you like to view the temperatures?");
		System.out.println("1. Metric system (Celsius)");
		System.out.println("2. Imperial system (Farenheit)");

		String unitSystem = null;
		try {
			int unitsUserSelection = s.nextInt();

			// error message if user put something different than 1 for metric or 2 for
			// imperial
			while (unitsUserSelection != 1 && unitsUserSelection != 2) {
				 System.out.println("Please select from the availalble options");
				unitsUserSelection = s.nextInt();
			}
			if (unitsUserSelection == 1) {
				unitSystem = "metric";
			} else {
				unitSystem = "imperial";
			}
			// error message if user put string instead of integer
		} catch (Exception e) {
			System.out.println("WRONG SELECTION, APPLICATION MUST END");
			System.exit(1);
		}

		return unitSystem;
	}

	// find the temperature for you city with three different ways
	private static void citySelection(Scanner s) {
		System.out.println("");
		System.out.println("Select an option:");
		System.out.println("1. Get weather in your location"); // find weather from user's IP address
		System.out.println("2. Manage cities"); // user manage his/her favorite list
		System.out.println("3. Type your city "); // find weather for cities he/she types
		System.out.println("4. Exit application"); // exit application
		try {
			int selection = s.nextInt();

			while (selection != 1 && selection != 2 && selection != 3 && selection != 4) {
				System.out.println("Please select from the available options");
				selection = s.nextInt();
			}
		
		switch (selection) {
		case 1:
			PrintCurrentWeatherFromIp();
			break;
		case 2:
			ManageCities(s);
			break;
		case 3:
			GetFromTypedCities(s);
			break;
		case 4:
			System.out.println("Thank you for using WeatherAPP!");
			saveListToFile(cities);
			System.exit(0); // successful exit application
			break;
		default:
			break;
		}
		} catch (Exception e) {
			System.out.println("WRONG SELECTION, APPLICATION MUST END");
			System.exit(1);
		}
	}

	// manage cities selection helps you add or delete a city in your list and learn
	// about the weather in this city
	private static void ManageCities(Scanner s) {
		int selection = 0;

		while (selection != 4) {
			System.out.println("Select an option:");
			System.out.println("1. Add city"); // add a city in your list
			System.out.println("2. Delete city"); // delete a city from your list
			System.out.println("3. View wheather in a favorite city"); // learn about weather in a city from your list
			System.out.println("4. Back"); // go back to menu

			selection = s.nextInt();
			while (selection != 1 && selection != 2 && selection != 3 && selection != 4) {

				// error message (must select from the available options)
				System.out.println("Please select from the available options");
				selection = s.nextInt();

			}

			switch (selection) {
			case 1:
				System.out.println("Type your city name"); // type your city name
				s.nextLine();
				String cityAdd = s.nextLine();
				cities.add(cityAdd); // add a city name
				System.out.println("City added"); // city name added
				break;
			case 2:
				System.out.println("These are your favorites: ");
				System.out.println(String.join(", ", cities));
				System.out.println("Type your city name to delete");
				s.nextLine();
				String cityDel = s.nextLine();
				cities.remove(cityDel); // delete a city name
				System.out.println("City removed"); // city name deleted
				break;
			case 3:
				System.out.println("These are your favorites. Type the city name: ");
				System.out.println(String.join(", ", cities));
				s.nextLine();
				String cityName = s.nextLine();
				PrintWeatherFromCity(cityName);
				break;
			case 4:
				return;
			default:
				break;
			}
		}
	}

	// find current temperatures from user's IP
	private static void PrintCurrentWeatherFromIp() {
		WeatherApiService weatherService = new WeatherApiService(unitSystem);
		IpAddressLocation locationFromIp = weatherService.GetLocationFromIp();
		System.out.println("You are connected from " + locationFromIp.getCity() + ", " + locationFromIp.getCountry());
		WeatherInfo c = weatherService.GetWeather(locationFromIp.getLatitude(), locationFromIp.getLongitude());

		printCurrentTemp(c);
	}

	// find current, hourly(for 48 hours) and daily(for 5 days) temperature from
	// user's list
	private static void PrintWeatherFromCity(String cityName) {
		WeatherApiService weatherService = new WeatherApiService(unitSystem);
		CityInfo[] cityInfo = weatherService.GetCityInfo(cityName);
		if (cityInfo.length == 0) {
			System.out.println("Cannot find weather for selected city");
			return;
		}
		WeatherInfo c = weatherService.GetWeather(cityInfo[0].getLat(), cityInfo[0].getLon());

		System.out.println("Weather info for " + cityName);
		printCurrentTemp(c);
		printDailyTemperatures(c);
		printHourlyTemperatures(c);
	}
    //find current, daily and hourly temperature if user type a city
	private static void GetFromTypedCities(Scanner s) {
		System.out.println("Please insert city name");
		WeatherApiService weatherService = new WeatherApiService(unitSystem);
		s.nextLine();
		String cityName = s.nextLine();
		CityInfo[] cityInfo = weatherService.GetCityInfo(cityName);

		while (cityInfo != null && cityInfo.length < 1) {
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
		double temp = c.getCurrent().getTemp(); // current temp
		long humidity = c.getCurrent().getHumidity(); // humidity rate
		String description = c.getCurrent().getWeather().get(0).getDescription(); // weather conditions
		double windSpeed = c.getCurrent().getWindSpeed(); // wind spead
		long windDeg = c.getCurrent().getWindDeg(); // wind direction
		long Dt = c.getCurrent().getDt(); // time of the forecasted data

		// print current temperature
		System.out.println("  Current temp:" + temp);
		System.out.println("  Humidity rate:" + humidity);
		System.out.println("  Description:" + description);
		System.out.println("  Wind speed:" + windSpeed);
		System.out.println("  Wind direction:" + windDeg);
		System.out.println("  Time of the forecasted data:" + new Date(Dt * 1000));
	}

	private static void printDailyTemperatures(WeatherInfo c) {
		// Daily temperature for cities from user's list.
		for (int i = 0; i < 5; i++) // get daily temp only for five days instead of sixteen that api send to us
		{
			double day = c.getDaily().get(i).getTemp().getDay(); // daily temp
			double min = c.getDaily().get(i).getTemp().getMin(); // min temp
			Date date = new Date(c.getDaily().get(i).getDt() * 1000); // format time
			double max = c.getDaily().get(i).getTemp().getMax(); // max temp
			String description = c.getDaily().get(i).getWeather().get(0).getDescription(); // weather conditions
			double pop = c.getDaily().get(i).getPop(); // possibility of rain
			long humidity = c.getDaily().get(i).getHumidity(); // humidity rate
			double windSpeed = c.getDaily().get(i).getWindSpeed(); // wind speed
			long windDeg = c.getDaily().get(i).getWindDeg(); // wind direction
			long Dt = c.getDaily().get(i).getDt(); // time of the forecasted data

			DateFormat df = new SimpleDateFormat("dd/MM/yyyy"); // format date
			// print daily temperature
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
			System.out.println("  Time of the forecasted data:" + new Date(Dt * 1000));
		}
	}

	private static void printHourlyTemperatures(WeatherInfo c) {
		// Hourly temperature for cities from user's list.
		double sum = 0;
		for (int i = 0; i < 47; i++) // get hourly temp for 2 days(48 hours) where api send to us
		{
			double temp = c.getHourly().get(i).getTemp(); // hourly temp
			sum += temp;
			Date date = new Date(c.getHourly().get(i).getDt() * 1000); // format time
			String description = c.getHourly().get(i).getWeather().get(0).getDescription(); // weather conditions
			long Dt = c.getHourly().get(i).getDt(); // time of the forecasted data

			DateFormat df = new SimpleDateFormat("HH:mm"); // format time
			// print hourly temperature
			System.out.println("");
			System.out.println("Temp for " + df.format(date));
			System.out.println("  Temp:" + temp);
			System.out.println("  Description:" + description);
			System.out.println("  Time of the forecasted data:" + new Date(Dt * 1000));
		}
		// print average temperature
		System.out.println("Average temperature for the next 48 hours:" + sum / 48);
	}
}
