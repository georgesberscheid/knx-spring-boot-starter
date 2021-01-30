package lu.berscheid.knx.device.automower.model;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import lu.berscheid.knx.device.automower.rest.model.MowerApp.ActivityEnum;
import lu.berscheid.knx.device.automower.rest.model.MowerApp.ModeEnum;

@Data
@Builder
@ToString
public class MowerStatus {
	private String id;
	private String name;
	private String model;
	private String serialNumber;
	private int batteryPercent;
	private ModeEnum mode;
	private ActivityEnum activity;
	private LocalDateTime nextStart;
}
