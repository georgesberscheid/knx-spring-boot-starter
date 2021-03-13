package lu.berscheid.knx.device.sonos.rest.model;

import lombok.Data;

@Data
public class PlayMode {
	/*
	 * Repeat tracks. When playback reaches the end of the current queue of tracks,
	 * playback will wrap around and continue from the beginning of the queue.
	 */
	private boolean repeat;
	/*
	 * Repeat the current track indefinitely until this mode is disabled or your app
	 * explicitly changes the playhead position to a different track, for example,
	 * by skipping to the next track, a previous track, or a specific track in a
	 * cloud queue.
	 */
	private boolean repeatOne;

	/* Play the tracks in the queue in a randomly shuffled order. */
	private boolean shuffle;

	/*
	 * Fade out and mix the end of a track with the start of the next track as it is
	 * being faded in, creating a crossfade effect.
	 */
	private boolean crossfade;
}
