package lu.berscheid.knx.device.sonos.rest.model;

import lombok.Data;

@Data
public class Artist {
	private String name;
	private String imageUrl;
	private MusicObjectId id;
	private Tag[] tags;
}
