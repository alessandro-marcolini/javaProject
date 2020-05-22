package it.univpm.marcolini.model;
import java.util.ArrayList;

/**
 * @author Alessandro Marcolini
 * @version 1.0
 * @see Point
 */
public class Bound {

    /**
     * Default constructor
     * @param type forma geometrica del bounding box
     * @param coordinates <code>ArrayList</code> di oggetti di tipo Point che definiscono i vertici del bounding box
     */
    public Bound(String type, ArrayList<Point> coordinates) {
    	this.type = type;
    	this.coordinates = coordinates;
    }

    /**
     * Indica la forma del bounding box
     */
    protected String type;

    /**
     * Indica i vertici del bounding box
     */
    protected ArrayList<Point> coordinates;



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