package it.univpm.marcolini.twitterGeoAPI;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.marcolini.model.Record;
import it.univpm.marcolini.service.ConnectionService;
import it.univpm.marcolini.service.JsonUtils;
/**
 * 
 * @author Alessandro Marcolini
 * @version 1.0
 *
 */

@RestController
public class Controller {
	String url= "https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/user/1.1/geo/search.json?max_results=1";
	
	@GetMapping("/search")
	public Record getRecordFromParam(@RequestParam(value= "city")String city){
		url+= "&query=" + city;
		String json = ConnectionService.getJsonFromURL(url);
		String jsonClean = JsonUtils.stringCleaner(json);
		return JsonUtils.toRecord(jsonClean);
	}
	
	@GetMapping("/results")
	public ArrayList<Record> getResults(){
		String[] cities = {"Macerata", "Ancona", "Roma", "Milano", "Palermo", "Genova", "Torino", "Aosta", "Cagliari", "Firenze"};
		ArrayList<Record> list = new ArrayList<Record>();
		for(int i=0; i<9; i++) {
			list.add(getRecordFromParam(cities[i]));
		}
		return list;
	}
}
