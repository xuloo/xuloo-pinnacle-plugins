package cc.xuloo.pinnacle.model.adaptors;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import cc.xuloo.pinnacle.model.PinnacleSport;

public class StringPinnacleSportAdaptor extends XmlAdapter<String, PinnacleSport> {

	@Override
	public String marshal(PinnacleSport value) throws Exception {
		return PinnacleSport.toString(value);
	}

	@Override
	public PinnacleSport unmarshal(String value) throws Exception {
		return PinnacleSport.from(value);
	}

}
