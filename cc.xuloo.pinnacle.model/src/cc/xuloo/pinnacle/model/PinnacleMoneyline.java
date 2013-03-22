package cc.xuloo.pinnacle.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="moneyline")
public class PinnacleMoneyline {
	
	@XmlElement(name="moneyline_home")
	private int home;
	
	@XmlElement(name="moneyline_visiting")
	private int visiting;
	
	@XmlElement(name="moneyline_draw")
	private int draw;
	
	/**
	 * 
	 */
	public PinnacleMoneyline() {
		
	}

	/* (non-Javadoc)
	 * @see cc.xuloo.pinnacle.model.IPinnacleMoneyline#getHome()
	 */
	public int getHome() {
		return home;
	}

	/* (non-Javadoc)
	 * @see cc.xuloo.pinnacle.model.IPinnacleMoneyline#getVisiting()
	 */
	public int getVisiting() {
		return visiting;
	}

	/* (non-Javadoc)
	 * @see cc.xuloo.pinnacle.model.IPinnacleMoneyline#getDraw()
	 */
	public int getDraw() {
		return draw;
	}
	
	/* (non-Javadoc)
	 * @see cc.xuloo.pinnacle.model.IPinnacleMoneyline#equals(cc.xuloo.pinnacle.model.IPinnacleMoneyline)
	 */
	public boolean equals(PinnacleMoneyline other) {
		return getHome() == other.getHome() && getVisiting() == other.getVisiting() && getDraw() == other.getDraw();
	}
}
