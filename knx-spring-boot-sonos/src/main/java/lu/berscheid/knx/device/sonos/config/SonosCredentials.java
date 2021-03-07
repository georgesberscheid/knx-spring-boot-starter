package lu.berscheid.knx.device.sonos.config;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class SonosCredentials {
	public static final String REDIRECT_URL = "https://home.berscheid.lu/device/sonos/redirect";

	private String clientId = "bb54361e-c4e4-4a69-b04c-ee3a156f2d33";
	private String clientSecret = "212e11ea-1311-4d2e-a4db-be7dbfb47c12";
	private String authorizationCode = "";
	private String accessToken = "Rfqa9WQH71xt38vG8O3poSTGpJbZ";
	private String refreshToken;
	private LocalDateTime expiresOn;
}