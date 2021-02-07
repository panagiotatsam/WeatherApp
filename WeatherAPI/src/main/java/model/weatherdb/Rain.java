
package model.weatherdb;



public class Rain {

    private double _1h;

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

    @Override
	public String toString() {
		return "Rain [_1h=" + _1h + "]";
	}

}
