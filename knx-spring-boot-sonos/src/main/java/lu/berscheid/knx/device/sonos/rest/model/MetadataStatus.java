package lu.berscheid.knx.device.sonos.rest.model;

import lombok.Data;

@Data
public class MetadataStatus {
	private PlaybackContainer container;
	private PlaybackItem currentItem;
	private PlaybackItem nextItem;
	private String streamInfo;
}
