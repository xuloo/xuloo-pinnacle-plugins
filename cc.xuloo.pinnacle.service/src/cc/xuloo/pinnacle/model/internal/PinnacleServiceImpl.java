package cc.xuloo.pinnacle.model.internal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

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
				
				File tempDir = FileUtils.getTempDirectory();
				File pinnacleDir = new File(tempDir, "pinnacle");
				
				FileUtils.forceMkdir(pinnacleDir);
				
				File file = new File(pinnacleDir, String.format("pinnacle-%s", DateTimeFormat.forPattern("yyyyMMddHHmmss").print(DateTime.now())));
				
				OutputStream os = new FileOutputStream(file);
				
				IOUtils.copy(instream, os);
				
				os.close();
				
				PinnacleLineFeed plf = null;
				
				try {
					
					broker.send("TOPIC_PINNACLE_STATUS_UPDATE", "Unmarshalling XML");
					
					JAXBContext jaxbContext = JAXBContext.newInstance("cc.xuloo.pinnacle.model");
					Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

					InputStream is = new FileInputStream(file);
					
					plf = (PinnacleLineFeed) unmarshaller.unmarshal(is);
					
					is.close();
					FileUtils.forceDelete(file);
					
					broker.send("TOPIC_PINNACLE_STATUS_UPDATE", "Unmarshalling complete");
				} catch (JAXBException e) {
					System.out.println("Problem unmarshalling - " + e.getMessage());
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
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
