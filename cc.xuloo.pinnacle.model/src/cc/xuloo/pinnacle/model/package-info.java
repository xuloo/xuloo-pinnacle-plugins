@XmlJavaTypeAdapters({
	@XmlJavaTypeAdapter(value=LongDateTimeAdaptor.class, type=DateTime.class),
	@XmlJavaTypeAdapter(value=StringPinnacleSportAdaptor.class, type=PinnacleSport.class),
	@XmlJavaTypeAdapter(value=StringPinnacleParticipantStatusAdaptor.class, type=PinnacleParticipantStatus.class)
})
package cc.xuloo.pinnacle.model;

import cc.xuloo.pinnacle.model.PinnacleSport;
import cc.xuloo.pinnacle.model.PinnacleParticipantStatus;
import cc.xuloo.pinnacle.model.adaptors.*;

import javax.xml.bind.annotation.adapters.*;

import org.joda.time.DateTime;