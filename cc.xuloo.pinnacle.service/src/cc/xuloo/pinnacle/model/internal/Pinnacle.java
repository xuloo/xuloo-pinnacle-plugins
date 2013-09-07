package cc.xuloo.pinnacle.model.internal;

import java.io.IOException;
import java.io.StringReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.lang3.StringUtils;

import cc.xuloo.pinnacle.model.PinnacleFeedElement;
import cc.xuloo.pinnacle.model.PinnacleLeagueLeagueElement;
import cc.xuloo.pinnacle.model.PinnacleResponseElement;
import cc.xuloo.pinnacle.model.PinnacleSportSportElement;

import com.google.common.base.Optional;

public class Pinnacle {
	
	public static final String URL_BASE = "http://api.pinnaclesports.com/v1/";
	public static final String SPORTS_URI = String.format("%s%s", URL_BASE, "sports");
	public static final String LEAGUES_URI = String.format("%s%s", URL_BASE, "leagues");
	public static final String FEED_URI = String.format("%s%s", URL_BASE, "feed");
	
	public static final String API_KEY = "bde090cb-aabc-4876-b9aa-fb181f3bb095";
	public static final String CLIENT_ID = "DT552908";
	
	private static JAXBContext ctx;
	
	static {
		try {
			ctx = JAXBContext.newInstance("cc.xuloo.pinnacle.model");
		} catch (JAXBException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static Optional<PinnacleResponseElement> call(String url, JAXBContext ctx) {
		
		HttpClient client = new HttpClient();
		GetMethod method = new GetMethod(url);
		
		try {
			int status = client.executeMethod(method);
			
			if (status != HttpStatus.SC_OK) {
				System.out.println(String.format("call to '%s' failed with status '%s'", url, status));
				
				return Optional.absent();
			}
			
			String responseBody = method.getResponseBodyAsString();
			
			Unmarshaller um = ctx.createUnmarshaller();
			
			PinnacleResponseElement pr = (PinnacleResponseElement) um.unmarshal(new StringReader(responseBody));
			
			return Optional.of(pr);
			
		} catch (HttpException e) {
			System.out.println("Fatal protocol violation: " + e.getMessage());
	      return Optional.absent();
	    } catch (IOException e) {
	    	System.out.println("Fatal transport error: " + e.getMessage());
	      return Optional.absent();
	    } catch (JAXBException e) {
	    	System.out.println("JAXBException: " + e.getMessage());
	      return Optional.absent();
	    } finally {
	      // Release the connection.
	      method.releaseConnection();
	    } 
	} 

	public static List<PinnacleSportSportElement> getSports() {
		
		Optional<PinnacleResponseElement> response = call(SPORTS_URI, ctx);
		
		if (response.isPresent()) return response.get().getSports();
		return Collections.emptyList();
	}
	
	public static List<PinnacleLeagueLeagueElement> getLeagues(int sportId) {
		
		Map<String, String> params = new HashMap<String, String>();
		
		params.put("sportid", String.valueOf(sportId));
		
		String url = createUrl(LEAGUES_URI, params);
		
		Optional<PinnacleResponseElement> response = call(url, ctx);
		
		if (response.isPresent() && !response.get().getStatus().equals("fail")) {			
			return response.get().getLeagues();
		} else {
			System.out.println("call to '" + url + "' failed");
		}
		
		return Collections.emptyList();
	}
	
	public static Optional<PinnacleFeedElement> getFeed(int sportId, String lastFeedTime) {
		Map<String, String> params = new HashMap<String, String>();
		
		params.put("clientid", CLIENT_ID);
		params.put("apikey", API_KEY);
		params.put("sportid", String.valueOf(sportId));
		
		if (!StringUtils.isEmpty(lastFeedTime))
			params.put("last", String.valueOf(lastFeedTime));
		
		String url = createUrl(FEED_URI, params);
		
//		Logger.info("calling url '" + url + "'");
		System.out.println("calling url '" + url + "'");
		
		Optional<PinnacleResponseElement> response = call(url, ctx);
		
		if (response.isPresent()) 
			return Optional.of(response.get().getFeed());

		return Optional.absent();
	}
	
	public static Optional<PinnacleFeedElement> getFeed(int sportId) {
		Map<String, String> params = new HashMap<String, String>();
		
		params.put("clientid", CLIENT_ID);
		params.put("apikey", API_KEY);
		params.put("sportid", String.valueOf(sportId));
		
		String url = createUrl(FEED_URI, params);
		
		System.out.println("calling url '" + url + "'");
		
		Optional<PinnacleResponseElement> response = call(url, ctx);
		
		if (response.isPresent()) return Optional.of(response.get().getFeed());

		return Optional.absent();
	}
	
	public static String createUrl(String base, Map<String, String> params) {
		
		String[] joined = new String[params.size()];
		
		int i = 0;
		
		for (Entry<String, String> entry : params.entrySet()) {
			joined[i] = String.format("%s=%s", entry.getKey(), entry.getValue());
			i++;
		}
		
		String url = String.format("%s?%s", base, StringUtils.join(joined, "&"));
		
		return url;
	}

}
