package it.univpm.marcolini.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @author Alessandro Marcolini
 * @version 1.0
 * @see BoundingBox
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(value = { "url","id","name", "country_code", "contained_within", "attributes", "place_type"})
@JsonPropertyOrder({
	"country",
	"full_name",
	"bounding_box",
	"centroid",
})
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
	protected Double[] centroid = new Double[2];

	/**
     * <code>BoundingBox</code> that represents the bounds of the city
     */
	@JsonProperty("bounding_box")
	protected BoundingBox boundingBox;

	/**
	 * creates a <code>Record</code>
	 * @param placeType 
	 * @param fullName 
	 * @param country 
	 * @param centroid 
	 * @param boundingBox 
	 */
	public Record(String fullName, String country, Double[] centroid, BoundingBox boundingBox) {
		this.fullName = fullName;
		this.country = country;
		this.centroid = centroid;
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
	 * @return the centroid
	 */
	public Double[] getCentroid() {
		return centroid;
	}

	/**
	 * @param centroid the centroid to set
	 */
	public void setCentroid(Double[] centroid) {
		this.centroid = centroid;
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

	@Override
	public String toString() {
		return "Location:\n"
				+ "{nome :  "+ this.getFullName()+ " \n"
				+ " stato :  " + this.getCountry() + " \n"
				+ " coordinate del centro : ["+this.getCentroid().toString()+"]\n"
				+ " boundingBox : "+ this.boundingBox.toString()+"}\n";
				
	}
}