package lu.berscheid.knx.device.sonos.rest.model;

import lombok.Data;

@Data
public class Group {
	private String id;
	private String name;
	private String coordinatorId;
	private PlaybackState playbackState;
	private String[] playerIds;
}
