package it.univpm.marcolini.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import it.univpm.marcolini.util.GeoUtils;

/**
 * Class that describes a geographical location
 * @author Alessandro Marcolini
 * @version 1.0
 * @see BoundingBox
 * @see GeoPoint
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(value = { "url", "id", "name", "country_code", "contained_within", "attributes", "place_type" })
@JsonPropertyOrder({"full_name", "centroid", "country", "bounding_box"})

public class Record extends GeoPoint{

	/**
	 * city name, region name
	 */
	@JsonProperty("full_name")
	private String fullName;

	/**
	 * country name
	 */
	@JsonProperty("country")
	private String country;

	/**
	 * a {@link GeoPoint} that represent the coordinates of the center
	 */

	@JsonProperty("centroid")
	private GeoPoint centro = null;

	/**
	 * {@link BoundingBox} that represents the bounds of the city
	 */
	@JsonProperty("bounding_box")
	private BoundingBox boundingBox;
	
	/**
	 * Area of the record
	 */
	private Double area;
	
	/**
	 * Perimeter of the record
	 */
	private Double perimeter;

	/**
	 * constructor
	 * @param fullName
	 * @param country
	 * @param centro
	 * @param boundingBox
	 */
	public Record(String fullName, String country, Double[] centro, BoundingBox boundingBox) {
		super(centro);
		this.fullName = fullName;
		this.country = country;
		this.boundingBox = boundingBox;
		this.area = GeoUtils.getArea(this.getBoundingBox().getCoordinates());
		this.perimeter = GeoUtils.getPerimeter(this.getBoundingBox().getCoordinates());
	}
	
	/**
	 * default constructor
	 */
	public Record() {
		super();
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
	 * @param centroid the centro to set
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
	
	/**
	 * @return the area
	 */
	public Double getArea() {
		return GeoUtils.getArea(this.getBoundingBox().getCoordinates());
	}
	
	/**
	 * @param area the area to set
	 */
	public void setArea(Double area) {
		this.area = area;
	}
	
	/**
	 * @return the perimeter
	 */
	public Double getPerimeter() {
		return GeoUtils.getPerimeter(this.getBoundingBox().getCoordinates());
	}

	/**
	 * @param perimeter the perimeter to set
	 */
	public void setPerimeter(Double perimeter) {
		this.perimeter = perimeter;
	}

	@Override
	public String toString() {
		return "Location:\n" + "{Nome :  " + this.getFullName() + " \n" + " Stato :  " + this.getCountry() + " \n"
				+ " Coordinate del centro : [" + this.getCentro().toString() + "]\n" + " BoundingBox : "
				+ this.boundingBox.toString() + "\n area: "+  this.getArea() + "}\n";

	}
}