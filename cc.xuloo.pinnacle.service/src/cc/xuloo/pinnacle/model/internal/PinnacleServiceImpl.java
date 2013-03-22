package cc.xuloo.pinnacle.model.internal;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.eclipse.e4.core.services.events.IEventBroker;

import cc.xuloo.pinnacle.model.IPinnacleService;
import cc.xuloo.pinnacle.model.PinnacleConstants;
import cc.xuloo.pinnacle.model.PinnacleLineFeed;
import cc.xuloo.pinnacle.model.PinnacleServiceListener;

public class PinnacleServiceImpl implements IPinnacleService, ValidationEventHandler {

	private List<PinnacleServiceListener> listeners = Collections.synchronizedList(new ArrayList<PinnacleServiceListener>());
	
	@Override
	public synchronized PinnacleLineFeed getEvents(IEventBroker broker, long lastUpdate) {

		return updateLineFeed(broker, lastUpdate);
	}

	private PinnacleLineFeed updateLineFeed(IEventBroker broker, long lastUpdate) {

		broker.send("TOPIC_PINNACLE_STATUS_UPDATE", "Requesting Pinnacle events");
		
		HttpClient httpclient = new DefaultHttpClient();
		
		String url = PinnacleConstants.DATA_URL;
		
		if (lastUpdate > 0) {
			url = String.format("%s?last=%s", url, lastUpdate);
		}
		
		System.out.println("updating pinnacle feed from '" + url + "'");
		
		HttpGet httpget = new HttpGet(url);
		
		try {
			HttpResponse response = httpclient.execute(httpget);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				
				broker.send("TOPIC_PINNACLE_STATUS_UPDATE", "Response received");
				
				InputStream instream = entity.getContent();
				PinnacleLineFeed plf = null;
				
				try {
					
					broker.send("TOPIC_PINNACLE_STATUS_UPDATE", "Unmarshalling XML");
					
					JAXBContext jaxbContext = JAXBContext.newInstance("cc.xuloo.pinnacle.model");
					Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
					//unmarshaller.setEventHandler(this);
					plf = (PinnacleLineFeed) unmarshaller.unmarshal(instream);
					
					broker.send("TOPIC_PINNACLE_STATUS_UPDATE", "Unmarshalling complete");
					
				} finally {
					instream.close();
				}

				return plf;
			}

			return null;

		} catch (Exception e) {
			System.out.println("exception hitting service endpoint "
					+ e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	public boolean handleEvent(ValidationEvent event) {
		if (event.getMessage().startsWith("unexpected"))
			System.out.println(event.getMessage());
		return true;
	}
	
	public synchronized void addListener(PinnacleServiceListener listener) {
		listeners.add(listener);
	}
	
	public synchronized void removeListener(PinnacleServiceListener listener) {
		listeners.remove(listener);
	}
	
	public void updateListeners(String update) {
		for (PinnacleServiceListener listener : listeners) {
			listener.pinnacleServiceUpdate(update);
		}
	}

}
