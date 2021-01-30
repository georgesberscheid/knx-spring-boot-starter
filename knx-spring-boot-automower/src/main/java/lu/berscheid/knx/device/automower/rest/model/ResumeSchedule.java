package lu.berscheid.knx.device.automower.rest.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ResumeSchedule extends JsonApiAction {

	public ResumeSchedule() {
		super("ResumeSchedule");
	}
}
