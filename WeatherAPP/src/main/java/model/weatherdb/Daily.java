
package model.weatherdb;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Daily {

    private long dt;
    private long sunrise;
    private long sunset;
    private Temp temp;
    private FeelsLike feelsLike;
    private long pressure;
    private long humidity;
    private double dewPoint;
    private double windSpeed;
    private long windDeg;
    private List<Weather__> weather = null;
    private long clouds;
    private long pop;
    private long uvi;
    private double rain;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Daily() {
    }

    /**
     * 
     * @param rain
     * @param sunrise
     * @param temp
     * @param uvi
     * @param pressure
     * @param clouds
     * @param dewPoint
     * @param dt
     * @param feelsLike
     * @param windDeg
     * @param pop
     * @param sunset
     * @param weather
     * @param humidity
     * @param windSpeed
     */
    public Daily(long dt, long sunrise, long sunset, Temp temp, FeelsLike feelsLike, long pressure, long humidity, double dewPoint, double windSpeed, long windDeg, List<Weather__> weather, long clouds, long pop, long uvi, double rain) {
        super();
        this.dt = dt;
        this.sunrise = sunrise;
        this.sunset = sunset;
        this.temp = temp;
        this.feelsLike = feelsLike;
        this.pressure = pressure;
        this.humidity = humidity;
        this.dewPoint = dewPoint;
        this.windSpeed = windSpeed;
        this.windDeg = windDeg;
        this.weather = weather;
        this.clouds = clouds;
        this.pop = pop;
        this.uvi = uvi;
        this.rain = rain;
    }

    public long getDt() {
        return dt;
    }

    public void setDt(long dt) {
        this.dt = dt;
    }

    public long getSunrise() {
        return sunrise;
    }

    public void setSunrise(long sunrise) {
        this.sunrise = sunrise;
    }

    public long getSunset() {
        return sunset;
    }

    public void setSunset(long sunset) {
        this.sunset = sunset;
    }

    public Temp getTemp() {
        return temp;
    }

    public void setTemp(Temp temp) {
        this.temp = temp;
    }

    public FeelsLike getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(FeelsLike feelsLike) {
        this.feelsLike = feelsLike;
    }

    public long getPressure() {
        return pressure;
    }

    public void setPressure(long pressure) {
        this.pressure = pressure;
    }

    public long getHumidity() {
        return humidity;
    }

    public void setHumidity(long humidity) {
        this.humidity = humidity;
    }

    public double getDewPoint() {
        return dewPoint;
    }

    public void setDewPoint(double dewPoint) {
        this.dewPoint = dewPoint;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public long getWindDeg() {
        return windDeg;
    }

    public void setWindDeg(long windDeg) {
        this.windDeg = windDeg;
    }

    public List<Weather__> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather__> weather) {
        this.weather = weather;
    }

    public long getClouds() {
        return clouds;
    }

    public void setClouds(long clouds) {
        this.clouds = clouds;
    }

    public long getPop() {
        return pop;
    }

    public void setPop(long pop) {
        this.pop = pop;
    }

    public long getUvi() {
        return uvi;
    }

    public void setUvi(long uvi) {
        this.uvi = uvi;
    }

    public double getRain() {
        return rain;
    }

    public void setRain(double rain) {
        this.rain = rain;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

	@Override
	public String toString() {
		return "Daily [dt=" + dt + ", sunrise=" + sunrise + ", sunset=" + sunset + ", temp=" + temp + ", feelsLike="
				+ feelsLike + ", pressure=" + pressure + ", humidity=" + humidity + ", dewPoint=" + dewPoint
				+ ", windSpeed=" + windSpeed + ", windDeg=" + windDeg + ", weather=" + weather + ", clouds=" + clouds
				+ ", pop=" + pop + ", uvi=" + uvi + ", rain=" + rain + ", additionalProperties=" + additionalProperties
				+ "]";
	}

    

}
