package lu.berscheid.knx.device.sonos.rest.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.annotations.Api;
import lu.berscheid.knx.device.sonos.config.FeignApiClientConfiguration;
import lu.berscheid.knx.device.sonos.rest.model.PlayerVolume;

@Api(value = "PlayerVolume")
@FeignClient(contextId = "PlayerVolumeApiClient", name = "PlayerVolume", url = "https://api.ws.sonos.com/control/api/v1", configuration = FeignApiClientConfiguration.class)
public interface PlayerVolumeApi {

	@GetMapping(value = "/players/{playerId}/playerVolume", produces = "application/json")
	public PlayerVolume getPlayerVolume(@PathVariable String playerId);

	@PostMapping(value = "/players/{playerId}/playerVolume", produces = "application/json")
	public void getPlayerVolume(@PathVariable String playerId, @RequestBody PlayerVolume playerVolume);

	@PostMapping(value = "/players/{playerId}/playerVolume/subscription")
	public void subscribe(@PathVariable String playerId);

	@DeleteMapping(value = "/players/{playerId}/playerVolume/subscription")
	public void unsubscribe(@PathVariable String playerId);
}
