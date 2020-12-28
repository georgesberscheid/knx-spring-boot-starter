package lu.berscheid.knx.model;

public class KnxException extends Exception {
	private static final long serialVersionUID = 2456443619872954643L;

	public KnxException(String message) {
		super(message);
	}

	public KnxException(String message, Throwable cause) {
		super(message, cause);
	}
}
