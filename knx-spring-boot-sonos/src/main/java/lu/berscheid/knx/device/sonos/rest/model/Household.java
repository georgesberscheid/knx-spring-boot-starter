package lu.berscheid.knx.device.sonos.rest.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class Household {

	private String id;
	private String name;
	private Group[] groups;
	private Player[] players;

	@JsonIgnore
	private Map<String, Player> playersById = new HashMap<String, Player>();

	public void setPlayers(Player[] players) {
		this.players = players;
		Arrays.stream(players).forEach(player -> playersById.put(player.getId(), player));
	}

	public void setGroups(Group[] groups) {
		this.groups = groups;
		for (Group group : groups) {
			Arrays.stream(group.getPlayerIds()).forEach(playerId -> getPlayerById(playerId).setGroupId(group.getId()));
		}
	}

	public Player getPlayerById(String playerId) {
		return playersById.get(playerId);
	}
}
