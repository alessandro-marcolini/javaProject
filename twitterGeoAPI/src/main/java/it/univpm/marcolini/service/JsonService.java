package it.univpm.marcolini.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Random;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;

import it.univpm.marcolini.exception.CityNotFoundException;
import it.univpm.marcolini.model.Record;
/**
 * 
 * @author Alessandro Marcolini
 * @version 1.0
 * @see Record
 */
public class JsonService {
	/**
	 * modifies the response from the API
	 * @param json the API response
	 * @return json <code>String</code>
	 * @throws CityNotFoundException if no cities were found
	 */
	public static String stringCleaner(String json) {
		JSONObject response = new JSONObject(json);
		JSONArray places = response.getJSONObject("result").getJSONArray("places");
		if(places.isEmpty())
			throw new CityNotFoundException(HttpStatus.NOT_FOUND,"Città non trovata.");
		JSONObject map = places.getJSONObject(0);
		String jsonClean = map.toString();
		return jsonClean;
	}
	
	/**
	 * creates a {@link Record} from a json <code>String</code> 
	 * @param jsonClean a json <code>String</code>
	 * @return a {@link Record}
	 */
	public static Record toRecord(String jsonClean) {
		ObjectMapper obj = new ObjectMapper();
		Record location = null;
		try {
			location = obj.readValue(jsonClean, Record.class);
		} catch (JsonMappingException e1) {
			e1.printStackTrace();
		} catch (JsonProcessingException e2) {
			e2.printStackTrace();
		}
		return location;
	}
	
	/**
	 * creates an array of random cities from a json
	 * @param townJson a json that contains the name of the towns in Italy
	 * @return an array of <code>String</code> which contains ten random cities
	 */
	public static String[] randomCities(String townJson){
		JSONArray towns = new JSONArray(townJson);
		int[] num = new int[10];
		num = randomValues();
		String[] cities = new String [10];
		for(int i=0; i<10; i++) {
			cities[i] = towns.getJSONObject(num[i]).getString("nome");
		}
		return cities;
	}
	
	/**
	 * generates an array of ten random <code>int</code>
	 * @return
	 */
	public static int[] randomValues() {
		Random gen = new Random();
		int[] values = new int[10];
		for(int i=0; i<10; i++)
		{
			values[i] = gen.nextInt(110) +1;
		}
		return values;
	}
	
		
}
