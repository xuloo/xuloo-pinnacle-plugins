package cc.xuloo.pinnacle.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="rsp")
public class PinnacleResponseElement {

	@XmlAttribute(name="status")
	private String status;
	
	@XmlElementWrapper(name="sports")
	@XmlElement(name="sport")
	private List<PinnacleSportSportElement> sports;
	
	@XmlElement(name="sportId")
	private Integer sportId;
	
	@XmlElementWrapper(name="leagues")
	@XmlElement(name="league")
	private List<PinnacleLeagueLeagueElement> leagues;
	
	@XmlElement(name="fd")
	private PinnacleFeedElement feed;

	public String getStatus() {
		return status;
	}

	public List<PinnacleSportSportElement> getSports() {
		return sports;
	} 

	public Integer getSportId() {
		return sportId;
	}

	public List<PinnacleLeagueLeagueElement> getLeagues() {
		return leagues;
	}

	public PinnacleFeedElement getFeed() {
		return feed;
	}

	@Override
	public String toString() {
		return "PinnacleResponse [status=" + status + ", sports=" + sports
				+ ", sportId=" + sportId + ", leagues=" + leagues + ", feed="
				+ feed + "]";
	}
}
