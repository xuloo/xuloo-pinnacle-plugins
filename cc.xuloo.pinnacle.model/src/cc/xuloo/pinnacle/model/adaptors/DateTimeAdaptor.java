package cc.xuloo.pinnacle.model.adaptors;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class DateTimeAdaptor extends XmlAdapter<String, DateTime> {

	private DateTimeFormatter format = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ssZ");
	
	@Override
	public String marshal(DateTime v) throws Exception {
		return format.print(v);
	}

	@Override
	public DateTime unmarshal(String v) throws Exception {
		return format.parseDateTime(v);
	}

}
