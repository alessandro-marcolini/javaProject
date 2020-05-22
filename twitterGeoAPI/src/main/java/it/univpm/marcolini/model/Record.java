package it.univpm.marcolini.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @author Alessandro Marcolini
 * @version 1.0
 * @see Point
 * @see BoundingBox
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(value = { "url","id","name", "country_code", "contained_within", "attributes"})
@JsonPropertyOrder({
	"country",
	
	"full_name",
	"bounding_box",
	"centroid",
	"place_type",
})
public class Record {
	
	/**
     * nome della località, nome della regione
     */
	@JsonProperty("full_name")
	protected String fullName;

	/**
     * Indica il tipo di località, se si tratta di comune(=city) o di provincia(=admin)
     */
	@JsonProperty("place_type")
	protected String placeType;

	/**
     * Nome dello Stato
     */
	@JsonProperty("country")
	protected String country;

	/**
     * <code>Point</code> che rappresenta le coordinate del centro della località
     */
	@JsonProperty("centroid")
	protected Double[] centroid = new Double[2];

	/**
     * <code>BoundingBox</code> che rappresenta i confini della località
     */
	@JsonProperty("bounding_box")
	protected BoundingBox boundingBox;
	
	/**
     * <code>Record</code> della provincia a cui appartiene
     */
	@JsonProperty("contained_within")
	protected Record container;

	/**
	 * Crea un oggetto di tipo <code>Record</code>
	 * @param placeType 
	 * @param fullName 
	 * @param country 
	 * @param centroid 
	 * @param boundingBox 
	 * @param container 
	 */
	public Record(String placeType, String fullName, String country, Double[] centroid, BoundingBox boundingBox, Record container) {
		this.placeType = placeType;
		this.fullName = fullName;
		this.country = country;
		this.centroid = centroid;
		this.boundingBox = boundingBox;
		this.container = container;
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
	 * @return the placeType
	 */
	public String getPlaceType() {
		return placeType;
	}

	/**
	 * @param placeType the placeType to set
	 */
	public void setPlaceType(String placeType) {
		this.placeType = placeType;
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

	/**
	 * @return the container
	 */
	public Record getContainer() {
		return container;
	}

	/**
	 * @param container the container to set
	 */
	public void setContainer(Record container) {
		this.container = container;
	}

	@Override
	public String toString() {
		return "Location:\n"
				+ "{nome :  "+ this.getFullName()+ " \n"
				+ " categoria :  "+ this.getPlaceType()+ " \n"
				+ " stato :  " + this.getCountry() + " \n"
				+ " coordinate del centro : ["+this.getCentroid().toString()+"]\n"
				+ " boundingBox : "+ this.boundingBox.toString()+"}\n";
				
	}
	
	
	
}