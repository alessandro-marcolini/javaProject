package it.univpm.marcolini.exception;

import org.springframework.http.HttpStatus;

/**
 * Class that represent an error
 * @author Alessandro Marcolini
 * @version 1.0
 *
 */
public class ErrorObject {
	
	private HttpStatus status;
	private String exceptionName;
	private String message;

	
	public ErrorObject(HttpStatus status, String exceptionName, String message) {

		this.status = status;
		this.exceptionName = exceptionName;
		this.message = message;
	}

	public HttpStatus getstatus() {
		return status;
	}

	public String getExceptionName() {
		return exceptionName;
	}

	public String getMessage() {
		return message;
	}
}
