package lu.berscheid.knx.device.sonos.rest.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Api
@RestController
@RequestMapping("/device/sonos")
@Validated
@NoArgsConstructor
@Slf4j
public class SubscriptionController {

	@PostMapping(value= "/subscription", headers = "X-Sonos-Namespace=groups")
	public void groupEvent() {
		
	}
}
