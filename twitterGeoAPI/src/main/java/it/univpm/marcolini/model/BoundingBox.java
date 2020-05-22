package it.univpm.marcolini.model;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @author Alessandro Marcolini
 * @version 1.0
 * @see Point
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"type",
	"coordinates"
})
public class BoundingBox {

    /**
     * Default constructor
     * @param type forma geometrica del bounding box
     * @param coordinates <code>ArrayList</code> di oggetti di tipo Point che definiscono i vertici del bounding box
     */
//    public BoundingBox2(String type, List<Double> coordinates) {
//    	this.type = type;
//    	this.coordinates = coordinates;
//    }
    
    public BoundingBox() {
    }

    /**
     * Indica la forma del bounding box
     */
    @JsonProperty("type")
    protected String type;

    /**
     * Indica i vertici del bounding box
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

//    /**
//     * @return 
//     */
//    public double getArea() {
//        // TODO implement here
//        return 0.0d;
//    }
//
//    /**
//     * @return
//     */
//    public double getPerimeter() {
//        // TODO implement here
//        return 0.0d;
//    }
}