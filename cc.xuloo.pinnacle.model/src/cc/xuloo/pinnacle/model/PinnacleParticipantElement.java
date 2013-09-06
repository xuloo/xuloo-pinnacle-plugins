package cc.xuloo.pinnacle.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.builder.EqualsBuilder;

import cc.xuloo.pinnacle.PinnacleParticipantStatus;

@XmlRootElement
public class PinnacleParticipantElement {
	
	@XmlElement(name="name")
	private String name;
	
	@XmlElement(name="rotnum")
	private long rotNum;

	private PinnacleParticipantStatus status;
	
	public PinnacleParticipantElement() {
		
	}

	public String getName() {
		return name;
	}

	public long getRotNum() {
		return rotNum;
	}
	
	public PinnacleParticipantStatus getStatus() {
		return status;
	}
	
	public void setStatus(PinnacleParticipantStatus status) {
		this.status = status;
	}
	
	public boolean equals(Object obj) {
		
		if (obj == null) return false;
		if (obj == this) return true;
		if (obj.getClass() != getClass()) return false;
		
		PinnacleParticipantElement other = (PinnacleParticipantElement) obj;
		
		return new EqualsBuilder().append(name, other.getName()).isEquals();
	}

	@Override
	public String toString() {
		return "PinnacleParticipant [name=" + name + ", rotNum=" + rotNum + "]";
	}
}
