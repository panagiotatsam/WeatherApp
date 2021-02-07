
package model.weatherdb;

import java.util.List;


public class Hourly {

    private long dt;
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
    private List<Weather_> weather = null;
    private long pop;
    private Rain rain;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Hourly() {
    }

    /**
     * 
     * @param rain
     * @param temp
     * @param visibility
     * @param uvi
     * @param pressure
     * @param clouds
     * @param dewPoint
     * @param dt
     * @param feelsLike
     * @param windDeg
     * @param pop
     * @param weather
     * @param humidity
     * @param windSpeed
     */
    public Hourly(long dt, double temp, double feelsLike, long pressure, long humidity, double dewPoint, double uvi, long clouds, long visibility, double windSpeed, long windDeg, List<Weather_> weather, long pop, Rain rain) {
        super();
        this.dt = dt;
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
        this.pop = pop;
        this.rain = rain;
    }

    public long getDt() {
        return dt;
    }

    public void setDt(long dt) {
        this.dt = dt;
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

    public List<Weather_> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather_> weather) {
        this.weather = weather;
    }

    public long getPop() {
        return pop;
    }

    public void setPop(long pop) {
        this.pop = pop;
    }

    public Rain getRain() {
        return rain;
    }

    public void setRain(Rain rain) {
        this.rain = rain;
    }

    @Override
	public String toString() {
		return "Hourly [dt=" + dt + ", temp=" + temp + ", feelsLike=" + feelsLike + ", pressure=" + pressure
				+ ", humidity=" + humidity + ", dewPoint=" + dewPoint + ", uvi=" + uvi + ", clouds=" + clouds
				+ ", visibility=" + visibility + ", windSpeed=" + windSpeed + ", windDeg=" + windDeg + ", weather="
				+ weather + ", pop=" + pop + ", rain=" + rain + "]";
	}

}
