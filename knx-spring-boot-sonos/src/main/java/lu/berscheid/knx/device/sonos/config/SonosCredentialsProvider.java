package lu.berscheid.knx.device.sonos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component

public class SonosCredentialsProvider {

	@Bean
	public SonosCredentials getSonosCredentials() {
		return new SonosCredentials();
	}

}
