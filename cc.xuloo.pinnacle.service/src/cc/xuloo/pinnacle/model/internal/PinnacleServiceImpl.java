package cc.xuloo.pinnacle.model.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;

import org.eclipse.e4.core.services.events.IEventBroker;

import cc.xuloo.pinnacle.PinnacleParticipantStatus;
import cc.xuloo.pinnacle.model.IPinnacleService;
import cc.xuloo.pinnacle.model.PinnacleEventElement;
import cc.xuloo.pinnacle.model.PinnacleFeedElement;
import cc.xuloo.pinnacle.model.PinnacleFeedLeagueElement;
import cc.xuloo.pinnacle.model.PinnacleFeedSportElement;
import cc.xuloo.pinnacle.model.PinnacleServiceListener;
import cc.xuloo.pinnacle.model.PinnacleSportSportElement;

import com.google.common.base.Optional;
import com.google.common.collect.Lists;

public class PinnacleServiceImpl implements IPinnacleService, ValidationEventHandler {

	private List<PinnacleServiceListener> listeners = Collections.synchronizedList(new ArrayList<PinnacleServiceListener>());
	
	private long lastUpdate = 0L;
	
	private ExecutorService executor = Executors.newFixedThreadPool(20);
	
	@Override
	public synchronized List<PinnacleEventElement> getEvents(IEventBroker broker) {
		
		List<PinnacleEventElement> events = Lists.newArrayList();
		
		List<PinnacleSportSportElement> sports = Pinnacle.getSports();
		
		for (PinnacleSportSportElement sport : sports) {
			
			if (sport.isFeedContents()) {
				try {
					Collection<PinnacleEventElement> collection = executor.submit(new GetFeed(sport.getName(), sport.getId())).get();
					events.addAll(collection);
				} catch (Exception e) {
					
				}
			}
		}
		
		return events;
	}
	
	private class GetFeed implements Callable<Collection<PinnacleEventElement>> {
		
		private String sport;
		
		private int id;
		
		public GetFeed(String sport, int id) {
			this.sport = sport;
			this.id = id;
		}

		@Override
		public Collection<PinnacleEventElement> call() throws Exception {
			
			List<PinnacleEventElement> events = Lists.newArrayList();
			
			Optional<PinnacleFeedElement> feed = Pinnacle.getFeed(id, String.valueOf(lastUpdate));
			
			if (feed.isPresent()) {
				
				for (PinnacleFeedSportElement fSport : feed.get().getSports()) {
					
					for (PinnacleFeedLeagueElement league : fSport.getLeagues()) {
						
						for (PinnacleEventElement event : league.getEvents()) {
						
							event.setSport(sport);
							
							event.getHomeTeam().setStatus(PinnacleParticipantStatus.HOME);
							event.getAwayTeam().setStatus(PinnacleParticipantStatus.VISITING);
							
							events.add(event);
						}
					}
				}
			}
			
			return null;
		}
		
	}

//	private PinnacleLineFeed updateLineFeed(IEventBroker broker, long lastUpdate) {
//
//		broker.send("TOPIC_PINNACLE_STATUS_UPDATE", "Requesting Pinnacle events");
//		
//		HttpClient httpclient = new DefaultHttpClient();
//		
//		String url = PinnacleConstants.DATA_URL;
//		
//		if (lastUpdate > 0) {
//			url = String.format("%s?last=%s", url, lastUpdate);
//		}
//		
//		System.out.println("updating pinnacle feed from '" + url + "'");
//		
//		HttpGet httpget = new HttpGet(url);
//		
//		try {
//			HttpResponse response = httpclient.execute(httpget);
//			HttpEntity entity = response.getEntity();
//			if (entity != null) {
//				
//				broker.send("TOPIC_PINNACLE_STATUS_UPDATE", "Response received");
//				
//				InputStream instream = entity.getContent();
//				
//				File tempDir = FileUtils.getTempDirectory();
//				File pinnacleDir = new File(tempDir, "pinnacle");
//				
//				FileUtils.forceMkdir(pinnacleDir);
//				
//				File file = new File(pinnacleDir, String.format("pinnacle-%s", DateTimeFormat.forPattern("yyyyMMddHHmmss").print(DateTime.now())));
//				
//				OutputStream os = new FileOutputStream(file);
//				
//				IOUtils.copy(instream, os);
//				
//				os.close();
//				
//				PinnacleLineFeed plf = null;
//				
//				try {
//					
//					broker.send("TOPIC_PINNACLE_STATUS_UPDATE", "Unmarshalling XML");
//					
//					JAXBContext jaxbContext = JAXBContext.newInstance("cc.xuloo.pinnacle.model");
//					Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
//
//					InputStream is = new FileInputStream(file);
//					
//					plf = (PinnacleLineFeed) unmarshaller.unmarshal(is);
//					
//					is.close();
//					FileUtils.forceDelete(file);
//					
//					broker.send("TOPIC_PINNACLE_STATUS_UPDATE", "Unmarshalling complete");
//				} catch (JAXBException e) {
//					System.out.println("Problem unmarshalling - " + e.getMessage());
//					e.printStackTrace();
//				} catch (Exception e) {
//					e.printStackTrace();
//				} finally {
//					instream.close();
//				}
//
//				return plf;
//			}
//
//			return null;
//
//		} catch (Exception e) {
//			System.out.println("exception hitting service endpoint "
//					+ e.getMessage());
//			e.printStackTrace();
//			return null;
//		}
//	}

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
