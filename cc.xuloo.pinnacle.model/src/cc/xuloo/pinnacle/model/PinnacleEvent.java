package cc.xuloo.pinnacle.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.joda.time.DateTime;

import cc.xuloo.pinnacle.model.adaptors.StringDateTimeConverter;

@XmlRootElement(name="event")
public class PinnacleEvent {

	@XmlElement(name="event_datetimeGMT")
	@XmlJavaTypeAdapter(StringDateTimeConverter.class)
	private DateTime dateTime;

	@XmlElement(name="gamenumber")
	private long gameNumber;
	
	@XmlElement(name="sporttype")
	private String sportType;

	@XmlElement(name="league")
	private String league;
	
	@XmlElement(name="IsLive")
	private boolean isLive;
	
	@XmlElementWrapper(name="participants")
	@XmlElement(name="participant")
	private List<PinnacleParticipant> participants;
	
	@XmlElementWrapper(name="periods")
	@XmlElement(name="period")
	private List<PinnaclePeriod> periods;
	
	@XmlElement(name="contest_maximum")
	private int contestMaximum;
	
	@XmlElement
	private String description;
	
	/**
	 * 
	 */
	public PinnacleEvent() {

	}

	/* (non-Javadoc)
	 * @see cc.xuloo.pinnacle.model.IPinnacleEvent#getDateTime()
	 */
	public DateTime getDateTime() {
		return dateTime;
	}

	/* (non-Javadoc)
	 * @see cc.xuloo.pinnacle.model.IPinnacleEvent#getGameNumber()
	 */
	public long getGameNumber() {
		return gameNumber;
	}

	/* (non-Javadoc)
	 * @see cc.xuloo.pinnacle.model.IPinnacleEvent#getSportType()
	 */
	public String getSportType() {
		return sportType;
	}

	/* (non-Javadoc)
	 * @see cc.xuloo.pinnacle.model.IPinnacleEvent#getLeague()
	 */
	public String getLeague() {
		return league;
	}

	/* (non-Javadoc)
	 * @see cc.xuloo.pinnacle.model.IPinnacleEvent#isLive()
	 */
	public boolean isLive() {
		return isLive;
	}

	/* (non-Javadoc)
	 * @see cc.xuloo.pinnacle.model.IPinnacleEvent#getParticipants()
	 */
	public List<PinnacleParticipant> getParticipants() {
		return participants;
	}

	/* (non-Javadoc)
	 * @see cc.xuloo.pinnacle.model.IPinnacleEvent#getPeriods()
	 */
	public List<PinnaclePeriod> getPeriods() {
		return periods;
	}
	
	/* (non-Javadoc)
	 * @see cc.xuloo.pinnacle.model.IPinnacleEvent#getParticipantWithStatus(cc.xuloo.pinnacle.model.PinnacleParticipantStatus)
	 */
	public PinnacleParticipant getParticipantWithStatus(PinnacleParticipantStatus status) {
		for (PinnacleParticipant p : participants) {
			if (p != null && p.getStatus().equals(status)) return p;
		}
		return null;
	}
	
	/* (non-Javadoc)
	 * @see cc.xuloo.pinnacle.model.IPinnacleEvent#getHomeTeam()
	 */
	public PinnacleParticipant getHomeTeam() {
		return getParticipantWithStatus(PinnacleParticipantStatus.HOME);
	}
	
	/* (non-Javadoc)
	 * @see cc.xuloo.pinnacle.model.IPinnacleEvent#getAwayTeam()
	 */
	public PinnacleParticipant getAwayTeam() {
		return getParticipantWithStatus(PinnacleParticipantStatus.VISITING);
	}
	
	/* (non-Javadoc)
	 * @see cc.xuloo.pinnacle.model.IPinnacleEvent#equals(cc.xuloo.pinnacle.model.IPinnacleEvent)
	 */
	public boolean equals(PinnacleEvent other) {
		return gameNumber == other.gameNumber;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "PinnacleEvent [dateTime=" + dateTime + ", gameNumber="
				+ gameNumber + ", sportType=" + sportType + ", league="
				+ league + "]";
	}
}
