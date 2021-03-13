package lu.berscheid.knx.device.sonos.rest.model;

import lombok.Data;

@Data
public class MusicObjectId {
	private String serviceId;
	private String objectId;
	private String accountId;
}
