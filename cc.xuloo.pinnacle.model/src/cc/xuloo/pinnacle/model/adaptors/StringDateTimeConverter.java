package cc.xuloo.pinnacle.model.adaptors;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class StringDateTimeConverter extends XmlAdapter<String, DateTime> {

	@Override
	public String marshal(DateTime value) throws Exception {
		DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm");
		return fmt.print(value);
	}

	@Override
	public DateTime unmarshal(String value) throws Exception {
		DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm");
		return fmt.parseDateTime(value);
	}

}
