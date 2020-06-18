package it.univpm.marcolini.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import it.univpm.marcolini.exception.ApiRateLimitExceededException;
import it.univpm.marcolini.exception.CityNotFoundException;
import it.univpm.marcolini.exception.ErrorObject;

/**
 * Class to handle exception thrown by the controller
 * @author Alessandro
 * @version 1.0
 */
@ControllerAdvice
public class GlobalExceptionHandler{
	/**
	 * Method used to handle {@link CityNotFoundException}
	 * @param ex
	 * @return a <code>ResponseEntity</code> object that contains info about the error
	 */
	@ExceptionHandler(value = { CityNotFoundException.class })
    public ResponseEntity<Object> handleException(CityNotFoundException ex) {
		ErrorObject error = new ErrorObject(HttpStatus.NOT_FOUND, ex.getClass().getSimpleName(), "Città non trovata");
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);	
    }
	
	/**
	 * Method used to handle {@link ApiRateLimitExceededException}
	 * @param ex
	 * @return a <code>ResponseEntity</code> object that contains info about the error
	 */
	@ExceptionHandler(value = { ApiRateLimitExceededException.class })
    public ResponseEntity<Object> handleException(ApiRateLimitExceededException ex) {
		ErrorObject error = new ErrorObject(HttpStatus.TOO_MANY_REQUESTS, ex.getClass().getSimpleName(), "Superato il limite di richieste");
		return new ResponseEntity<>(error, HttpStatus.TOO_MANY_REQUESTS);	
    }
}
