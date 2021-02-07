
package model.weatherdb;



public class Temp {

    private double day;
    private double min;
    private double max;
    private double night;
    private double eve;
    private double morn;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Temp() {
    }

    /**
     * 
     * @param min
     * @param max
     * @param eve
     * @param night
     * @param day
     * @param morn
     */
    public Temp(double day, double min, double max, double night, double eve, double morn) {
        super();
        this.day = day;
        this.min = min;
        this.max = max;
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

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
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

    @Override
	public String toString() {
		return "Temp [day=" + day + ", min=" + min + ", max=" + max + ", night=" + night + ", eve=" + eve + ", morn="
				+ morn + "]";
	}

}
