
package model.weatherdb;



public class IpAddressLocation {

    private String ip;
    private String version;
    private String city;
    private String region;
    private String regionCode;
    private String country;
    private String countryName;
    private String countryCode;
    private String countryCodeIso3;
    private String countryCapital;
    private String countryTld;
    private String continentCode;
    private boolean inEu;
    private String postal;
    private double latitude;
    private double longitude;
    private String timezone;
    private String utcOffset;
    private String countryCallingCode;
    private String currency;
    private String currencyName;
    private String languages;
    private double countryArea;
    private double countryPopulation;
    private String asn;
    private String org;

    /**
     * No args constructor for use in serialization
     * 
     */
    public IpAddressLocation() {
    }

    /**
     * 
     * @param country
     * @param inEu
     * @param city
     * @param timezone
     * @param latitude
     * @param countryPopulation
     * @param regionCode
     * @param countryCodeIso3
     * @param currencyName
     * @param countryCallingCode
     * @param countryCode
     * @param currency
     * @param continentCode
     * @param longitude
     * @param utcOffset
     * @param languages
     * @param org
     * @param ip
     * @param countryTld
     * @param version
     * @param countryCapital
     * @param countryArea
     * @param countryName
     * @param postal
     * @param region
     * @param asn
     */
    public IpAddressLocation(String ip, String version, String city, String region, String regionCode, String country, String countryName, String countryCode, String countryCodeIso3, String countryCapital, String countryTld, String continentCode, boolean inEu, String postal, double latitude, double longitude, String timezone, String utcOffset, String countryCallingCode, String currency, String currencyName, String languages, double countryArea, double countryPopulation, String asn, String org) {
        super();
        this.ip = ip;
        this.version = version;
        this.city = city;
        this.region = region;
        this.regionCode = regionCode;
        this.country = country;
        this.countryName = countryName;
        this.countryCode = countryCode;
        this.countryCodeIso3 = countryCodeIso3;
        this.countryCapital = countryCapital;
        this.countryTld = countryTld;
        this.continentCode = continentCode;
        this.inEu = inEu;
        this.postal = postal;
        this.latitude = latitude;
        this.longitude = longitude;
        this.timezone = timezone;
        this.utcOffset = utcOffset;
        this.countryCallingCode = countryCallingCode;
        this.currency = currency;
        this.currencyName = currencyName;
        this.languages = languages;
        this.countryArea = countryArea;
        this.countryPopulation = countryPopulation;
        this.asn = asn;
        this.org = org;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryCodeIso3() {
        return countryCodeIso3;
    }

    public void setCountryCodeIso3(String countryCodeIso3) {
        this.countryCodeIso3 = countryCodeIso3;
    }

    public String getCountryCapital() {
        return countryCapital;
    }

    public void setCountryCapital(String countryCapital) {
        this.countryCapital = countryCapital;
    }

    public String getCountryTld() {
        return countryTld;
    }

    public void setCountryTld(String countryTld) {
        this.countryTld = countryTld;
    }

    public String getContinentCode() {
        return continentCode;
    }

    public void setContinentCode(String continentCode) {
        this.continentCode = continentCode;
    }

    public boolean isInEu() {
        return inEu;
    }

    public void setInEu(boolean inEu) {
        this.inEu = inEu;
    }

    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getUtcOffset() {
        return utcOffset;
    }

    public void setUtcOffset(String utcOffset) {
        this.utcOffset = utcOffset;
    }

    public String getCountryCallingCode() {
        return countryCallingCode;
    }

    public void setCountryCallingCode(String countryCallingCode) {
        this.countryCallingCode = countryCallingCode;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public double getCountryArea() {
        return countryArea;
    }

    public void setCountryArea(double countryArea) {
        this.countryArea = countryArea;
    }

    public double getCountryPopulation() {
        return countryPopulation;
    }

    public void setCountryPopulation(double countryPopulation) {
        this.countryPopulation = countryPopulation;
    }

    public String getAsn() {
        return asn;
    }

    public void setAsn(String asn) {
        this.asn = asn;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    @Override
	public String toString() {
		return "WeatherClientIPAddress [ip=" + ip + ", version=" + version + ", city=" + city + ", region=" + region
				+ ", regionCode=" + regionCode + ", country=" + country + ", countryName=" + countryName
				+ ", countryCode=" + countryCode + ", countryCodeIso3=" + countryCodeIso3 + ", countryCapital="
				+ countryCapital + ", countryTld=" + countryTld + ", continentCode=" + continentCode + ", inEu=" + inEu
				+ ", postal=" + postal + ", latitude=" + latitude + ", longitude=" + longitude + ", timezone="
				+ timezone + ", utcOffset=" + utcOffset + ", countryCallingCode=" + countryCallingCode + ", currency="
				+ currency + ", currencyName=" + currencyName + ", languages=" + languages + ", countryArea="
				+ countryArea + ", countryPopulation=" + countryPopulation + ", asn=" + asn + ", org=" + org + "]";
	}

}
