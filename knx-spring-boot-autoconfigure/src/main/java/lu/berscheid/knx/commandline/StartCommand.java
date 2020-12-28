package lu.berscheid.knx.commandline;

import java.util.List;

import org.springframework.stereotype.Component;

import com.github.rvesse.airline.annotations.Command;
import com.github.rvesse.airline.annotations.Option;

import lombok.extern.slf4j.Slf4j;
import lu.berscheid.knx.KnxDeviceManager;
import lu.berscheid.knx.model.KnxDeviceConfig;
import lu.berscheid.knx.model.KnxException;

@Component
@Command(name = "start", description = "Start the KNX devices")
@Slf4j
public class StartCommand implements KnxRunnable {

	@Option(name = { "-i",
			"--gatewayIpAddress" }, description = "The IP address of the tunneling gateway. If specified, a tunneling connection is created with the given IP address. "
					+ "If not specified a routing connection is attempted.")
	private String ipAddress;

	@Option(name = { "-p", "--port" }, description = "The port used to connect to the IP gateway. Defaults to 3671.")
	private int port = 3671;

	@Override
	public void run(List<KnxDeviceConfig> deviceConfigurations) {
		for (KnxDeviceConfig deviceConfig : deviceConfigurations) {
			KnxDeviceManager deviceManager = new KnxDeviceManager(deviceConfig, ipAddress, port);
			try {
				deviceManager.start();
			} catch (KnxException e) {
				log.error("Couldn't start KNX Device " + deviceConfig.getApplicationName(), e);
			}
		}
	}
}
