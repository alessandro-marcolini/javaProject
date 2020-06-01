package it.univpm.marcolini.model;

public class GeoPoint {
	public Double lat;
	public Double lng;

	public GeoPoint(Double lng, Double lat) {
		this.lng = lng;
		this.lat = lat;
	}
	
	public GeoPoint(Double[] coord) {
		this.lng = coord[0];
		this.lat = coord[1];
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
