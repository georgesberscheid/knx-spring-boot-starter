package lu.berscheid.knx.device.sonos.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lu.berscheid.knx.device.sonos.SonosDevice;
import lu.berscheid.knx.device.sonos.rest.model.GroupVolume;
import lu.berscheid.knx.device.sonos.rest.model.MetadataStatus;
import lu.berscheid.knx.device.sonos.rest.model.PlaybackError;
import lu.berscheid.knx.device.sonos.rest.model.PlaybackStatus;
import lu.berscheid.knx.device.sonos.rest.model.PlayerVolume;

@Api
@RestController
@RequestMapping("/device/sonos")
@Validated
@NoArgsConstructor
@Slf4j
public class SubscriptionController {

	@Autowired
	private SonosDevice sonosDevice;

	@PostMapping(value = "/subscription",
			consumes = "application/json",
			headers = "X-Sonos-Type=groupVolume")
	public void groupVolumeEvent(@RequestHeader(value = "X-Sonos-Target-Value") String groupId,
			@RequestBody GroupVolume groupVolume) {
		log.info("Received groupVolume event for group " + groupId + ": " + groupVolume);
	}

	@PostMapping(value = "/subscription",
			consumes = "application/json",
			headers = "X-Sonos-Type=playerVolume")
	public void playerVolumeEvent(@RequestHeader(value = "X-Sonos-Target-Value") String playerId,
			@RequestBody PlayerVolume playerVolume) {
		log.info("Received playerVolume event for player " + playerId + ": " + playerVolume);
		sonosDevice.writePlayerVolume(playerId, playerVolume);
	}

	@PostMapping(value = "/subscription",
			consumes = "application/json",
			headers = "X-Sonos-Type=playbackStatus")
	public void playbackStatusEvent(@RequestHeader(value = "X-Sonos-Target-Value") String groupId,
			@RequestBody PlaybackStatus playbackStatus) {
		log.info("Received playbackStatus event for group " + groupId + ": " + playbackStatus);
	}

	@PostMapping(value = "/subscription",
			consumes = "application/json",
			headers = "X-Sonos-Type=playbackError")
	public void playbackErrorEvent(@RequestHeader(value = "X-Sonos-Target-Value") String groupId,
			@RequestBody PlaybackError playbackError) {
		log.info("Received playbackError event for group " + groupId + ": " + playbackError);
	}

	@PostMapping(value = "/subscription",
			consumes = "application/json",
			headers = "X-Sonos-Type=metadataStatus")
	public void metadataStatusEvent(@RequestHeader(value = "X-Sonos-Target-Value") String groupId,
			@RequestBody MetadataStatus metadataStatus) {
		log.info("Received metadataStatus event for group " + groupId + ": " + metadataStatus);
		sonosDevice.writeMetadataStatus(groupId, metadataStatus);
	}
}
