package lu.berscheid.knx.device.sonos.rest.model;

import lombok.Data;

@Data
public class PlaybackActions {
	private boolean canSkip;
	private boolean canSkipBack;
	private boolean canSeek;
	private boolean canPause;
	private boolean canStop;
	private boolean canRepeat;
	private boolean canRepeatOne;
	private boolean canCrossfade;
	private boolean canShuffle;
}