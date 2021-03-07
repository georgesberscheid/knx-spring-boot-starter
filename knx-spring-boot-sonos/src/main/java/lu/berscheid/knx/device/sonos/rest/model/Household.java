package lu.berscheid.knx.device.sonos.rest.model;

import lombok.Data;

@Data
public class Household {

	private String id;
	private String name;
	private Group[] groups;
	private Player[] players;
}
