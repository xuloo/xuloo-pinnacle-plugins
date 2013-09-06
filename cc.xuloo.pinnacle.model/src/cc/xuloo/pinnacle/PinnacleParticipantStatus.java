package cc.xuloo.pinnacle;

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
}
