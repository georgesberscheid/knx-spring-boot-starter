package lu.berscheid.knx.device.automower.rest.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Park extends JsonApiAction {

	private DurationAttributes attributes;

	public Park(long duration) {
		super("Park");
		this.attributes = new DurationAttributes(duration);
	}
}
