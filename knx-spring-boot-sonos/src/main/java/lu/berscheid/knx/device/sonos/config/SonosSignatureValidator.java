package lu.berscheid.knx.device.sonos.config;

import java.security.MessageDigest;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import static java.nio.charset.StandardCharsets.UTF_8;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/* Validates the signature provided by the Sonos cloud on the subscription endpoint */
@AllArgsConstructor
@Slf4j
public class SonosSignatureValidator implements HandlerInterceptor {

	private SonosCredentials credentials;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// Only do this on the /device/sonos/subscription endpoint
		if (!request.getServletPath().equals("/device/sonos/subscription")) {
			return true;
		}
		MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");

		messageDigest.update(request.getHeader("X-Sonos-Event-Seq-Id").getBytes(UTF_8));
		messageDigest.update(request.getHeader("X-Sonos-Namespace").getBytes(UTF_8));
		messageDigest.update(request.getHeader("X-Sonos-Type").getBytes(UTF_8));
		messageDigest.update(request.getHeader("X-Sonos-Target-Type").getBytes(UTF_8));
		messageDigest.update(request.getHeader("X-Sonos-Target-Value").getBytes(UTF_8));
		messageDigest.update(credentials.getClientId().getBytes(UTF_8));
		messageDigest.update(credentials.getClientSecret().getBytes(UTF_8));

		String signature = Base64.getUrlEncoder().withoutPadding().encodeToString(messageDigest.digest());
		if (!signature.equals(request.getHeader("X-Sonos-Event-Signature"))) {
			log.warn("Received subscription event but signature validation failed. Received signature: "
					+ request.getHeader("X-Sonos-Event-Signature") + ", calculated signature:" + signature);
			return false;
		}
		return true;
	}

}
