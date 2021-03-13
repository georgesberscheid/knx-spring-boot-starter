package lu.berscheid.knx.device.sonos.rest.model;

import lombok.Data;

@Data
public class Album {
	private String name;
	private Artist artist;
	private String imageUrl;
	private MusicObjectId id;
	private Tag[] tags;
}
