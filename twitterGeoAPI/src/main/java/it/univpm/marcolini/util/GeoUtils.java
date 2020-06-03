package it.univpm.marcolini.util;

import it.univpm.marcolini.model.GeoPoint;

/**
 * 
 * @author Alessandro Marcolini
 * @version 1.0
 * @see GeoPoint
 * @see BoundingBox
 */
public class GeoUtils {
	
	/**
	 * Approximate a <code>Double</code> to two degrees of accuracy
	 * @param value the value to approximate
	 * @return the approximated value
	 */
	public static Double roundOff(Double value) {
		double tmp = Math.pow(10, 2);
		return Math.round(value*tmp)/tmp;
	}

	/**
	 * Convert the value from degrees to radians
	 * @param value the value to convert
	 * @return the value converted
	 */
	public static Double toRad(Double value) {
		return value*Math.PI/180;
	}
	
	/**
	 * Calculate the distance between two {@link GeoPoint}
	 * @param a first {@link GeoPoint}
	 * @param b second {@link GeoPoint}
	 * @return the distance in km
	 */ 
	public static Double getDistanceFrom(GeoPoint a, GeoPoint b) {
		final Double r = 6372.7955;
		Double deltaLat = toRad(b.getLat() - a.getLat());
		Double deltaLng = toRad(b.getLng() - a.getLng());
		Double e = Math.sin(deltaLat / 2) * Math.sin(deltaLat / 2) + 
		Math.cos(toRad(a.getLat())) * Math.cos(toRad(b.getLat())) * 
		Math.sin(deltaLng / 2) * Math.sin(deltaLng / 2);
		Double c = 2 * Math.atan2(Math.sqrt(e), Math.sqrt(1-e));
		Double distance = r * c;
		return distance;
	}
	
	/**
	 * calculate the area of the {@link BoundingBox}
	 * @param coord an <code>Array</code> of {@link GeoPoint} that represents the vertices of the {@link BoundingBox}
	 * @return the area in square kilometres
	 */
	public static Double getArea(GeoPoint[] coord) {
		Double l = getDistanceFrom(coord[0], coord[1]);
		return roundOff(l*l);
	}
	
	/**
	 * calculate the perimeter of the {@link BoundingBox}
	 * @param coord an <code>Array</code> of {@link GeoPoint} that represents the vertices of the {@link BoundingBox}
	 * @return the perimeter in kilometres
	 */
	public static Double getPerimeter(GeoPoint[] coord) {
		Double l = getDistanceFrom(coord[0], coord[1]);
		return roundOff(l*4);
	}
}
