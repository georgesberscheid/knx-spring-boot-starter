package lu.berscheid.knx.device.sonos.rest.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;

import io.swagger.annotations.Api;
import lu.berscheid.knx.device.sonos.config.FeignTokenClientConfiguration;
import lu.berscheid.knx.device.sonos.rest.model.TokenRequest;
import lu.berscheid.knx.device.sonos.rest.model.TokenResponse;

@Api(value = "Token")
@FeignClient(contextId = "TokenApiClient", name = "token", url = "https://api.sonos.com/login/v3", configuration = FeignTokenClientConfiguration.class)
public interface TokenApi {

	@PostMapping(value = "/oauth/access", produces = MediaType.ALL_VALUE, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	TokenResponse getToken(TokenRequest request);

}
