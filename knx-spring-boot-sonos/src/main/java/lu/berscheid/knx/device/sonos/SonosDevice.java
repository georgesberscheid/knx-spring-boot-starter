package lu.berscheid.knx.device.sonos;

import static lu.berscheid.knx.annotations.KnxGroupObject.Flag.C;
import static lu.berscheid.knx.annotations.KnxGroupObject.Flag.R;
import static lu.berscheid.knx.annotations.KnxGroupObject.Flag.T;
import static lu.berscheid.knx.annotations.KnxGroupObject.Flag.W;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.openfeign.EnableFeignClients;

import lombok.extern.slf4j.Slf4j;
import lu.berscheid.knx.annotations.KnxDevice;
import lu.berscheid.knx.annotations.KnxDeviceParameter;
import lu.berscheid.knx.annotations.KnxGroupObject;
import lu.berscheid.knx.annotations.KnxPostRestart;
import lu.berscheid.knx.annotations.KnxPostStart;
import lu.berscheid.knx.annotations.KnxPreShutdown;
import lu.berscheid.knx.annotations.KnxRequestDatapoint;
import lu.berscheid.knx.annotations.KnxUpdateDatapoint;
import lu.berscheid.knx.device.sonos.config.SonosCredentials;
import lu.berscheid.knx.device.sonos.rest.api.GroupVolumeApi;
import lu.berscheid.knx.device.sonos.rest.api.GroupsApi;
import lu.berscheid.knx.device.sonos.rest.api.HouseholdsApi;
import lu.berscheid.knx.device.sonos.rest.api.MetadataApi;
import lu.berscheid.knx.device.sonos.rest.api.PlaybackApi;
import lu.berscheid.knx.device.sonos.rest.api.PlayerVolumeApi;
import lu.berscheid.knx.device.sonos.rest.model.GroupsResponse;
import lu.berscheid.knx.device.sonos.rest.model.Household;
import lu.berscheid.knx.device.sonos.rest.model.HouseholdsResponse;
import lu.berscheid.knx.device.sonos.rest.model.MetadataStatus;
import lu.berscheid.knx.device.sonos.rest.model.Player;
import lu.berscheid.knx.device.sonos.rest.model.PlayerVolume;
import lu.berscheid.knx.model.GroupObject;
import lu.berscheid.knx.model.KnxException;

@Slf4j
@SpringBootApplication
@EnableFeignClients
@KnxDevice(productName = "Sonos",
		hardwareName = "Sonos virtual device",
		applicationName = "Sonos Control",
		applicationVersion = 24,
		applicationNumber = 25,
		hardwareSerialNumber = "Sonos0001",
		productOrderNumber = "PO0001")
public class SonosDevice {

	@Autowired
	private SonosCredentials credentials;

	@Autowired
	private HouseholdsApi householdsApi;

	@Autowired
	private GroupsApi groupsApi;

	@Autowired
	private GroupVolumeApi groupVolumeApi;

	@Autowired
	private PlayerVolumeApi playerVolumeApi;

	@Autowired
	private PlaybackApi playbackApi;

	@Autowired
	private MetadataApi metadataApi;

	@KnxDeviceParameter(sizeInBit = 288, text = "Client ID")
	private String clientId;

	@KnxDeviceParameter(sizeInBit = 288, text = "Client Secret")
	private String clientSecret;

	@KnxDeviceParameter(sizeInBit = 256, text = "Access Token (optional)")
	private String accessToken;

	@KnxDeviceParameter(sizeInBit = 256, text = "Refresh Token (optional)")
	private String refreshToken;

	@KnxDeviceParameter(sizeInBit = 256, text = "Room name")
	private String roomName;

	// The playerId and groupId that belongs to the player
	private String groupId;
	private String playerId;

	@KnxGroupObject(flags = { C, W },
			text = "Start / Stop",
			functionText = "Toggle",
			datapointType = "1.010") // Start / Stop)
	private GroupObject<Boolean> startStopCommand;

	@KnxGroupObject(flags = { C, R, T },
			text = "Start / Stop",
			functionText = "Value for toggle",
			datapointType = "1.010") // Start / Stop
	private GroupObject<Boolean> startStopState;

	@KnxGroupObject(flags = { C, W },
			text = "Player volume",
			functionText = "Set value",
			datapointType = "5.001") // Percentage 0-100%
	private GroupObject<Integer> playerVolumeCommand;

	@KnxGroupObject(flags = { C, R, T },
			text = "Player volume",
			functionText = "Input",
			datapointType = "5.001") // Percentage 0-100%
	private GroupObject<Integer> playerVolumeState;

	@KnxGroupObject(flags = { C, R, T },
			text = "Track name",
			functionText = "Input",
			datapointType = "16.000") // ASCII String
	private GroupObject<String> currentTrackName;

	public static void main(String[] args) {
		// Enable the web server only if 'start' is in the list of program arguments
		WebApplicationType type = Arrays.asList(args).contains("start") ? WebApplicationType.SERVLET
				: WebApplicationType.NONE;
		new SpringApplicationBuilder(SonosDevice.class).web(type).run(args);
	}

	@KnxPostStart
	@KnxPostRestart
	public void postStart() {
		// Load credentials first
		credentials.setClientId(clientId);
		credentials.setClientSecret(clientSecret);
		credentials.setAccessToken(accessToken);
		credentials.setRefreshToken(refreshToken);

		// Retrieve group and player configurations
		HouseholdsResponse householdsResponse = householdsApi.getHouseholds();

		String[] registeredPlayerNames = new String[] { roomName };

		for (Household household : householdsResponse.getHouseholds()) {
			GroupsResponse groupsResponse = groupsApi.getGroups(household.getId());
			household.setPlayers(groupsResponse.getPlayers());
			household.setGroups(groupsResponse.getGroups());

			// Register callback subscriptions for each player name
			Arrays.stream(household.getPlayers()).forEach(
					player -> Arrays.asList(registeredPlayerNames).stream().forEach(registeredPlayer -> {
						if (player.getName().equals(registeredPlayer)) {
							playerId = player.getId();
							groupId = player.getGroupId();
							registerCallbacks(player);
						}
					}));
		}
	}

	private void registerCallbacks(Player player) {
		// Register playerVolume, groupVolume and Playback callbacks for this player
		log.info("Registering callbacks for player " + player.getName());
		groupVolumeApi.subscribe(player.getGroupId());
		playerVolumeApi.subscribe(player.getId());
		playbackApi.subscribe(player.getGroupId());
		metadataApi.subscribe(player.getGroupId());
	}

	@KnxPreShutdown
	public void preShutdown() throws KnxException {
		// Updating credentials so they can be persisted with the device configuration
		accessToken = credentials.getAccessToken();
		refreshToken = credentials.getRefreshToken();
	}

	// Start / Stop received from the KNX bus
	@KnxUpdateDatapoint(groupObjectName = "startStopCommand")
	public void updateStartStop(Boolean value) {
		log.info("Received update for startStop group object: " + value);
	}

	// Player volume received from the KNX bus
	@KnxUpdateDatapoint(groupObjectName = "playerVolumeCommand")
	public void updatePlayerVolume(Integer value) {
		log.info("Received update for playerVolume group object: " + value);
	}

	// Start / Stop state request from KNX bus
	@KnxRequestDatapoint(groupObjectName = "startStopState")
	public Boolean requestStartStop() {
		log.info("Requesting value for boolean group object: " + startStopState.getValue());
		return startStopState.getValue();
	}

	// Player volume state request from KNX bus
	@KnxRequestDatapoint(groupObjectName = "playerVolumeState")
	public Integer requestPlayerVolume() {
		log.info("Requesting value for boolean group object: " + playerVolumeState.getValue());
		return playerVolumeState.getValue();
	}

	public void writePlayerVolume(String playerId, PlayerVolume playerVolume) {
		if (this.playerId.equals(playerId)) {
			try {
				playerVolumeState.write(playerVolume.getNumber());
			} catch (KnxException e) {
				log.error("Unable to write player volume  " + playerVolume + " for player " + playerId);
			}
		}
	}

	public void writeMetadataStatus(String groupId, MetadataStatus metadataStatus) {
		if (this.groupId.equals(groupId)) {
			try {
				currentTrackName.write(metadataStatus.getCurrentItem().getTrack().getName());
			} catch (KnxException e) {
				log.error("Unable to write current track name  "
						+ metadataStatus.getCurrentItem().getTrack().getName() + " for group " + groupId);
			}
		}
	}

}
