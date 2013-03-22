package cc.xuloo.pinnacle.model.adaptors;

import java.math.BigDecimal;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class ToBaseAdaptor extends XmlAdapter<String, Double> {

	@Override
	public String marshal(Double value) throws Exception {
		return value.toString();
	}

	@Override
	public Double unmarshal(String value) throws Exception {
		return new Double(new BigDecimal(value).doubleValue());
	}

}
