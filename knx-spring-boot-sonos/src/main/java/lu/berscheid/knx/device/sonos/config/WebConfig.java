package lu.berscheid.knx.device.sonos.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Autowired
	private SonosCredentials credentials;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new SonosSignatureValidator(credentials));
	}
}
