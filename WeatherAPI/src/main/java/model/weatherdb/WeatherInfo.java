
package model.weatherdb;

import java.util.List;


public class WeatherInfo {

    private double lat;
    private double lon;
    private String timezone;
    private long timezoneOffset;
    private Current current;
    private List<Hourly> hourly = null;
    private List<Daily> daily = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public WeatherInfo() {
    }

    /**
     * 
     * @param current
     * @param timezoneOffset
     * @param timezone
     * @param daily
     * @param lon
     * @param hourly
     * @param lat
     */
    public WeatherInfo(double lat, double lon, String timezone, long timezoneOffset, Current current, List<Hourly> hourly, List<Daily> daily) {
        super();
        this.lat = lat;
        this.lon = lon;
        this.timezone = timezone;
        this.timezoneOffset = timezoneOffset;
        this.current = current;
        this.hourly = hourly;
        this.daily = daily;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public long getTimezoneOffset() {
        return timezoneOffset;
    }

    public void setTimezoneOffset(long timezoneOffset) {
        this.timezoneOffset = timezoneOffset;
    }

    public Current getCurrent() {
        return current;
    }

    public void setCurrent(Current current) {
        this.current = current;
    }

    public List<Hourly> getHourly() {
        return hourly;
    }

    public void setHourly(List<Hourly> hourly) {
        this.hourly = hourly;
    }

    public List<Daily> getDaily() {
        return daily;
    }

    public void setDaily(List<Daily> daily) {
        this.daily = daily;
    }

    @Override
	public String toString() {
		return "WeatherInfo [lat=" + lat + ", lon=" + lon + ", timezone=" + timezone + ", timezoneOffset="
				+ timezoneOffset + ", current=" + current + ", hourly=" + hourly + ", daily=" + daily + "]";
	}

}
