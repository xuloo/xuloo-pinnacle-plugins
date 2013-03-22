package cc.xuloo.pinnacle.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import cc.xuloo.sports.utils.EqualsUtils;

@XmlRootElement(name="total")
public class PinnacleTotal {
	
	@XmlElement(name="total_points")
	private double totalPoints;
	
	@XmlElement(name="over_adjust")
	private double overAdjust;
	
	@XmlElement(name="under_adjust")
	private double underAdjust;
	
	/**
	 * 
	 */
	public PinnacleTotal() {
		
	}

	/* (non-Javadoc)
	 * @see cc.xuloo.pinnacle.model.IPinnacleTotal#getTotalPoints()
	 */
	public double getTotalPoints() {
		return totalPoints;
	}

	/* (non-Javadoc)
	 * @see cc.xuloo.pinnacle.model.IPinnacleTotal#getOverAdjust()
	 */
	public double getOverAdjust() {
		return overAdjust;
	}

	/* (non-Javadoc)
	 * @see cc.xuloo.pinnacle.model.IPinnacleTotal#getUnderAdjust()
	 */
	public double getUnderAdjust() {
		return underAdjust;
	}
	
	/* (non-Javadoc)
	 * @see cc.xuloo.pinnacle.model.IPinnacleTotal#equals(cc.xuloo.pinnacle.model.IPinnacleTotal)
	 */
	public boolean equals(PinnacleTotal other) {
		return EqualsUtils.areEqual(getTotalPoints(), other.getTotalPoints()) &&
			   EqualsUtils.areEqual(getOverAdjust(), other.getOverAdjust()) &&
			   EqualsUtils.areEqual(getUnderAdjust(), other.getUnderAdjust());
	}
}
