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
	 * takes the response from the API and returns a modified <code>String</code>
	 * @param json the API response
	 * @return json <code>String</code>
	 */
	public static String stringCleaner(String json) {
		JSONObject response = new JSONObject(json);
		JSONArray places = response.getJSONObject("result").getJSONArray("places");
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
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException ex) {
			ex.printStackTrace();
		}
		return location;
	}
	
}
