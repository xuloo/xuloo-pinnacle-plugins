package cc.xuloo.pinnacle.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.joda.time.DateTime;

import cc.xuloo.pinnacle.model.adaptors.StringDateTimeConverter;

@XmlRootElement(name="period")
public class PinnaclePeriodElement {
	
	@XmlElement(name="number")
	private int number;
	
	@XmlElement(name="description")
	private String description;
	
	@XmlElement(name="cutoffDateTime")
	@XmlJavaTypeAdapter(StringDateTimeConverter.class)
	private DateTime cutoffDateTime;
	
	@XmlElement(name="maxBetAmount")
	private PinnacleMaxBetAmountElement maxBetAmount;
	
	@XmlElement(name="moneyLine")
	private PinnacleMoneylineElement moneyLine;
	
	@XmlElementWrapper(name="totals")
	@XmlElement(name="total")
	private List<PinnacleTotalElement> totals;
	
	@XmlElementWrapper(name="spreads")
	@XmlElement(name="spread")
	private List<PinnacleSpreadElement> spreads;

	public PinnaclePeriodElement() {
		
	}
	
	public int getNumber() {
		return number;
	}

	public String getDescription() {
		return description;
	}

	public DateTime getCutoffDateTime() {
		return cutoffDateTime;
	}

	public PinnacleMaxBetAmountElement getMaxBetAmount() {
		return maxBetAmount;
	}

	public PinnacleMoneylineElement getMoneyLine() {
		return moneyLine;
	}

	public List<PinnacleTotalElement> getTotals() {
		return totals;
	}

	public List<PinnacleSpreadElement> getSpreads() {
		return spreads;
	}
	
	public boolean equals(Object obj) {
		
		if (obj == null) return false;
		if (obj == this) return true;
		if (obj.getClass() != getClass()) return false;
		
		PinnaclePeriodElement rhs = (PinnaclePeriodElement) obj;
		
		return new EqualsBuilder().append(number, rhs.getNumber()).isEquals();
	}
}
