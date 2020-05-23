package it.univpm.marcolini.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;

/**
 * 
 * @author Alessandro Marcolini
 * @version 1.0
 *
 */
public class ConnectionService {
	
	/**
	 * takes the API url as input and returns the response as a <code>String</code>
	 * @param url the url of the Twitter API
	 * @return the response from the API
	 */
	public static String getJsonFromURL(String url) {
		String response="";
		try {
			URLConnection conn = new URL(url).openConnection();
			conn.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US) AppleWebKit/533.4 (KHTML, like Gecko) Chrome/5.0.375.99 Safari/533.4");
			InputStream in = conn.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			
			response += reader.readLine();
			
			in.close();
			reader.close();
		}catch(MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return response;
	} 
	
	
}
