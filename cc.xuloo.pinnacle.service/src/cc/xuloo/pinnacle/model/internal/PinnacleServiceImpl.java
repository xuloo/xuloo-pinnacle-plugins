package cc.xuloo.pinnacle.model.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

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
	
	private Map<Integer, Long> feedTimeById = new HashMap<Integer, Long>();
	
	private ExecutorService executor = Executors.newFixedThreadPool(20);
	
	@Override
	public synchronized List<PinnacleEventElement> getEvents(IEventBroker broker) {
		
		List<PinnacleEventElement> events = Lists.newArrayList();
		
		List<PinnacleSportSportElement> sports = Pinnacle.getSports();
		
		Collection<GetFeed> requests = Lists.newArrayList();
		
		for (PinnacleSportSportElement sport : sports) {
			
			if (sport.isFeedContents()) {
				try {
					
					requests.add(new GetFeed(sport.getName(), sport.getId()));
					
				} catch (Exception e) {
					
				}
			}
		}
		
		try {
			List<Future<Collection<PinnacleEventElement>>> lists = executor.invokeAll(requests);
			
			for (Future<Collection<PinnacleEventElement>> future : lists) {
				events.addAll(future.get());
			}
			
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		} catch (ExecutionException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
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
			
			Optional<PinnacleFeedElement> feed = null;
			
//			System.out.println("K=========================================================");
//			for (Integer key : feedTimeById.keySet()) {
//				System.out.println("==========================" + key + " " + feedTimeById.get(key) + " " + feedTimeById.get(key).getClass().getName() + "===========================");
//			}
//			System.out.println("HAS? " + id + " " + feedTimeById.containsKey(id));
//			System.out.println("K=========================================================");
			
			if (feedTimeById.containsKey(id)) {
				feed = Pinnacle.getFeed(id, String.valueOf(feedTimeById.get(id)));
			} else {
				feed = Pinnacle.getFeed(id);
			}
			
			if (feed.isPresent()) {
				
				Long lastUpdate = feed.get().getFeed();
				
//				System.out.println("=========================================================");
//				System.out.println("==========================" + id + " " + lastUpdate + "===========================");
//				System.out.println("=========================================================");
				
				feedTimeById.put(id, lastUpdate);
				
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
			
			return events;
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
