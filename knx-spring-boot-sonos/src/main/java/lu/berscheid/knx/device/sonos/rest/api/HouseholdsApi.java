package lu.berscheid.knx.device.sonos.rest.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import io.swagger.annotations.Api;
import lu.berscheid.knx.device.sonos.config.FeignApiClientConfiguration;
import lu.berscheid.knx.device.sonos.rest.model.HouseholdsResponse;

@Api(value = "Households")
@FeignClient(contextId = "HouseholdsApiClient",
		name = "households",
		url = "https://api.ws.sonos.com/control/api/v1",
		configuration = FeignApiClientConfiguration.class)
public interface HouseholdsApi {

	@GetMapping(value = "/households", produces = "application/json")
	public HouseholdsResponse getHouseholds();

}
