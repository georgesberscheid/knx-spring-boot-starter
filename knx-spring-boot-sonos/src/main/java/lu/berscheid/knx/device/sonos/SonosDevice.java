package lu.berscheid.knx.device.sonos;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import lombok.extern.slf4j.Slf4j;
import lu.berscheid.knx.annotations.KnxDevice;
import lu.berscheid.knx.annotations.KnxPostStart;
import lu.berscheid.knx.device.sonos.rest.api.GroupVolumeApi;
import lu.berscheid.knx.device.sonos.rest.api.GroupsApi;
import lu.berscheid.knx.device.sonos.rest.api.HouseholdsApi;
import lu.berscheid.knx.device.sonos.rest.api.MetadataApi;
import lu.berscheid.knx.device.sonos.rest.api.PlaybackApi;
import lu.berscheid.knx.device.sonos.rest.api.PlayerVolumeApi;
import lu.berscheid.knx.device.sonos.rest.model.GroupsResponse;
import lu.berscheid.knx.device.sonos.rest.model.Household;
import lu.berscheid.knx.device.sonos.rest.model.HouseholdsResponse;
import lu.berscheid.knx.device.sonos.rest.model.Player;

@Slf4j
@SpringBootApplication
@EnableFeignClients
@KnxDevice(productName = "Sonos", hardwareName = "Sonos virtual device", applicationName = "Sonos Control", applicationVersion = 25, applicationNumber = 25, hardwareSerialNumber = "HW0001", productOrderNumber = "PO0001")
public class SonosDevice {

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

	public static void main(String[] args) {
		SpringApplication.run(SonosDevice.class, args);
	}

	@KnxPostStart
	public void postStart() {
		HouseholdsResponse householdsResponse = householdsApi.getHouseholds();

		String[] registeredPlayerNames = new String[] { "Game Room" };

		for (Household h : householdsResponse.getHouseholds()) {
			GroupsResponse groupsResponse = groupsApi.getGroups(h.getId());
			h.setPlayers(groupsResponse.getPlayers());
			h.setGroups(groupsResponse.getGroups());

			// Register callback subscriptions for each player name
			Arrays.stream(h.getPlayers())
					.filter(player -> Arrays.asList(registeredPlayerNames).contains(player.getName()))
					.forEach(player -> registerCallbacks(player));
		}
	}

	private void registerCallbacks(Player player) {
		// Register playerVolume, groupVolume and Playback callbacks for this player
		groupVolumeApi.subscribe(player.getGroupId());
		playerVolumeApi.subscribe(player.getId());
		playbackApi.subscribe(player.getGroupId());
		metadataApi.subscribe(player.getGroupId());
	}
}
