package cc.xuloo.pinnacle.model;

import org.eclipse.e4.core.services.events.IEventBroker;

public interface IPinnacleService {

	PinnacleLineFeed getEvents(IEventBroker broker, long lastUpdate);
	
	void addListener(PinnacleServiceListener listener);
	
	void removeListener(PinnacleServiceListener listener);
}
