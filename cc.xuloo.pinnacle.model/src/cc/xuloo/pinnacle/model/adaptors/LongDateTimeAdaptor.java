package cc.xuloo.pinnacle.model.adaptors;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.joda.time.DateTime;

public class LongDateTimeAdaptor extends XmlAdapter<Long, DateTime> {

	@Override
	public Long marshal(DateTime value) throws Exception {
		return value.getMillis();
	}

	@Override
	public DateTime unmarshal(Long value) throws Exception {
		return new DateTime(value);
	}

}
