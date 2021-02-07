
package model.weatherdb;


import java.util.HashMap;
import java.util.Map;


public class Rain {

    private double _1h;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Rain() {
    }

    /**
     * 
     * @param _1h
     */
    public Rain(double _1h) {
        super();
        this._1h = _1h;
    }

    public double get1h() {
        return _1h;
    }

    public void set1h(double _1h) {
        this._1h = _1h;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
	public String toString() {
		return "Rain [_1h=" + _1h + ", additionalProperties=" + additionalProperties + "]";
	}

}
