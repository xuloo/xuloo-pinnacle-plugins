package cc.xuloo.pinnacle.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.joda.time.DateTime;

import cc.xuloo.pinnacle.model.adaptors.DateTimeAdaptor;

@XmlRootElement(name = "event")
public class PinnacleEventElement {

	@XmlElement(name = "startDateTime")
	@XmlJavaTypeAdapter(DateTimeAdaptor.class)
	private DateTime dateTime;

	@XmlElement(name = "id")
	private long id;

	@XmlElement(name = "IsLive")
	private boolean isLive;

	@XmlAttribute(name = "status")
	private String status;

	@XmlElement(name = "homeTeam")
	private PinnacleParticipantElement homeTeam;

	@XmlElement(name = "awayTeam")
	private PinnacleParticipantElement awayTeam;

	@XmlElementWrapper(name = "periods")
	@XmlElement(name = "period")
	private List<PinnaclePeriodElement> periods;
	
	private PinnacleParticipantElement[] participants;
	
	private String sport;

	public PinnacleEventElement() {

	}

	public DateTime getDateTime() {
		return dateTime;
	}

	public long getId() {
		return id;
	}

	public boolean isLive() {
		return isLive;
	}

	public List<PinnaclePeriodElement> getPeriods() {
		return periods;
	}

	public PinnacleParticipantElement getHomeTeam() {
		return homeTeam;
	}

	public PinnacleParticipantElement getAwayTeam() {
		return awayTeam;
	}
	
	public PinnacleParticipantElement[] getParticipants() {
		return participants = (participants == null) ? new PinnacleParticipantElement[] { homeTeam, awayTeam } : participants;
	}
	
	public String getSport() {
		return sport;
	}
	
	public void setSport(String sport) {
		this.sport = sport;
	}

	public boolean equals(Object obj) {
		
		if (obj == null) return false;
		if (obj == this) return true;
		if (obj.getClass() != getClass()) return false;
		
		PinnacleEventElement other = (PinnacleEventElement) obj;
		
		return new EqualsBuilder().append(id, other.id).isEquals();
	}

	@Override
	public String toString() {
		return "PinnacleEvent [homeTeam=" + homeTeam + ", awayTeam=" + awayTeam
				+ "]";
	}
}
