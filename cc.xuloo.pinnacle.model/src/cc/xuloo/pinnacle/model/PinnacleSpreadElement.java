package cc.xuloo.pinnacle.model;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.builder.EqualsBuilder;

@XmlRootElement(name="spread")
public class PinnacleSpreadElement {
	
	@XmlElement(name="awaySpread")
	private BigDecimal awaySpread;
	
	@XmlElement(name="awayPrice")
	private BigDecimal awayPrice;
	
	@XmlElement(name="homeSpread")
	private BigDecimal homeSpread;
	
	@XmlElement(name="homePrice")
	private BigDecimal homePrice;

	public PinnacleSpreadElement() {
		
	}

	public BigDecimal getAwaySpread() {
		return awaySpread;
	}

	public BigDecimal getAwayPrice() {
		return awayPrice;
	}

	public BigDecimal getHomeSpread() {
		return homeSpread;
	}

	public BigDecimal getHomePrice() {
		return homePrice;
	}
	
	public boolean equals(Object obj) {
		
		if (obj == null) return false;
		if (obj == this) return true;
		if (obj.getClass() != getClass()) return false;
		
		PinnacleSpreadElement rhs = (PinnacleSpreadElement) obj;
		
		return new EqualsBuilder()
			.append(awaySpread, rhs.getAwaySpread())
			.append(awayPrice, rhs.getAwayPrice())
			.append(homePrice, rhs.getHomePrice())
			.append(homeSpread, rhs.getHomeSpread())
			.isEquals();
	}
}
