package cc.xuloo.pinnacle.model.adaptors;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import cc.xuloo.sports.utils.NameUtils;

public class ParticipantNameAdaptor extends XmlAdapter<String, String> {

	@Override
	public String marshal(String val) throws Exception {
		return val;
	}

	@Override
	public String unmarshal(String val) throws Exception {
		return NameUtils.clean(val);
	}

}
