package lu.berscheid.knx.device.sonos.rest.model;

import lombok.Data;

@Data
public class Track {
	private boolean canCrossfade;
	private boolean canSkip;
	private int durationMillis;
	private MusicObjectId id;
	private String imageUrl;
	private String name;
	private int replayGain;
	private Tag[] tags;
	private String type;
	private Service service;
	
	private int trackNumber;
	private Artist artist;
	private Album album;
	
	private String mediaUrl;
	private String contentType;
}
