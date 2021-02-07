
package model.weatherdb;



public class CityInfo {

    private String name;
    private LocalNames localNames;
    private double lat;
    private double lon;
    private String country;
    private String state;

    /**
     * No args constructor for use in serialization
     * 
     */
    public CityInfo() {
    }

    /**
     * 
     * @param localNames
     * @param country
     * @param name
     * @param lon
     * @param state
     * @param lat
     */
    public CityInfo(String name, LocalNames localNames, double lat, double lon, String country, String state) {
        super();
        this.name = name;
        this.localNames = localNames;
        this.lat = lat;
        this.lon = lon;
        this.country = country;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalNames getLocalNames() {
        return localNames;
    }

    public void setLocalNames(LocalNames localNames) {
        this.localNames = localNames;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
	public String toString() {
		return "CityInfo [name=" + name + ", localNames=" + localNames + ", lat=" + lat + ", lon=" + lon + ", country="
				+ country + ", state=" + state + "]";
	}

}
