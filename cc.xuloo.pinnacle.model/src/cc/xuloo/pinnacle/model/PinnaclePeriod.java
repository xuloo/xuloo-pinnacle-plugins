package cc.xuloo.pinnacle.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.joda.time.DateTime;

import cc.xuloo.pinnacle.model.adaptors.StringDateTimeConverter;

@XmlRootElement(name="period")
public class PinnaclePeriod {
	
	@XmlElement(name="period_number")
	private int periodNumber;
	
	@XmlElement(name="period_description")
	private String periodDescription;
	
	@XmlElement(name="periodcutoff_datetimeGMT")
	@XmlJavaTypeAdapter(StringDateTimeConverter.class)
	private DateTime periodCutoff;
	
	@XmlElement(name="period_status")
	private String periodStatus;
	
	@XmlElement(name="period_update")
	private String periodUpdate;
	
	@XmlElement(name="spread_maximum")
	private double spreadMaximum;
	
	@XmlElement(name="moneyline_maximum")
	private double moneylineMaximum;
	
	@XmlElement(name="total_maximum")
	private double totalMaximum;
	
	@XmlElement(name="moneyline")
	private PinnacleMoneyline moneyLine;
	
	@XmlElement(name="total")
	private PinnacleTotal total;
	
	@XmlElement(name="spread")
	private PinnacleSpread spread;
	
	/**
	 * 
	 */
	public PinnaclePeriod() {
		
	}

	/* (non-Javadoc)
	 * @see cc.xuloo.pinnacle.model.IPinnaclePeriod#getPeriodNumber()
	 */
	public int getPeriodNumber() {
		return periodNumber;
	}

	/* (non-Javadoc)
	 * @see cc.xuloo.pinnacle.model.IPinnaclePeriod#getPeriodDescription()
	 */
	public String getPeriodDescription() {
		return periodDescription;
	}

	/* (non-Javadoc)
	 * @see cc.xuloo.pinnacle.model.IPinnaclePeriod#getPeriodCutoff()
	 */
	public DateTime getPeriodCutoff() {
		return periodCutoff;
	}

	/* (non-Javadoc)
	 * @see cc.xuloo.pinnacle.model.IPinnaclePeriod#getPeriodStatus()
	 */
	public String getPeriodStatus() {
		return periodStatus;
	}

	/* (non-Javadoc)
	 * @see cc.xuloo.pinnacle.model.IPinnaclePeriod#getPeriodUpdate()
	 */
	public String getPeriodUpdate() {
		return periodUpdate;
	}

	/* (non-Javadoc)
	 * @see cc.xuloo.pinnacle.model.IPinnaclePeriod#getSpreadMaximum()
	 */
	public double getSpreadMaximum() {
		return spreadMaximum;
	}

	/* (non-Javadoc)
	 * @see cc.xuloo.pinnacle.model.IPinnaclePeriod#getMoneylineMaximum()
	 */
	public double getMoneylineMaximum() {
		return moneylineMaximum;
	}

	/* (non-Javadoc)
	 * @see cc.xuloo.pinnacle.model.IPinnaclePeriod#getTotalMaximum()
	 */
	public double getTotalMaximum() {
		return totalMaximum;
	}

	/* (non-Javadoc)
	 * @see cc.xuloo.pinnacle.model.IPinnaclePeriod#getMoneyLine()
	 */
	public PinnacleMoneyline getMoneyLine() {
		return moneyLine;
	}

	/* (non-Javadoc)
	 * @see cc.xuloo.pinnacle.model.IPinnaclePeriod#getTotal()
	 */
	public PinnacleTotal getTotal() {
		return total;
	}

	/* (non-Javadoc)
	 * @see cc.xuloo.pinnacle.model.IPinnaclePeriod#getSpread()
	 */
	public PinnacleSpread getSpread() {
		return spread;
	}
	
	public boolean equals(PinnaclePeriod other) {
		return periodNumber == other.getPeriodNumber();
	}
}
