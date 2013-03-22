package cc.xuloo.pinnacle.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import cc.xuloo.pinnacle.model.adaptors.MoneylineValueAdaptor;
import cc.xuloo.pinnacle.model.adaptors.ToBaseAdaptor;

@XmlRootElement(name="odds")
public class PinnacleOdds {

	@XmlElement(name="moneyline_value")
	@XmlJavaTypeAdapter(MoneylineValueAdaptor.class)
	private Integer moneylineValue;
	
	@XmlElement(name="to_base")
	@XmlJavaTypeAdapter(ToBaseAdaptor.class)
	private Double toBase;
	
	/**
	 * 
	 */
	public PinnacleOdds() {
		
	}

	/**
	 * @return the moneylineValue
	 */
	public int getMoneylineValue() {
		return moneylineValue;
	}

	/**
	 * @return the toBase
	 */
	public Double getToBase() {
		return toBase;
	}
}
