package it.univpm.marcolini.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;

import it.univpm.marcolini.exception.ApiRateLimitExceededException;
import it.univpm.marcolini.exception.GeneralApiErrorException;

/**
 * Class that containes all the methods related to the connection with the API
 * @author Alessandro Marcolini
 * @version 1.0
 *
 */
public class ConnectionService {
	
	/**
	 * takes the API url as input and returns the response as a <code>String</code>
	 * @param url the url of the Twitter API
	 * @throws ApiRateLimitExceededException
	 * @return the response from the API
	 */
	public static String getJsonFromURL(String url) throws ApiRateLimitExceededException{
		String response="";
		try {
			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			conn.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US) AppleWebKit/533.4 (KHTML, like Gecko) Chrome/5.0.375.99 Safari/533.4");
			
			int code = conn.getResponseCode();
			if(code==429) 
				throw new ApiRateLimitExceededException("Superato il limite di richieste");
			
			InputStream in = conn.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			
				
			String line="";
			while((line = reader.readLine())!=null)
				response += line;
			
			in.close();
			reader.close();
		}catch(MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		if(response == "" || response == null)
			throw new GeneralApiErrorException("Problemi riscontrati durante la richiesta al server.");
		return response;
	} 
	
}
