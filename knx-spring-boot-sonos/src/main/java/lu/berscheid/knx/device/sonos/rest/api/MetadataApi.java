package lu.berscheid.knx.device.sonos.rest.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import io.swagger.annotations.Api;
import lu.berscheid.knx.device.sonos.config.FeignApiClientConfiguration;
import lu.berscheid.knx.device.sonos.rest.model.MetadataStatus;

@Api(value = "Metadata")
@FeignClient(contextId = "MetadataApiClient", name = "metadata", url = "https://api.ws.sonos.com/control/api/v1", configuration = FeignApiClientConfiguration.class)
public interface MetadataApi {

	@GetMapping(value = "/groups/{groupId}/playbackMetadata", produces = "application/json")
	public MetadataStatus getStatus(@PathVariable String groupId);

	@PostMapping(value = "/groups/{groupId}/playbackMetadata/subscription")
	public void subscribe(@PathVariable String groupId);

	@DeleteMapping(value = "/groups/{groupId}/playbackMetadata/subscription")
	public void unsubscribe(@PathVariable String groupId);

}
