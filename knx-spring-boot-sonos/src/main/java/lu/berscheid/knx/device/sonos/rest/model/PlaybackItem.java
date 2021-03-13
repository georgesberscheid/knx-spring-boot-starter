package lu.berscheid.knx.device.sonos.rest.model;

import lombok.Data;

@Data
public class PlaybackItem {
	private String id;
	private Track track;
	private boolean deleted;
	private Policies policies;
	
}
