package cc.xuloo.pinnacle.model.adaptors;

import java.math.BigDecimal;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class BigDecimalAdaptor extends XmlAdapter<String, BigDecimal> {

	@Override
	public String marshal(BigDecimal v) throws Exception {
		return v.toPlainString();
	}

	@Override
	public BigDecimal unmarshal(String v) throws Exception {
		return new BigDecimal(v);
	}

}
