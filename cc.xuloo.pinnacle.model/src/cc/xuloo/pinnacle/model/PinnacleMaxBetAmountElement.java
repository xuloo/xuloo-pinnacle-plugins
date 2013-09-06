package cc.xuloo.pinnacle.model;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="maxBetAmount")
public class PinnacleMaxBetAmountElement {

	@XmlElement(name="spread")
	private BigDecimal spread;
	
	@XmlElement(name="totalPoints")
	private BigDecimal totalPoints;
	
	@XmlElement(name="moneyLine")
	private BigDecimal moneyLine;

	public BigDecimal getSpread() {
		return spread;
	}

	public BigDecimal getTotalPoints() {
		return totalPoints;
	}

	public BigDecimal getMoneyLine() {
		return moneyLine;
	}
}
