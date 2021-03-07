package lu.berscheid.knx.device.sonos.rest.model;

import lombok.Data;

@Data
public class PlaybackStatus {

	private PlaybackActions availablePlaybackActions;
	private String itemId;
	private boolean isDucking;
	private PlaybackState playbackState;
	private PlayMode playModes;
	private int positionMillis;
	private String previousItemId;
	private int previousPositionMillis;
	private String queueVersion;
}
