package it.univpm.marcolini.exception;

/**
 * @author Alessandro Marcolini
 * @version 1.0
 *
 */
public class GeneralApiErrorException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public GeneralApiErrorException(String message) {
		super(message);
	}
}
