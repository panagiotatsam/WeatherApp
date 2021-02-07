
package model.weatherdb;


import java.util.HashMap;
import java.util.Map;


public class FeelsLike {

    private double day;
    private double night;
    private double eve;
    private double morn;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public FeelsLike() {
    }

    /**
     * 
     * @param eve
     * @param night
     * @param day
     * @param morn
     */
    public FeelsLike(double day, double night, double eve, double morn) {
        super();
        this.day = day;
        this.night = night;
        this.eve = eve;
        this.morn = morn;
    }

    public double getDay() {
        return day;
    }

    public void setDay(double day) {
        this.day = day;
    }

    public double getNight() {
        return night;
    }

    public void setNight(double night) {
        this.night = night;
    }

    public double getEve() {
        return eve;
    }

    public void setEve(double eve) {
        this.eve = eve;
    }

    public double getMorn() {
        return morn;
    }

    public void setMorn(double morn) {
        this.morn = morn;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
	public String toString() {
		return "FeelsLike [day=" + day + ", night=" + night + ", eve=" + eve + ", morn=" + morn
				+ ", additionalProperties=" + additionalProperties + "]";
	}

}
