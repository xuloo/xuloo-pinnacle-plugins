package cc.xuloo.pinnacle.model.adaptors;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.apache.commons.lang3.StringUtils;

public class MoneylineValueAdaptor extends XmlAdapter<String, Integer> {

	@Override
	public String marshal(Integer value) throws Exception {
		return value.toString();
	}

	@Override
	public Integer unmarshal(String value) throws Exception {
//		if (StringUtils.containsIgnoreCase("e", value)) {
//			if (StringUtils.startsWith(value, "-")) return Integer.MIN_VALUE;
//		}
		return new Integer(new BigDecimal(value).intValue());
	}

}
