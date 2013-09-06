package cc.xuloo.pinnacle.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name="league")
public class PinnacleLeagueLeagueElement {

	@XmlAttribute(name="id")
	private Integer id;
	
	@XmlValue
	private String name;
	
	@XmlAttribute(name="feedContents")
	private boolean feedContents;
	
	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public boolean isFeedContents() {
		return feedContents;
	}
}
