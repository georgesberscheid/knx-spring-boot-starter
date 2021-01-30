package lu.berscheid.knx.device.automower.rest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.security.oauth2.client.feign.OAuth2FeignRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.resource.OAuth2AccessDeniedException;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.resource.UserRedirectRequiredException;
import org.springframework.security.oauth2.client.token.AccessTokenRequest;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordAccessTokenProvider;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import feign.Logger;
import feign.RequestInterceptor;
import feign.RequestTemplate;

/*
 * This is the client configuration required for the FeignClient to be able to perform an OAuth2
 * authentication.
 */
public class FeignClientConfiguration {

	@Autowired
	private ResourceOwnerPasswordResourceDetails resource;

	@Bean
	@SuppressWarnings("deprecation")
	public RequestInterceptor requestInterceptor() {
		resource.setAccessTokenUri("https://api.authentication.husqvarnagroup.dev/v1/oauth2/token");
		OAuth2FeignRequestInterceptor interceptor = new OAuth2FeignRequestInterceptor(
				new DefaultOAuth2ClientContext(), resource) {

			/*
			 * We need to override the apply method of the interceptor because Automower requires
			 * additional headers to be set on each API call.
			 */
			@Override
			public void apply(RequestTemplate template) {
				super.apply(template);
				template.header("Authorization-Provider", "husqvarna");
				template.header("X-Api-Key", resource.getClientId());
			}
		};
		/*
		 * We need to provide a specific token provider implementation because the one that comes out
		 * of the box with Spring (ResourceOwnerPasswordAccessTokenProvider) doesn't use the client_id
		 * in the token request, but this is required by the Automower spec.
		 */
		interceptor.setAccessTokenProvider(new ResourceOwnerPasswordAccessTokenProvider() {

			public OAuth2AccessToken obtainAccessToken(OAuth2ProtectedResourceDetails details,
					AccessTokenRequest request) throws UserRedirectRequiredException,
					AccessDeniedException, OAuth2AccessDeniedException {

				ResourceOwnerPasswordResourceDetails resource = (ResourceOwnerPasswordResourceDetails) details;
				MultiValueMap<String, String> form = new LinkedMultiValueMap<String, String>();
				form.set("grant_type", "password");
				form.set("client_id", resource.getClientId());
				form.set("username", resource.getUsername());
				form.set("password", resource.getPassword());
				form.putAll(request);

				return retrieveToken(request, resource, form, new HttpHeaders());

			}
		});
		return interceptor;
	}

	@Bean
	public Logger.Level feignLoggerLevel() {
		return Logger.Level.FULL;
	}
}
