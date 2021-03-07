package lu.berscheid.knx.device.sonos.rest.model;

public enum PlaybackState {
	/*
	 * The group is buffering audio. This is a transitional state before the audio
	 * starts playing.
	 */
	PLAYBACK_STATE_BUFFERING,

	/*
	 * Playback is not playing or paused, such as when the queue is empty or a
	 * source cannot be paused (such as streaming radio).
	 */
	PLAYBACK_STATE_IDLE,
	/*
	 * Playback is paused while playing content that can be paused and resumed.
	 */
	PLAYBACK_STATE_PAUSED,

	/* The group is playing audio. */
	PLAYBACK_STATE_PLAYING
}
