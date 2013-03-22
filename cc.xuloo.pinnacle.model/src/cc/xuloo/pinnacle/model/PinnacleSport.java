package cc.xuloo.pinnacle.model;

import org.apache.commons.lang3.StringUtils;

public enum PinnacleSport {

	NONE,
	FOOTBALL,
	HOCKEY,
	BASKETBALL,
	SOCCER,
	TENNIS,
	CRICKET,
	E_SPORTS,
	DARTS,
	MIXED_MARTIAL_ARTS,
	RUGBY_LEAGUE,
	RUGBY_UNION,
	SNOOKER,
	HANDBALL;
	
	public static PinnacleSport from(String value) {
		
		if (!StringUtils.isEmpty(value)) {
			if (value.equals(PinnacleConstants.BASKETBALL_KEY)) {
				return BASKETBALL;
			} else if (value.equals(PinnacleConstants.FOOTBALL_KEY)) {
				return FOOTBALL;
			} else if (value.equals(PinnacleConstants.HOCKEY_KEY)) {
				return HOCKEY;
			} else if (value.equals(PinnacleConstants.SOCCER_KEY)) {
				return SOCCER;
			} else if (value.equals(PinnacleConstants.TENNIS_KEY)) {
				return TENNIS;
			} else if (value.equals(PinnacleConstants.CRICKET_KEY)) {
				return CRICKET;
			} else if (value.equals(PinnacleConstants.E_SPORTS_KEY)) {
				return E_SPORTS;
			} else if (value.equals(PinnacleConstants.DARTS_KEY)) {
				return DARTS;
			} else if (value.equals(PinnacleConstants.MIXED_MARTIAL_ARTS_KEY)) {
				return MIXED_MARTIAL_ARTS;
			} else if (value.equals(PinnacleConstants.RUGBY_LEAGUE_KEY)) {
				return RUGBY_LEAGUE;
			} else if (value.equals(PinnacleConstants.RUGBY_UNION_KEY)) {
				return RUGBY_UNION;
			} else if (value.equals(PinnacleConstants.SNOOKER_KEY)) {
				return SNOOKER;
			} else if (value.equals(PinnacleConstants.HANDBALL_KEY)) {
				return HANDBALL;
			}
		}
		
		System.out.println("Unable to create a PinnacleSport from name '" + value + "'");
		
		return NONE;
	}
	
	public static String toString(PinnacleSport value)	{

		if (value.equals(FOOTBALL)) return PinnacleConstants.FOOTBALL_KEY;
		else if (value.equals(HOCKEY)) return PinnacleConstants.HOCKEY_KEY;
		else if (value.equals(BASKETBALL)) return PinnacleConstants.BASKETBALL_KEY;
		else if (value.equals(SOCCER)) return PinnacleConstants.SOCCER_KEY;
		else if (value.equals(TENNIS)) return PinnacleConstants.TENNIS_KEY;
		else if (value.equals(CRICKET)) return PinnacleConstants.CRICKET_KEY;
		else if (value.equals(E_SPORTS)) return PinnacleConstants.E_SPORTS_KEY;
		else if (value.equals(DARTS)) return PinnacleConstants.DARTS_KEY;
		else if (value.equals(MIXED_MARTIAL_ARTS)) return PinnacleConstants.MIXED_MARTIAL_ARTS_KEY;
		else if (value.equals(RUGBY_LEAGUE)) return PinnacleConstants.RUGBY_LEAGUE_KEY;
		else if (value.equals(RUGBY_UNION)) return PinnacleConstants.RUGBY_UNION_KEY;
		else if (value.equals(SNOOKER)) return PinnacleConstants.SNOOKER_KEY;
		else if (value.equals(HANDBALL)) return PinnacleConstants.HANDBALL_KEY;
		
		return "None";
	}
}
