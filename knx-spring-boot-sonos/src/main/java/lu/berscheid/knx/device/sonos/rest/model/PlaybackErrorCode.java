package lu.berscheid.knx.device.sonos.rest.model;

public enum PlaybackErrorCode {
	/* Indicates that a request to the cloud queue server failed. */
	ERROR_CLOUD_QUEUE_SERVER,

	/* Indicates that the command failed as it violated a playback policy. */
	ERROR_DISALLOWED_BY_POLICY,

	/* Indicates that playback of the current track has failed. */
	ERROR_PLAYBACK_FAILED,

	/*
	 * Indicates that there is no playback source. This could indicate that the
	 * queue is empty or that there is no next or previous track to play.
	 */
	ERROR_PLAYBACK_NO_CONTENT,

	/*
	 * Indicates that the user may not skip forward due to a playback policy that
	 * allows a limited number of skips per time interval. See playback policies for
	 * details.
	 */
	ERROR_SKIP_LIMIT_REACHED
}
