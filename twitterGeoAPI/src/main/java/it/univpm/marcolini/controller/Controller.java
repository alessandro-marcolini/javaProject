package it.univpm.marcolini.controller;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.marcolini.exception.CityNotFoundException;
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
	
	/**
	 * Return a <code>Record</code> obtained by the query given as parameter using a GET request
	 * @param city the city to search
	 * @return a <code>Record</code>
	 * @throws CityNotFoundException 
	 */
	@GetMapping("/search")
	public Record getRecordFromParam(@RequestParam(value= "city")String city) throws CityNotFoundException{
		url+= "&query=" + city;
		String json = ConnectionService.getJsonFromURL(url);
		String jsonClean = JsonService.stringCleaner(json);
		return JsonService.toRecord(jsonClean);
	}
	
	/**
	 * Return an <code>ArrayList</code> of <code>Record</code> obtained by using getRecordFromParam
	 * @return an <code>ArrayList</code> of <code>Record</code>
	 * @throws CityNotFoundException 
	 */
	@GetMapping("/data")
	public ArrayList<Record> getResults() throws CityNotFoundException{
		String[] cities = {"Macerata", "Ancona", "Roma", "Milano", "Palermo", "Genova", "Torino", "Aosta", "Cagliari", "Firenze"};
		ArrayList<Record> list = new ArrayList<Record>();
		for(int i=0; i<9; i++) {
			list.add(getRecordFromParam(cities[i]));
		}
		return list;
	}
	
	@GetMapping("/metadata")
	public ArrayList<Metadata> getMetadata() {
		ArrayList<Metadata> meta = new ArrayList<Metadata>();
		meta.add(new Metadata("fullName","full_name", "String"));
		meta.add(new Metadata("country","country", "String"));
		meta.add(new Metadata("centroid","centro", "GeoPoint"));
		meta.add(new Metadata("boundingBox","bounding_box", "BoundingBox"));
		return meta;
	}
	
	@ExceptionHandler(CityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public CityNotFoundException handleCustomException(CityNotFoundException ex) {
        return ex;
    }
}


