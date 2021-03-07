package lu.berscheid.knx.device.sonos.rest.model;

import lombok.Data;

@Data
public class GroupVolume {
	private boolean muted;
	private boolean fixed;
	private int number;
}
