package lu.berscheid.knx.device.sonos.rest.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.annotations.Api;
import lu.berscheid.knx.device.sonos.config.FeignApiClientConfiguration;
import lu.berscheid.knx.device.sonos.rest.model.GroupVolume;

@Api(value = "GroupVolume")
@FeignClient(contextId = "GroupVolumeApiClient", name = "groupVolume", url = "https://api.ws.sonos.com/control/api/v1", configuration = FeignApiClientConfiguration.class)
public interface GroupVolumeApi {

	@GetMapping(value = "/groups/{groupId}/groupVolume", produces = "application/json")
	public GroupVolume getGroupVolume(@PathVariable String groupId);

	@PostMapping(value = "/groups/{groupId}/groupVolume", produces = "application/json")
	public void getGroupVolume(@PathVariable String groupId, @RequestBody GroupVolume groupVolume);

	@PostMapping(value = "/groups/{groupId}/groupVolume/subscription")
	public void subscribe(@PathVariable String groupId);

	@DeleteMapping(value = "/groups/{groupId}/groupVolume/subscription")
	public void unsubscribe(@PathVariable String groupId);
}
