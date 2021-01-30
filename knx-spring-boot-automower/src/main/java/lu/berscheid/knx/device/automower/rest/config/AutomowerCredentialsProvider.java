package lu.berscheid.knx.device.automower.rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.stereotype.Component;

@Component
public class AutomowerCredentialsProvider {

	private ResourceOwnerPasswordResourceDetails automowerCredentials = new ResourceOwnerPasswordResourceDetails();

	@Bean
	public ResourceOwnerPasswordResourceDetails getAutomowerCredentials() {
		return automowerCredentials;
	}
}
