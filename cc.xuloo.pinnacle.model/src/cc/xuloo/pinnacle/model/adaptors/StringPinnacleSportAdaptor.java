package cc.xuloo.pinnacle.model.adaptors;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import cc.xuloo.pinnacle.PinnacleSportType;

public class StringPinnacleSportAdaptor extends XmlAdapter<String, PinnacleSportType> {

	@Override
	public String marshal(PinnacleSportType value) throws Exception {
		return PinnacleSportType.toString(value);
	}

	@Override
	public PinnacleSportType unmarshal(String value) throws Exception {
		return PinnacleSportType.from(value);
	}

}
