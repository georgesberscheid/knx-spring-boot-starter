package lu.berscheid.knx.device.sonos.rest.model;

import lombok.Data;

@Data
public class PlaybackContainer {
	private String name;
	private String type;
	private MusicObjectId id;
	private Service service;
	private String imageUrl;
	private Tag[] tag;
}
