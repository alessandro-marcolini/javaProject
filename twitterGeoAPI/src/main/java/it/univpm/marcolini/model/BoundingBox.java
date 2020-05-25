package it.univpm.marcolini.model;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @author Alessandro Marcolini
 * @version 1.0
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"type",
	"coordinates"
})
public class BoundingBox {

    /**
     * constructor
     * @param type 
     * @param coordinates 
     */
    public BoundingBox(String type, Double[][][] coordinates) {
    	this.type = type;
    	this.coordinates = coordinates;
    }
    
    /**
     * default constructor
     */
    public BoundingBox() {
    }

    /**
     * shape of the boundingBox
     */
    @JsonProperty("type")
    protected String type;

    /**
     * verteces of the boundingBox
     */
    @JsonProperty("coordinates")
    protected Double[][][] coordinates = new Double[1][5][2];

    @Override
    public String toString() {
    	String ris="[Forma geometrica del confine : " +this.type + "\nCoordinate dei vertici: ";
    	for(int i=0; i<5; i++) {
    		ris+="\n [" + this.coordinates[0][i][0] +", "+ this.coordinates[0][i][1] + "]";
    	}
    	ris+="]";
    	return ris;
    }
}