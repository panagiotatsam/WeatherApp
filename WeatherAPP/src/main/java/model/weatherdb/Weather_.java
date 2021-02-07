
package model.weatherdb;


import java.util.HashMap;
import java.util.Map;


public class Weather_ {

    private long id;
    private String main;
    private String description;
    private String icon;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Weather_() {
    }

    /**
     * 
     * @param icon
     * @param description
     * @param main
     * @param id
     */
    public Weather_(long id, String main, String description, String icon) {
        super();
        this.id = id;
        this.main = main;
        this.description = description;
        this.icon = icon;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

	@Override
	public String toString() {
		return "Weather_ [id=" + id + ", main=" + main + ", description=" + description + ", icon=" + icon
				+ ", additionalProperties=" + additionalProperties + "]";
	}

    

}
