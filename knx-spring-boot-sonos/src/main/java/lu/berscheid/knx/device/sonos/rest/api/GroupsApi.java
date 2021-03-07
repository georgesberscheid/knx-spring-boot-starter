package lu.berscheid.knx.device.sonos.rest.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import io.swagger.annotations.Api;
import lu.berscheid.knx.device.sonos.config.FeignApiClientConfiguration;
import lu.berscheid.knx.device.sonos.rest.model.GroupsResponse;

@Api(value = "Groups")
@FeignClient(contextId = "GroupsApiClient", name = "groups", url = "https://api.ws.sonos.com/control/api/v1", configuration = FeignApiClientConfiguration.class)
public interface GroupsApi {

	@GetMapping(value = "/households/{householdId}/groups", produces = "application/json")
	public GroupsResponse getGroups(@PathVariable String householdId);

	@PostMapping(value = "/households/{householdId}/groups/subscription")
	public void subscribe(@PathVariable String householdId);

	@DeleteMapping(value = "/households/{householdId}/groups/subscription")
	public void unsubscribe(@PathVariable String householdId);
}
