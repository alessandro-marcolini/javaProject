package it.univpm.marcolini.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.*;
import it.univpm.marcolini.model.Record;
/**
 * 
 * @author Alessandro Marcolini
 * @version 1.0
 *
 */
public class JsonUtils {
	/**
	 * Prende in input la risposta della API e restituisce una stringa modificata
	 * @param json la risposta ricevuta dalla API twitter
	 * @return 
	 */
	public static String stringCleaner(String json) {
		JSONObject response = new JSONObject(json);
		JSONArray places = response.getJSONObject("result").getJSONArray("places");
		JSONObject map = places.getJSONObject(0);
		String jsonClean = map.toString();
		return jsonClean;
	}
	
	/**
	 * Prende in input una stringa json e crea un <code>Record</code> deserializzando il json
	 * @param jsonClean una stringa json
	 * @return un <code>Record</code> ottenuto dalla stringa
	 */
	public static Record toRecord(String jsonClean) {
		ObjectMapper obj = new ObjectMapper();
		Record location = null;
		try {
			location = obj.readValue(jsonClean, Record.class);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException ex) {
			ex.printStackTrace();
		}
		return location;
	}
	
}
