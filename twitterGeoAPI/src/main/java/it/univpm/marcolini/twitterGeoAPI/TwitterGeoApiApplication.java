package it.univpm.marcolini.twitterGeoAPI;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import it.univpm.marcolini.model.Record;
import it.univpm.marcolini.model.Record2;

//@SpringBootApplication
public class TwitterGeoApiApplication {

	public static void main(String[] args) {
		//SpringApplication.run(TwitterGeoApiApplication.class, args);
//		String url="https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/user/1.1/geo/search.json?query=Macerata";
//		URLConnection conn;
//		
//		try {
//			conn = new URL(url).openConnection();
//			conn.addRequestProperty("User-Agent", "");
//		} catch (MalformedURLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		String json="            {\n" + 
				"                \"id\": \"690b43d9593bd3ec\",\n" + 
				"                \"url\": \"https://api.twitter.com/1.1/geo/id/690b43d9593bd3ec.json\",\n" + 
				"                \"place_type\": \"city\",\n" + 
				"                \"name\": \"Macerata\",\n" + 
				"                \"full_name\": \"Macerata, Marche\",\n" + 
				"                \"country_code\": \"IT\",\n" + 
				"                \"country\": \"Italia\",\n" + 
				"                \"centroid\": [\n" + 
				"                    13.461903164674357,\n" + 
				"                    43.3055437\n" + 
				"                ],\n" + 
				"                \"bounding_box\": {\n" + 
				"                    \"type\": \"Polygon\",\n" + 
				"                    \"coordinates\": [\n" + 
				"                        [\n" + 
				"                            [\n" + 
				"                                13.3777865,\n" + 
				"                                43.2510021\n" + 
				"                            ],\n" + 
				"                            [\n" + 
				"                                13.3777865,\n" + 
				"                                43.3600853\n" + 
				"                            ],\n" + 
				"                            [\n" + 
				"                                13.5361397,\n" + 
				"                                43.3600853\n" + 
				"                            ],\n" + 
				"                            [\n" + 
				"                                13.5361397,\n" + 
				"                                43.2510021\n" + 
				"                            ],\n" + 
				"                            [\n" + 
				"                                13.3777865,\n" + 
				"                                43.2510021\n" + 
				"                            ]\n" + 
				"                        ]\n" + 
				"                    ]\n" + 
				"                },\n" + 
				"                \"attributes\": {}\n" + 
				"            }";
		ObjectMapper obj = new ObjectMapper();
		try {
			Record2 uno = obj.readValue(json, Record2.class);
			System.out.println(uno);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		
	}

}
