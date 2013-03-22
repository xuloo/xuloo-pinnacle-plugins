package cc.xuloo.pinnacle.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import cc.xuloo.sports.utils.EqualsUtils;

@XmlRootElement(name="spread")
public class PinnacleSpread {
	
	@XmlElement(name="spread_visiting")
	private double spreadVisiting;
	
	@XmlElement(name="spread_adjust_visiting")
	private double spreadAdjustVisiting;
	
	@XmlElement(name="spread_home")
	private double spreadHome;
	
	@XmlElement(name="spread_adjust_home")
	private double spreadAdjustHome;
	
	/**
	 * 
	 */
	public PinnacleSpread() {
		
	}

	/* (non-Javadoc)
	 * @see cc.xuloo.pinnacle.model.IPinnacleSpread#getSpreadVisiting()
	 */
	public double getSpreadVisiting() {
		return spreadVisiting;
	}

	/* (non-Javadoc)
	 * @see cc.xuloo.pinnacle.model.IPinnacleSpread#getSpreadAdjustVisiting()
	 */
	public double getSpreadAdjustVisiting() {
		return spreadAdjustVisiting;
	}

	/* (non-Javadoc)
	 * @see cc.xuloo.pinnacle.model.IPinnacleSpread#getSpreadHome()
	 */
	public double getSpreadHome() {
		return spreadHome;
	}

	/* (non-Javadoc)
	 * @see cc.xuloo.pinnacle.model.IPinnacleSpread#getSpreadAdjustHome()
	 */
	public double getSpreadAdjustHome() {
		return spreadAdjustHome;
	}
	
	/* (non-Javadoc)
	 * @see cc.xuloo.pinnacle.model.IPinnacleSpread#equals(cc.xuloo.pinnacle.model.IPinnacleSpread)
	 */
	public boolean equals(PinnacleSpread other) {
		return EqualsUtils.areEqual(getSpreadVisiting(), other.getSpreadVisiting()) &&
			   EqualsUtils.areEqual(getSpreadAdjustVisiting(), other.getSpreadAdjustVisiting()) &&
			   EqualsUtils.areEqual(getSpreadHome(), other.getSpreadHome()) &&
			   EqualsUtils.areEqual(getSpreadAdjustHome(), other.getSpreadAdjustHome());
	}
}
