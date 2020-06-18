package it.univpm.marcolini.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.marcolini.exception.ApiRateLimitExceededException;
import it.univpm.marcolini.exception.CityNotFoundException;
import it.univpm.marcolini.model.Metadata;
import it.univpm.marcolini.model.Record;
import it.univpm.marcolini.service.ConnectionService;
import it.univpm.marcolini.service.JsonService;
/**
 * Controller
 * @author Alessandro Marcolini
 * @version 1.0
 *
 */

@RestController
public class Controller {
	
	private final String url= "https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/user/1.1/geo/search.json?max_results=1";
	private final String jsonTownPath = "comuni.json";

	
	/**
	 * maps the "/search?city=" endpoint with a get request
	 * @param city the city to search
	 * @return a {@link Record}
	 * @throws CityNotFoundException if no city was found
	 */
	@RequestMapping(value="/search/{city}", method = RequestMethod.GET)
	public Record getRecordFromParam(@PathVariable("city") String city) 
			throws CityNotFoundException, ApiRateLimitExceededException{
		String urlWithParam= url + "&query=" + city;
		String json = ConnectionService.getJsonFromURL(urlWithParam);
		String jsonClean = JsonService.stringCleaner(json);
		return JsonService.toRecord(jsonClean);
	}
	
	/**
	 * maps the "/data" endpoint and use the {@link getRecordFromParam} method
	 * @return an <code>ArrayList</code> of {@link Record} to pass to {@link getRecordFromParam} method
	 * @throws CityNotFoundException if no city was found
	 */
	@RequestMapping(value="/data", method = RequestMethod.GET)
	public ArrayList<Record> getResults() throws CityNotFoundException, ApiRateLimitExceededException{
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
		meta.add(new Metadata("centro","centroid", "GeoPoint"));
		meta.add(new Metadata("boundingBox","bounding_box", "BoundingBox"));
		return meta;
	}

}
