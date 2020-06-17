package it.univpm.marcolini.exception;

/**
 * Custom exception
 * @author Alessandro Marcolini
 * @version 1.0
 * 
 */
public class ApiRateLimitExceededException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	
	public ApiRateLimitExceededException(String message) {
		super(message);
	}
}
