package it.univpm.marcolini.model;

/**
 * @author Alessandro Marcolini
 * @version 1.0
 */
public class Point {

    /**
     * Crea un oggetto di tipo Coordinate
     * @param lat latitudine del punto
     * @param lon longitudine del punto
     */
    public Point(double lat, double lon) {
    	this.lat = lat;
    	this.lon = lon;
    }

    /**
     * Indica la latitudine
     */
    protected double lat;

    /**
     * Indica la longitudine
     */
    protected double lon;



    /**
     * @return Restituisce la latitudine del punto
     */
    public double getLat() {
        // TODO implement here
        return 0.0d;
    }

    /**
     * @return Restituisce la longitudine del punto
     */
    public double getLon() {
        // TODO implement here
        return 0.0d;
    }

}