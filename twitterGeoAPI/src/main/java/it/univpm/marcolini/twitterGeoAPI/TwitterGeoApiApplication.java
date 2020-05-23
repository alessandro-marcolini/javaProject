package it.univpm.marcolini.twitterGeoAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.univpm.marcolini.model.Record;
import it.univpm.marcolini.service.JsonUtils;

@SpringBootApplication
public class TwitterGeoApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TwitterGeoApiApplication.class, args);
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
		String json="{\n" + 
				"    \"result\": {\n" + 
				"        \"places\": [\n" + 
				"            {\n" + 
				"                \"id\": \"690b43d9593bd3ec\",\n" + 
				"                \"url\": \"https://api.twitter.com/1.1/geo/id/690b43d9593bd3ec.json\",\n" + 
				"                \"place_type\": \"city\",\n" + 
				"                \"name\": \"Macerata\",\n" + 
				"                \"full_name\": \"Macerata, Marche\",\n" + 
				"                \"country_code\": \"IT\",\n" + 
				"                \"country\": \"Italia\",\n" + 
				"                \"contained_within\": [\n" + 
				"                    {\n" + 
				"                        \"id\": \"a447759bf564568c\",\n" + 
				"                        \"url\": \"https://api.twitter.com/1.1/geo/id/a447759bf564568c.json\",\n" + 
				"                        \"place_type\": \"admin\",\n" + 
				"                        \"name\": \"Macerata\",\n" + 
				"                        \"full_name\": \"Macerata, Marche\",\n" + 
				"                        \"country_code\": \"IT\",\n" + 
				"                        \"country\": \"Italia\",\n" + 
				"                        \"centroid\": [\n" + 
				"                            13.15103406948766,\n" + 
				"                            43.15300300086295\n" + 
				"                        ],\n" + 
				"                        \"bounding_box\": {\n" + 
				"                            \"type\": \"Polygon\",\n" + 
				"                            \"coordinates\": [\n" + 
				"                                [\n" + 
				"                                    [\n" + 
				"                                        12.8296979970071,\n" + 
				"                                        42.8318220004272\n" + 
				"                                    ],\n" + 
				"                                    [\n" + 
				"                                        12.8296979970071,\n" + 
				"                                        43.4741840012987\n" + 
				"                                    ],\n" + 
				"                                    [\n" + 
				"                                        13.7430930021133,\n" + 
				"                                        43.4741840012987\n" + 
				"                                    ],\n" + 
				"                                    [\n" + 
				"                                        13.7430930021133,\n" + 
				"                                        42.8318220004272\n" + 
				"                                    ],\n" + 
				"                                    [\n" + 
				"                                        12.8296979970071,\n" + 
				"                                        42.8318220004272\n" + 
				"                                    ]\n" + 
				"                                ]\n" + 
				"                            ]\n" + 
				"                        },\n" + 
				"                        \"attributes\": {}\n" + 
				"                    }\n" + 
				"                ],\n" + 
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
				"            }\n" + 
				"        ]\n" + 
				"    },\n" + 
				"    \"query\": {\n" + 
				"        \"url\": \"https://api.twitter.com/1.1/geo/search.json?max_results=1&query=Macerata&\",\n" + 
				"        \"type\": \"search\",\n" + 
				"        \"params\": {\n" + 
				"            \"accuracy\": 0.0,\n" + 
				"            \"granularity\": \"neighborhood\",\n" + 
				"            \"query\": \"Macerata\",\n" + 
				"            \"autocomplete\": false,\n" + 
				"            \"trim_place\": false\n" + 
				"        }\n" + 
				"    }\n" + 
				"}";
		
		String jsonClean = JsonUtils.stringCleaner(json);
		Record prova = JsonUtils.toRecord(jsonClean);
		System.out.println(prova);
	}

}
