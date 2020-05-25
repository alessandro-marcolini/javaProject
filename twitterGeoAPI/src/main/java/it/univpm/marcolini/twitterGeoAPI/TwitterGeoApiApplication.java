package it.univpm.marcolini.twitterGeoAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.univpm.marcolini.model.Record;
import it.univpm.marcolini.service.ConnectionService;
import it.univpm.marcolini.service.JsonUtils;

@SpringBootApplication
public class TwitterGeoApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TwitterGeoApiApplication.class, args);

		String url= "https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/user/1.1/geo/search.json?query=Torino&max_results=1";

		String json = ConnectionService.getJsonFromURL(url);
		String jsonClean = JsonUtils.stringCleaner(json);
		Record prova = JsonUtils.toRecord(jsonClean);
		System.out.println(prova);
	}

}
