package it.univpm.marcolini.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

import org.json.JSONArray;
import org.json.JSONObject;

import it.univpm.marcolini.exception.CityNotFoundException;
import it.univpm.marcolini.model.Record;
/**
 * Class that contains all the methods related to json management
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
	public static String stringCleaner(String json) throws CityNotFoundException {
		JSONObject response = new JSONObject(json);
		JSONArray places = response.getJSONObject("result").getJSONArray("places");
		if(places.isEmpty())
			throw new CityNotFoundException("Città non trovata");
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
	 * creates an array of random cities from a local json
	 * @param file a json that contains the name of the towns in Italy
	 * @return an array of <code>String</code> which contains ten random cities
	 */
	public static String[] randomCities(String file){
		
		String townJson="";
		String line="";
		try {
			BufferedReader in = new BufferedReader(new FileReader(file));
			while((line=in.readLine())!=null)
				townJson += line;
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		JSONArray towns = new JSONArray(townJson);
		int[] num = new int[10];
		num = randomValues();
		String[] cities = new String [10];
		String town="";
		for(int i=0; i<10; i++) {
			town = towns.getJSONObject(num[i]).getString("nome");
			cities[i] = town;
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
			values[i] = gen.nextInt(104) +1;
		}
		return values;
	}
	
}
