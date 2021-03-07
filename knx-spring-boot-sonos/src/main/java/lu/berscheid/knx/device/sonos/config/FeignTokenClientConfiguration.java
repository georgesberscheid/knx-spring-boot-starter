package lu.berscheid.knx.device.sonos.config;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import feign.Logger;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import feign.auth.BasicAuthRequestInterceptor;
import feign.codec.EncodeException;
import feign.codec.Encoder;
import lombok.extern.slf4j.Slf4j;
import lu.berscheid.knx.device.sonos.rest.model.TokenRequest;

/*
 * We need to use basic authentication for the token API.
 */
@Slf4j
public class FeignTokenClientConfiguration {

	@Autowired
	private SonosCredentials credentials = new SonosCredentials();

	@Bean
	public RequestInterceptor requestInterceptor() {
		return new BasicAuthRequestInterceptor(credentials.getClientId(), credentials.getClientSecret());
	}

	@Bean
	public Encoder getMultipartEncoder() {
		return new Encoder() {

			@Override
			public void encode(Object object, Type bodyType, RequestTemplate template) throws EncodeException {
				if (bodyType.equals(TokenRequest.class)) {
					List<String> parameters = new ArrayList<String>();
					TokenRequest request = (TokenRequest) object;
					for (Field field : TokenRequest.class.getDeclaredFields()) {
						field.setAccessible(true);
						try {
							JsonProperty jsonProperty = field.getAnnotation(JsonProperty.class);
							String fieldName = (jsonProperty != null ? jsonProperty.value() : field.getName());
							Object fieldValue = field.get(request);
							if (fieldValue != null) {
								parameters.add(fieldName + "="
										+ URLEncoder.encode(fieldValue.toString(), Charset.forName("UTF-8")));
							}
						} catch (IllegalArgumentException | IllegalAccessException e) {
							log.error("Unable to convert TokenRequest", e);
						}
					}
					String body = String.join("&", parameters.toArray(new String[0]));
					template.body(body);
				}
			}
		};
	}

	@Bean
	public Logger.Level feignLoggerLevel() {
		return Logger.Level.FULL;
	}
}
