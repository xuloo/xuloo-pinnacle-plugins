package cc.xuloo.pinnacle.model;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.builder.EqualsBuilder;

@XmlRootElement(name="moneyLine")
public class PinnacleMoneylineElement {
	
	@XmlElement(name="homePrice")
	private BigDecimal homePrice;
	
	@XmlElement(name="awayPrice")
	private BigDecimal awayPrice;
	
	@XmlElement(name="drawPrice")
	private BigDecimal drawPrice;
	
	/**
	 * 
	 */
	public PinnacleMoneylineElement() {
		
	}
	
	public BigDecimal getHomePrice() {
		return homePrice;
	}

	public BigDecimal getAwayPrice() {
		return awayPrice;
	}

	public BigDecimal getDrawPrice() {
		return drawPrice;
	}
	
	public boolean equals(Object obj) {
		
		if (obj == null) return false;
		if (obj == this) return true;
		if (obj.getClass() != getClass()) return false;
		
		PinnacleMoneylineElement other = (PinnacleMoneylineElement) obj;
		
		return new EqualsBuilder()
			.append(homePrice, other.getHomePrice())
			.append(awayPrice, other.getAwayPrice())
			.append(drawPrice, other.getDrawPrice())
			.isEquals();
	}
}
