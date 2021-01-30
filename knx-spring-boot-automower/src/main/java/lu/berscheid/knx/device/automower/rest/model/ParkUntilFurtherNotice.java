package lu.berscheid.knx.device.automower.rest.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ParkUntilFurtherNotice extends JsonApiAction {

	public ParkUntilFurtherNotice() {
		super("ParkUntilFurtherNotice");
	}
}