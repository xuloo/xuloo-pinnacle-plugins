package cc.xuloo.pinnacle.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import org.joda.time.DateTime;

@XmlRootElement(name="pinnacle_line_feed")
public class PinnacleLineFeed {
	
	@XmlElement(name="PinnacleFeedTime")
	private long pinnacleFeedTime;
	
	@XmlElement(name="lastContest")
	private DateTime lastContest;
	
	@XmlElement(name="lastGame")
	private DateTime lastGame;
	
	@XmlElementWrapper(name="events")
	@XmlElement(name="event")
	private List<PinnacleEvent> events;

	public long getPinnacleFeedTime() {
		return pinnacleFeedTime;
	}

	public DateTime getLastContest() {
		return lastContest;
	}

	public DateTime getLastGame() {
		return lastGame;
	}

	public List<PinnacleEvent> getEvents() {
		return events;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "PinnacleLineFeed [pinnacleFeedTime=" + pinnacleFeedTime
				+ ", events=" + events.size() + "]";
	}
}
