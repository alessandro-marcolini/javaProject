package it.univpm.marcolini.util;

import it.univpm.marcolini.model.GeoPoint;

public class GeoUtils {
	
	public static Double roundOff(Double value) {
		double tmp = Math.pow(10, 2);
		return Math.round(value*tmp)/tmp;
	}

	public static Double toRad(Double value) {
		return value*Math.PI/180;
	}
	
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
	
	public static Double getArea(GeoPoint[] coord) {
		Double l = getDistanceFrom(coord[0], coord[1]);
		return roundOff(l*l);
	}
	
	public static Double getPerimeter(GeoPoint[] coord) {
		Double l = getDistanceFrom(coord[0], coord[1]);
		return roundOff(l*4);
	}
}
