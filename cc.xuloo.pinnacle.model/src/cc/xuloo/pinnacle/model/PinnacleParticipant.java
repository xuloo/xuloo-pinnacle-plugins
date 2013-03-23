package cc.xuloo.pinnacle.model;

import cc.xuloo.pinnacle.model.adaptors.ParticipantNameAdaptor;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name="participant")
public class PinnacleParticipant {
	
	@XmlElement(name="participant_name")
	private String name;
	
	@XmlElement(name="contestantnum")
	private long contestantNum;
	
	@XmlElement(name="rotnum")
	private long rotNum;
	
	@XmlElement(name="visiting_home_draw")
	@XmlJavaTypeAdapter(ParticipantNameAdaptor.class)
	private PinnacleParticipantStatus status;
	
	@XmlElement(name="odds")
	private PinnacleOdds odds;
	
	/**
	 * 
	 */
	public PinnacleParticipant() {
		
	}

	/* (non-Javadoc)
	 * @see cc.xuloo.pinnacle.model.IPinnacleParticipant#getName()
	 */
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see cc.xuloo.pinnacle.model.IPinnacleParticipant#getContestantNum()
	 */
	public long getContestantNum() {
		return contestantNum;
	}

	/* (non-Javadoc)
	 * @see cc.xuloo.pinnacle.model.IPinnacleParticipant#getRotNum()
	 */
	public long getRotNum() {
		return rotNum;
	}

	/* (non-Javadoc)
	 * @see cc.xuloo.pinnacle.model.IPinnacleParticipant#getStatus()
	 */
	public PinnacleParticipantStatus getStatus() {
		return status;
	}

	/* (non-Javadoc)
	 * @see cc.xuloo.pinnacle.model.IPinnacleParticipant#getOdds()
	 */
	public PinnacleOdds getOdds() {
		return odds;
	}
	
	public boolean equals(PinnacleParticipant other) {
		return contestantNum == other.contestantNum && status.equals(other.status);
	}
}
