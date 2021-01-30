package lu.berscheid.knx.device.automower.service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lu.berscheid.knx.device.automower.model.MowerStatus;
import lu.berscheid.knx.device.automower.rest.api.ActionsApi;
import lu.berscheid.knx.device.automower.rest.api.MowerApi;
import lu.berscheid.knx.device.automower.rest.model.JsonApiData;
import lu.berscheid.knx.device.automower.rest.model.JsonApiDataListDocument;
import lu.berscheid.knx.device.automower.rest.model.JsonDataAction;
import lu.berscheid.knx.device.automower.rest.model.MowerData;
import lu.berscheid.knx.device.automower.rest.model.Park;
import lu.berscheid.knx.device.automower.rest.model.ParkUntilFurtherNotice;
import lu.berscheid.knx.device.automower.rest.model.ResumeSchedule;
import lu.berscheid.knx.device.automower.rest.model.Start;

@Component
public class AutomowerService {

	@Autowired
	private MowerApi mowerApi;

	@Autowired
	private ActionsApi actionsApi;

	private MowerStatus lastStatus;

	public MowerStatus getMowerStatus() {
		JsonApiDataListDocument response = mowerApi.mowersGet().getBody();
		if (response.getData() != null && !response.getData().isEmpty()) {
			// We only support one
			JsonApiData data = response.getData().get(0);
			MowerData mowerData = data.getAttributes();
			lastStatus = MowerStatus.builder() //
					.id(data.getId()) // id
					.name(mowerData.getSystem().getName()) // name of the mower
					.model(mowerData.getSystem().getModel()) // model of the mower
					.serialNumber(mowerData.getSystem().getSerialNumber())
					.batteryPercent(mowerData.getBattery().getBatteryPercent()) // battery percent
					.mode(mowerData.getMower().getMode()) // where the mower is
					.activity(mowerData.getMower().getActivity()) // what the mower does
					.nextStart(LocalDateTime.ofEpochSecond(
							mowerData.getPlanner().getNextStartTimestamp() / 1000, 0,
							ZoneOffset.of("+02:00")))
					.build();
			return lastStatus;
		}
		return null;
	}

	public void start(long duration) {
		if (lastStatus == null) {
			getMowerStatus();
		}
		actionsApi.mowersIdActionsPost(lastStatus.getId(), new JsonDataAction(new Start(duration)));
	}

	public void resumeSchedule() {
		if (lastStatus == null) {
			getMowerStatus();
		}
		actionsApi.mowersIdActionsPost(lastStatus.getId(), new JsonDataAction(new ResumeSchedule()));
	}

	public void park(long duration) {
		if (lastStatus == null) {
			getMowerStatus();
		}
		actionsApi.mowersIdActionsPost(lastStatus.getId(), new JsonDataAction(new Park(duration)));
	}

	public void parkUntilFurtherNotice() {
		if (lastStatus == null) {
			getMowerStatus();
		}
		actionsApi.mowersIdActionsPost(lastStatus.getId(),
				new JsonDataAction(new ParkUntilFurtherNotice()));
	}

	public void parkUntilNextSchedule() {
		if (lastStatus == null) {
			getMowerStatus();
		}
		actionsApi.mowersIdActionsPost(lastStatus.getId(),
				new JsonDataAction(new ParkUntilFurtherNotice()));
	}
}
