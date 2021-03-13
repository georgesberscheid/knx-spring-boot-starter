package lu.berscheid.knx.device.sonos.rest.model;

import lombok.Data;

@Data
public class PlaybackError {
	private PlaybackErrorCode errorCode;
	private int httpStatus;
	private String itemId;
	private String queueVersion;
	private String reason;
}
