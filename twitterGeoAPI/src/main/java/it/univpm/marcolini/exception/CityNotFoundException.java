/**
 * 
 */
package it.univpm.marcolini.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

/**
 * @author Alessandro Marcolini
 * @version 1.0
 *
 */
@SuppressWarnings("serial")
public class CityNotFoundException extends ResponseStatusException{
	
	/**
	 * 
	 * @param status the http error code
	 * @param message the message to display
	 */
	public CityNotFoundException(HttpStatus status, String message) {
		super(status, message);
	}
}
