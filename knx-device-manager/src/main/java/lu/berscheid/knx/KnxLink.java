package lu.berscheid.knx;

import java.net.InetSocketAddress;
import java.net.NetworkInterface;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lu.berscheid.knx.model.KnxException;
import tuwien.auto.calimero.GroupAddress;
import tuwien.auto.calimero.IndividualAddress;
import tuwien.auto.calimero.KNXException;
import tuwien.auto.calimero.dptxlator.DPTXlator8BitUnsigned;
import tuwien.auto.calimero.link.KNXNetworkLink;
import tuwien.auto.calimero.link.KNXNetworkLinkIP;
import tuwien.auto.calimero.link.medium.KnxIPSettings;
import tuwien.auto.calimero.process.ProcessCommunicator;
import tuwien.auto.calimero.process.ProcessCommunicatorImpl;

public class KnxLink {

	private static final Logger LOG = LoggerFactory.getLogger(KnxLink.class);

	private KNXNetworkLink link;
	private ProcessCommunicator communicator;

	public KnxLink(String deviceAddress) {
		// Creates a routing link on 224.0.23.12 port 3671
		try {
			link = KNXNetworkLinkIP.newRoutingLink((NetworkInterface) null, null,
					new KnxIPSettings(new IndividualAddress(deviceAddress)));
			communicator = new ProcessCommunicatorImpl(link);
			LOG.info("Connection to KNX router established.");
		} catch (KNXException e) {
			LOG.error("Unable to create link to KNX router.", e);
		}
	}

	public KnxLink(String deviceAddress, String ipGatewayAddress, int port) {
		// Creates a tunneling link on the given IP address and port
		try {
			link = KNXNetworkLinkIP.newTunnelingLink(new InetSocketAddress(25000),
					new InetSocketAddress(ipGatewayAddress, port), false,
					new KnxIPSettings(new IndividualAddress(deviceAddress)));
			communicator = new ProcessCommunicatorImpl(link);
			LOG.info("Connection to KNX IP gateway established: " + ipGatewayAddress);
		} catch (KNXException | InterruptedException e) {
			LOG.error("Unable to create link to KNX IP gateway.", e);
		}
	}

	public void write(String groupAddress, Object value) throws KnxException {
		try {
			if (value instanceof Boolean) {
				communicator.write(new GroupAddress(groupAddress), (Boolean) value);
			} else if (value instanceof Integer) {
				communicator.write(new GroupAddress(groupAddress), (Integer) value,
						DPTXlator8BitUnsigned.DPT_ANGLE.getID());
			} else if (value instanceof String) {
				communicator.write(new GroupAddress(groupAddress), (String) value);
			}
		} catch (KNXException e) {
			throw new KnxException("Unable to send message to KNX bus.", e);
		}
	}

	KNXNetworkLink getLink() {
		return link;
	}
}
