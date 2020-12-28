package lu.berscheid.knx.commandline;

import java.util.List;

import lu.berscheid.knx.model.KnxDeviceConfig;

public interface KnxRunnable extends Runnable {

	public void run(List<KnxDeviceConfig> configs);

	default void run() {
	};
}
