package lu.berscheid.knx;

import java.util.List;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import lu.berscheid.knx.model.GroupObject;
import lu.berscheid.knx.model.KnxException;
import lu.berscheid.knx.model.KnxGroupObjectConfig;

/*
 * The implementation of GroupObject that is getting injected into KNX devices during start up.
 * Allows reading and writing values from and to the bus.
 */
@Slf4j
public class GroupObjectImpl implements GroupObject<Object> {

	@Getter
	@Setter(value = AccessLevel.PACKAGE)
	private List<String> groupAddresses;

	private KnxLink knxLink;
	private KnxGroupObjectConfig config;

	@Getter
	@Setter
	private Object value;

	GroupObjectImpl(KnxLink knxLink, List<String> groupAddresses, KnxGroupObjectConfig config) {
		this.knxLink = knxLink;
		this.groupAddresses = groupAddresses;
		this.config = config;
	}

	@Override
	public void write(Object value) throws KnxException {
		// Store the value that we sent
		setValue(value);

		// Then dispatch the value to all group addresses belonging to this group object
		for (String groupAddress : groupAddresses) {
			try {
				log.info("Sending value " + value + " to address " + groupAddress);
				knxLink.write(groupAddress, value, config);
			} catch (Exception e) {
				log.error("Unable to send value " + value + " to group address " + groupAddress
						+ " on link " + knxLink, e);
			}
		}
	}

	@Override
	public Object read() throws KnxException {
		if (groupAddresses.size() == 0) {
			log.debug("Group object has no group addresses. Reading nothing.");
			return null;
		}
		String groupAddress = groupAddresses.get(0);
		Object value = knxLink.read(groupAddress, config);
		setValue(value);
		return value;
	}
}
