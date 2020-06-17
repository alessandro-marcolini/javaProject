package it.univpm.marcolini.controller;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.marcolini.exception.ApiRateLimitExceededException;
import it.univpm.marcolini.exception.CityNotFoundException;
import it.univpm.marcolini.exception.ErrorObject;
import it.univpm.marcolini.model.Metadata;
import it.univpm.marcolini.model.Record;
import it.univpm.marcolini.service.ConnectionService;
import it.univpm.marcolini.service.JsonService;
/**
 * 
 * @author Alessandro Marcolini
 * @version 1.0
 *
 */

@RestController
public class Controller {
	
	String url= "https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/user/1.1/geo/search.json?max_results=1";
	String jsonTownPath = "comuni.json";

	
	/**
	 * maps the "/search?city=" endpoint with a get request
	 * @param city the city to search
	 * @return a {@link Record}
	 * @throws CityNotFoundException if no city was found
	 */
	@RequestMapping(value="/search/{city}", method = RequestMethod.GET)
	public Record getRecordFromParam(@PathVariable("city") String city) throws CityNotFoundException{
		url+= "&query=" + city;
		String json = ConnectionService.getJsonFromURL(url);
		String jsonClean = JsonService.stringCleaner(json);
		return JsonService.toRecord(jsonClean);
	}
	
	/**
	 * maps the "/data" endpoint and use the {@link getRecordFromParam} method
	 * @return an <code>ArrayList</code> of {@link Record} to pass to {@link getRecordFromParam} method
	 * @throws CityNotFoundException if no city was found
	 */
	@RequestMapping(value="/data", method = RequestMethod.GET)
	public ArrayList<Record> getResults() throws CityNotFoundException{
		String[] cities = JsonService.randomCities(jsonTownPath);
		ArrayList<Record> list = new ArrayList<Record>();
		for(String city : cities) {
			list.add(getRecordFromParam(city));
		}
		return list;
	}
	
	/**
	 * maps the "/metadata" endpoint with a get request
	 * @return an <code>ArrayList</code> of {@link Metadata}
	 */
	@RequestMapping(value="/metadata", method = RequestMethod.GET)
	public ArrayList<Metadata> getMetadata() {
		ArrayList<Metadata> meta = new ArrayList<Metadata>();
		meta.add(new Metadata("fullName","full_name", "String"));
		meta.add(new Metadata("country","country", "String"));
		meta.add(new Metadata("centro","centroif", "GeoPoint"));
		meta.add(new Metadata("boundingBox","bounding_box", "BoundingBox"));
		return meta;
	}
	
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
