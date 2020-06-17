package it.univpm.marcolini.model;

/**
 * Class that represent a geographical point
 * @author Alessandro Marcolini
 * @version 1.0
 */
public class GeoPoint {
	/**
	 * the latitude of the point
	 */
	protected Double lat;
	
	/**
	 * the longitude of the point
	 */
	protected Double lng;

	/**
	 * constructor
	 * @param lng the longitude to set
	 * @param lat the latitude to set
	 */
	public GeoPoint(Double lng, Double lat) {
		this.lng = lng;
		this.lat = lat;
	}
	
	/**
	 * constructor
	 * @param coord
	 */
	public GeoPoint(Double[] coord) {
		this.lng = coord[0];
		this.lat = coord[1];
	}
	
	/**
	 * default constructor
	 */
	public GeoPoint() {
	}

	/**
	 * @return the lat
	 */
	public Double getLat() {
		return lat;
	}

	/**
	 * @param lat the lat to set
	 */
	public void setLat(Double lat) {
		this.lat = lat;
	}

	/**
	 * @return the lng
	 */
	public Double getLng() {
		return lng;
	}

	/**
	 * @param lng the lng to set
	 */
	public void setLng(Double lng) {
		this.lng = lng;
	}
	
	@Override
	public String toString() {
		return "latitude: "+this.getLat() + ",\n longitude: " + this.getLng();
	}
}
