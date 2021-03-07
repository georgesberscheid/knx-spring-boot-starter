package lu.berscheid.knx.device.sonos.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TokenRequest {

	@JsonProperty("grant_type")
	private String grantType;

	private String code;

	@JsonProperty("redirect_uri")
	private String redirectUri;

	@JsonProperty("refresh_token")
	private String refreshToken;
}