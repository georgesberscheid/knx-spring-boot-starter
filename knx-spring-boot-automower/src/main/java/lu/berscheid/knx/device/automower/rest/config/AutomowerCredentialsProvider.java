package lu.berscheid.knx.device.automower.rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.stereotype.Component;

@Component
public class AutomowerCredentialsProvider {

	private AuthorizationCodeResourceDetails automowerCredentials = new AuthorizationCodeResourceDetails();

	@Bean
	public AuthorizationCodeResourceDetails getAutomowerCredentials() {
		return automowerCredentials;
	}
}
