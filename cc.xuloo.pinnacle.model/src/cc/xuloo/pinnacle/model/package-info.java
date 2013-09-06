@XmlJavaTypeAdapters({
	@XmlJavaTypeAdapter(value=LongDateTimeAdaptor.class, type=DateTime.class),
	@XmlJavaTypeAdapter(value=StringPinnacleSportAdaptor.class, type=PinnacleSportType.class),
	@XmlJavaTypeAdapter(value=StringPinnacleParticipantStatusAdaptor.class, type=PinnacleParticipantStatus.class),
	@XmlJavaTypeAdapter(value=BigDecimalAdaptor.class, type=BigDecimal.class)
})
package cc.xuloo.pinnacle.model;

import java.math.BigDecimal;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters;

import org.joda.time.DateTime;

import cc.xuloo.pinnacle.PinnacleParticipantStatus;
import cc.xuloo.pinnacle.PinnacleSportType;
import cc.xuloo.pinnacle.model.adaptors.BigDecimalAdaptor;
import cc.xuloo.pinnacle.model.adaptors.LongDateTimeAdaptor;
import cc.xuloo.pinnacle.model.adaptors.StringPinnacleParticipantStatusAdaptor;
import cc.xuloo.pinnacle.model.adaptors.StringPinnacleSportAdaptor;
