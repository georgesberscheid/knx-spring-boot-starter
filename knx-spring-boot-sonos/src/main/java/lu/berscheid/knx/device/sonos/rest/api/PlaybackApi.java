package lu.berscheid.knx.device.sonos.rest.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import io.swagger.annotations.Api;
import lu.berscheid.knx.device.sonos.config.FeignApiClientConfiguration;
import lu.berscheid.knx.device.sonos.rest.model.PlaybackStatus;

@Api(value = "Playback")
@FeignClient(contextId = "PlaybackApiClient", name = "playback", url = "https://api.ws.sonos.com/control/api/v1", configuration = FeignApiClientConfiguration.class)
public interface PlaybackApi {

	@GetMapping(value = "/groups/{groupId}/playback", produces = "application/json")
	public PlaybackStatus getStatus(@PathVariable String groupId);

	@PostMapping(value = "/households/{householdId}/groups/subscription")
	public void subscribe(@PathVariable String householdId);

	@DeleteMapping(value = "/households/{householdId}/groups/subscription")
	public void unsubscribe(@PathVariable String householdId);
}
