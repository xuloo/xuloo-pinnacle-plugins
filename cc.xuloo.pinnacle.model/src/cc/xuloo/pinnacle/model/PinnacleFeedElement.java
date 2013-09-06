package cc.xuloo.pinnacle.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="fd")
public class PinnacleFeedElement {

	@XmlElement(name="fdTime")
	private Long feed;
	
	@XmlElementWrapper(name="sports")
	@XmlElement(name="sport")
	private List<PinnacleFeedSportElement> sports;

	public Long getFeed() {
		return feed;
	}

	public List<PinnacleFeedSportElement> getSports() {
		return sports;
	}
}
