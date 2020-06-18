package it.univpm.marcolini.exception;

public class CharNotAllowedException extends RuntimeException{
private static final long serialVersionUID = 1L;
	
	/**
	 * @param message the message to display
	 */
	public CharNotAllowedException(String message) {
		super(message);
	}
}
