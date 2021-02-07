
package model.weatherdb;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Current {

    private long dt;
    private long sunrise;
    private long sunset;
    private double temp;
    private double feelsLike;
    private long pressure;
    private long humidity;
    private double dewPoint;
    private double uvi;
    private long clouds;
    private long visibility;
    private double windSpeed;
    private long windDeg;
    private List<Weather> weather = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Current() {
    }

    /**
     * 
     * @param sunrise
     * @param temp
     * @param visibility
     * @param uvi
     * @param pressure
     * @param clouds
     * @param dewPoint
     * @param dt
     * @param feelsLike
     * @param windDeg
     * @param sunset
     * @param weather
     * @param humidity
     * @param windSpeed
     */
    public Current(long dt, long sunrise, long sunset, double temp, double feelsLike, long pressure, long humidity, double dewPoint, double uvi, long clouds, long visibility, double windSpeed, long windDeg, List<Weather> weather) {
        super();
        this.dt = dt;
        this.sunrise = sunrise;
        this.sunset = sunset;
        this.temp = temp;
        this.feelsLike = feelsLike;
        this.pressure = pressure;
        this.humidity = humidity;
        this.dewPoint = dewPoint;
        this.uvi = uvi;
        this.clouds = clouds;
        this.visibility = visibility;
        this.windSpeed = windSpeed;
        this.windDeg = windDeg;
        this.weather = weather;
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

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(double feelsLike) {
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

    public double getUvi() {
        return uvi;
    }

    public void setUvi(double uvi) {
        this.uvi = uvi;
    }

    public long getClouds() {
        return clouds;
    }

    public void setClouds(long clouds) {
        this.clouds = clouds;
    }

    public long getVisibility() {
        return visibility;
    }

    public void setVisibility(long visibility) {
        this.visibility = visibility;
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

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

	@Override
	public String toString() {
		return "Current [dt=" + dt + ", sunrise=" + sunrise + ", sunset=" + sunset + ", temp=" + temp + ", feelsLike="
				+ feelsLike + ", pressure=" + pressure + ", humidity=" + humidity + ", dewPoint=" + dewPoint + ", uvi="
				+ uvi + ", clouds=" + clouds + ", visibility=" + visibility + ", windSpeed=" + windSpeed + ", windDeg="
				+ windDeg + ", weather=" + weather + ", additionalProperties=" + additionalProperties + "]";
	}

    

}
