package lu.berscheid.knx.device.automower.rest.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Start extends JsonApiAction {

	private DurationAttributes attributes;

	public Start(long duration) {
		super("Start");
		this.attributes = new DurationAttributes(duration);
	}
}
