package lu.berscheid.knx.device.sonos.rest.model;

import lombok.Data;

@Data
public class PlayerVolume {
	private boolean muted;
	private boolean fixed;
	private int number;
}
