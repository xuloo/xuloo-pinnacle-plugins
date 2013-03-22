package cc.xuloo.pinnacle.model;

import cc.xuloo.sports.api.TeamType;

public enum PinnacleParticipantStatus {

	NONE("None"),
	HOME("Home"),
	VISITING("Visiting"),
	DRAW("Draw");
	
	private final String name;
	
	private PinnacleParticipantStatus(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public static PinnacleParticipantStatus from(String value) {
		for (PinnacleParticipantStatus val : values()) {
			if (val.getName().equals(value)) return val;
		}
		
		return NONE;
	}
	
	public TeamType toTeamType() {
		if (name.equals("Home")) return TeamType.HOME;
		if (name.equals("Visiting")) return TeamType.AWAY;
		return TeamType.DRAW;
	}
}
