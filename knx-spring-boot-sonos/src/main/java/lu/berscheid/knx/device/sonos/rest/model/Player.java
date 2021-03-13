package lu.berscheid.knx.device.sonos.rest.model;

import lombok.Data;

@Data
public class Player {
	private String id;
	private String apiVersion;
	private String[] deviceIds;
	private String icon;
	private String minApiVersion;
	private String name;
	private String softwareVersion;
	private String webSocketUrl;
	private Capability[] capabilities;
	private String groupId;

	public enum Capability {
		PLAYBACK, CLOUD, HT_PLAYBACK, HT_POWER_STATE, AIRPLAY, LINE_IN, AUDIO_CLIP, VOICE, SPEAKER_DETECTION,
		FIXED_VOLUME
	}
}
