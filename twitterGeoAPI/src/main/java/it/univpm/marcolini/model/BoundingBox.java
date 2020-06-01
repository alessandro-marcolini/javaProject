package it.univpm.marcolini.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @author Alessandro Marcolini
 * @version 1.0
 * @see GeoPoint
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"type",
	"coordinates"
})
public class BoundingBox {

	/**
     * shape of the boundingBox
     */
    @JsonProperty("type")
    protected String type;

    /**
     * verteces of the boundingBox
     */
    @JsonProperty("coordinates")
    protected GeoPoint[] coordinates = new GeoPoint[5];

    /**
     * constructor
     * @param type 
     * @param coordinates 
     */
    public BoundingBox(String type, GeoPoint[] coordinates) {
    	this.type = type;
    	this.coordinates = coordinates;
    }
    /**
     * default constructor
     */
    public BoundingBox() {}
    
    /**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the coordinates
	 */
	public GeoPoint[] getCoordinates() {
		return coordinates;
	}

	/**
	 * @param coordinates the coordinates to set
	 */
	public void setCoordinates(Double[][][] coordinates) {
		for(int i=0; i<5; i++) {
			this.coordinates[i] = new GeoPoint(coordinates[0][i]);
		}
	}

    @Override
    public String toString() {
    	String ris="[Forma geometrica del confine : " +this.type + "\nCoordinate dei vertici: ";
    	for(int i=0; i<5; i++) {
    		ris+= this.coordinates[i].toString();
    	}
    	ris+="]";
    	return ris;
    }
}