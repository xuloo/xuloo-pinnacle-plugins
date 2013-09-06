package cc.xuloo.pinnacle.model;

import java.util.List;

import org.eclipse.e4.core.services.events.IEventBroker;

public interface IPinnacleService {

	List<PinnacleEventElement> getEvents(IEventBroker broker);
	
	void addListener(PinnacleServiceListener listener);
	
	void removeListener(PinnacleServiceListener listener);
}
