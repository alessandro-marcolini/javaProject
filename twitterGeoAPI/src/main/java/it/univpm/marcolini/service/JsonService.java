package it.univpm.marcolini.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;

import it.univpm.marcolini.exception.CityNotFoundException;
import it.univpm.marcolini.model.Record;
/**
 * 
 * @author Alessandro Marcolini
 * @version 1.0
 *
 */
public class JsonService {
	/**
	 * takes the response from the API and returns a modified <code>String</code>
	 * @param json the API response
	 * @return json <code>String</code>
	 * @throws CityNotFoundException 
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
	 * takes a json <code>String</code> and returns a <code>Record</code> created from it
	 * @param jsonClean json <code>String</code>
	 * @return a <code>Record</code>
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
	
//	public static String toJson(Record r) {
//		String jsonOut = "";
//		ObjectMapper obj = new ObjectMapper();
//		try {
//			jsonOut = obj.writeValueAsString(r);
//		}catch(IOException e) {
//			e.printStackTrace();
//		}
//		return jsonOut;
//	}
	
}
