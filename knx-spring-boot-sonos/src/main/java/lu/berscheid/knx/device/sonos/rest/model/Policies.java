package lu.berscheid.knx.device.sonos.rest.model;

import lombok.Data;

@Data
public class Policies {
	private boolean canSkip;
	private boolean canSkipToItem;
	private boolean canCrossFade;
	private boolean isVisible;
}
