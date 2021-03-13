package lu.berscheid.knx.device.sonos.config;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import feign.Logger;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import lu.berscheid.knx.device.sonos.rest.api.TokenApi;
import lu.berscheid.knx.device.sonos.rest.model.TokenRequest;
import lu.berscheid.knx.device.sonos.rest.model.TokenResponse;

/*
 * This is the client configuration required for the FeignClient to be able to perform an OAuth2
 * authentication.
 */
@Slf4j
public class FeignApiClientConfiguration {

	@Autowired
	private SonosCredentials credentials = new SonosCredentials();

	@Autowired
	private TokenApi tokenApi;

	@Bean
	public RequestInterceptor requestInterceptor() {
		return new RequestInterceptor() {

			@Override
			public void apply(RequestTemplate template) {
				if (credentials.getAuthorizationCode() == null) {
					log.warn("No credentials available, please call /login to authenticate first.");
					return;
				}
				if (credentials.getAccessToken() == null) {
					// Need to get an access token first
					TokenResponse token = tokenApi.getToken(TokenRequest.builder()
							.code(credentials.getAuthorizationCode()).grantType("authorization_code")
							.redirectUri(SonosCredentials.REDIRECT_URL).build());
					credentials.setAccessToken(token.getAccessToken());
					credentials.setRefreshToken(token.getRefreshToken());
					credentials.setExpiresOn(LocalDateTime.now().plusSeconds(token.getExpiresIn()));
				} else if (credentials.getExpiresOn() != null
						&& credentials.getExpiresOn().isBefore(LocalDateTime.now())) {
					// Token expired, need to get a new one with the refresh token
					TokenResponse token = tokenApi.getToken(TokenRequest.builder()
							.refreshToken(credentials.getRefreshToken()).grantType("refresh_token").build());
					credentials.setAccessToken(token.getAccessToken());
					credentials.setRefreshToken(token.getRefreshToken());
					credentials.setExpiresOn(LocalDateTime.now().plusSeconds(token.getExpiresIn()));
				}
				template.header("Authorization", "Bearer " + credentials.getAccessToken());
			}
		};
	}

	@Bean
	public Logger.Level feignLoggerLevel() {
		return Logger.Level.FULL;
	}
}
