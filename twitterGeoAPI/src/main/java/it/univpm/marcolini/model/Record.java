package it.univpm.marcolini.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @author Alessandro Marcolini
 * @version 1.0
 * @see BoundingBox
 * @see GeoPoint
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(value = { "url", "id", "name", "country_code", "contained_within", "attributes", "place_type" })
@JsonPropertyOrder({

		"full_name", "centroid", "country", "bounding_box", })
public class Record {

	/**
	 * city name, region name
	 */
	@JsonProperty("full_name")
	protected String fullName;

	/**
	 * country name
	 */
	@JsonProperty("country")
	protected String country;

	/**
	 * an <code>Array</code> of Double that represent the coordinates of the center
	 */

	@JsonProperty("centroid")
	protected GeoPoint centro = null;

	/**
	 * <code>BoundingBox</code> that represents the bounds of the city
	 */
	@JsonProperty("bounding_box")
	protected BoundingBox boundingBox;

	/**
	 * creates a <code>Record</code>
	 * 
	 * @param placeType
	 * @param fullName
	 * @param country
	 * @param centro
	 * @param boundingBox
	 */
	public Record(String fullName, String country, Double[] centroid, BoundingBox boundingBox) {
		this.fullName = fullName;
		this.country = country;
		this.centro = new GeoPoint(centroid);
		this.boundingBox = boundingBox;
	}

	public Record() {
	}

	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the centro
	 */
	public GeoPoint getCentro() {
		return centro;
	}

	/**
	 * @param centro the centro to set
	 */
	public void setCentroid(Double[] centroid) {
		this.centro = new GeoPoint(centroid);
	}

	/**
	 * @return the boundingBox
	 */
	public BoundingBox getBoundingBox() {
		return boundingBox;
	}

	/**
	 * @param boundingBox the boundingBox to set
	 */
	public void setBoundingBox(BoundingBox boundingBox) {
		this.boundingBox = boundingBox;
	}

	public Double getDistanceFrom(Record a) {
		return this.getCentro().getDistanceFrom(a.getCentro());
	}

	public Double getDistanceFrom(GeoPoint p) {
		return this.getCentro().getDistanceFrom(p);
	}

	@Override
	public String toString() {
		return "Location:\n" + "{Nome :  " + this.getFullName() + " \n" + " Stato :  " + this.getCountry() + " \n"
				+ " Coordinate del centro : [" + this.getCentro().toString() + "]\n" + " BoundingBox : "
				+ this.boundingBox.toString() + "}\n";

	}
}