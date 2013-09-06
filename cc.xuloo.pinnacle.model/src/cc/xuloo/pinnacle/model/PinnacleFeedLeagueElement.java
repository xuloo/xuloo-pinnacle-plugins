package cc.xuloo.pinnacle.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="league")
public class PinnacleFeedLeagueElement {

	@XmlAttribute(name="id")
	private Integer id;

	@XmlElementWrapper(name="events")
	@XmlElement(name="event")
	private List<PinnacleEventElement> events;
	
	public Integer getId() {
		return id;
	}

	public List<PinnacleEventElement> getEvents() {
		return events;
	}
}
