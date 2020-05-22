package it.univpm.marcolini.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.*;
import it.univpm.marcolini.model.Record;

public class JsonUtils {
	
	public static String stringCleaner(String json) {
		JSONObject response = new JSONObject(json);
		JSONArray places = response.getJSONObject("result").getJSONArray("places");
		JSONObject map = places.getJSONObject(0);
		String jsonClean = map.toString();
		return jsonClean;
	}
	
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
