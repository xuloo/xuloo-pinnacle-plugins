package cc.xuloo.pinnacle.model.adaptors;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import cc.xuloo.pinnacle.model.PinnacleParticipantStatus;

public class StringPinnacleParticipantStatusAdaptor extends XmlAdapter<String, PinnacleParticipantStatus> {

	@Override
	public String marshal(PinnacleParticipantStatus v) throws Exception {
		return v.getName();
	}

	@Override
	public PinnacleParticipantStatus unmarshal(String v) throws Exception {
		return PinnacleParticipantStatus.from(v);
	}

}
