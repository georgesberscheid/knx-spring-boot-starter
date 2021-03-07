package lu.berscheid.knx.device.sonos.rest.model;

import lombok.Data;

@Data
public class GroupsResponse {
	private Group[] groups;
	private Player[] players;
}
