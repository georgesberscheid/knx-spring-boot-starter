package lu.berscheid.knx.device.sonos.rest.controller;

import java.net.URI;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponentsBuilder;

import feign.FeignException.Unauthorized;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lu.berscheid.knx.device.sonos.config.SonosCredentials;
import lu.berscheid.knx.device.sonos.rest.api.GroupsApi;
import lu.berscheid.knx.device.sonos.rest.api.HouseholdsApi;
import lu.berscheid.knx.device.sonos.rest.model.GroupsResponse;
import lu.berscheid.knx.device.sonos.rest.model.Household;
import lu.berscheid.knx.device.sonos.rest.model.HouseholdsResponse;

@Api
@RestController
@RequestMapping("/device/sonos")
@Validated
@NoArgsConstructor
@Slf4j
public class LoginController {

	private Set<String> stateValues = new HashSet<String>();

	@Autowired
	private SonosCredentials credentials;

	@Autowired
	private HouseholdsApi householdsApi;

	@Autowired
	private GroupsApi groupsApi;

	@ApiOperation(value = "Login to Sonos Control", notes = "Redirect to the Sonos Control login page", nickname = "login")
	@GetMapping("/login")
	public ResponseEntity<HouseholdsResponse> login(RedirectAttributes attributes) {
		try {
			String state = UUID.randomUUID().toString();
			stateValues.add(state);

			URI location = UriComponentsBuilder.fromHttpUrl("https://api.sonos.com/login/v3/oauth")
					.queryParam("client_id", credentials.getClientId()).queryParam("response_type", "code")
					.queryParam("state", state).queryParam("scope", "playback-control-all")
					.queryParam("redirect_uri", SonosCredentials.REDIRECT_URL).build().toUri();
			return ResponseEntity.status(HttpStatus.FOUND).location(location).build();
		} catch (Exception e) {
			log.info("Other error: " + e.getLocalizedMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@GetMapping("/redirect")
	public ResponseEntity<String> test(String code, String state) {
		if (state == null || !stateValues.remove(state)) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}
		credentials.setAuthorizationCode(code);
		return ResponseEntity.status(HttpStatus.FOUND)
				.location(URI.create("https://home.berscheid.lu/device/sonos/households")).build();
	}

	@GetMapping("/households")
	private ResponseEntity<HouseholdsResponse> getHouseholds() {
		try {
			HouseholdsResponse householdsResponse = householdsApi.getHouseholds();

			for (Household h : householdsResponse.getHouseholds()) {
				GroupsResponse groupsResponse = groupsApi.getGroups(h.getId());
				h.setGroups(groupsResponse.getGroups());
				h.setPlayers(groupsResponse.getPlayers());
			}
			return ResponseEntity.ok(householdsResponse);
		} catch (Unauthorized e) {
			// If we're unauthorized, even after trying to retrieve the access token,
			// redirect to the login page again
			return ResponseEntity.status(HttpStatus.FOUND)
					.location(URI.create("https://home.berscheid.lu/device/sonos/login")).build();
		}
	}
}
