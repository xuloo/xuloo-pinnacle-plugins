package cc.xuloo.pinnacle.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "sport")
public class PinnacleFeedSportElement {

	@XmlAttribute(name = "id")
	private Integer id;

	@XmlElementWrapper(name = "leagues")
	@XmlElement(name = "league")
	private List<PinnacleFeedLeagueElement> leagues;

	public Integer getId() {
		return id;
	}

	public List<PinnacleFeedLeagueElement> getLeagues() {
		return leagues;
	}

	@Override
	public String toString() {
		return "PinnacleFeedSport [id=" + id + "]";
	}
}
