
package it.univpm.marcolini.exception;

/**
 * Custom exception
 * @author Alessandro Marcolini
 * @version 1.0
 *
 */
public class CityNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * @param message the message to display
	 */
	public CityNotFoundException(String message) {
		super(message);
	}
}
