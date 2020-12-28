package lu.berscheid.knx;

import java.util.Collection;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import lu.berscheid.knx.model.GroupObject;
import lu.berscheid.knx.model.KnxException;

@Data
@Slf4j
public class GroupObjectImpl implements GroupObject<Object> {

	private Collection<String> groupAddresses;
	private KnxLink knxLink;
	private Object value;

	@Override
	public void write(Object value) throws KnxException {
		// Store the value that we sent
		setValue(value);

		// Then dispatch the value to all group addresses belonging to this group object
		for (String groupAddress : groupAddresses) {
			try {
				log.info("Sending value " + value + " to address " + groupAddress);
				knxLink.write(groupAddress, value);
			} catch (Exception e) {
				log.error(
						"Unable to send value " + value + " to group address " + groupAddress + " on link " + getKnxLink(),
						e);
			}
		}
	}
}
