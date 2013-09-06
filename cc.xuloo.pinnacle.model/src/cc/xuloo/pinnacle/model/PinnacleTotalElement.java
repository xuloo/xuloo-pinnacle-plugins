package cc.xuloo.pinnacle.model;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.builder.EqualsBuilder;

@XmlRootElement(name="total")
public class PinnacleTotalElement {
	
	@XmlElement(name="points")
	private BigDecimal points;
	
	@XmlElement(name="overPrice")
	private BigDecimal overPrice;
	
	@XmlElement(name="underPrice")
	private BigDecimal underPrice;

	public PinnacleTotalElement() {
		
	}
	
	public BigDecimal getPoints() {
		return points;
	}

	public BigDecimal getOverPrice() {
		return overPrice;
	}

	public BigDecimal getUnderPrice() {
		return underPrice;
	}
	
	public boolean equals(Object obj) {
		
		if (obj == null) return false;
		if (obj == this) return true;
		if (obj.getClass() != getClass()) return false;
		
		PinnacleTotalElement rhs = (PinnacleTotalElement) obj;
		
		return new EqualsBuilder()
			.append(points, rhs.getPoints())
			.append(overPrice, rhs.getOverPrice())
			.append(underPrice, rhs.getUnderPrice())
			.isEquals();
	}
}
