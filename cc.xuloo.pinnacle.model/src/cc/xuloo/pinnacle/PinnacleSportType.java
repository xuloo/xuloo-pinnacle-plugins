package cc.xuloo.pinnacle;

import static cc.xuloo.pinnacle.PinnacleConstants.Sport.BASKETBALL_KEY;
import static cc.xuloo.pinnacle.PinnacleConstants.Sport.CRICKET_KEY;
import static cc.xuloo.pinnacle.PinnacleConstants.Sport.DARTS_KEY;
import static cc.xuloo.pinnacle.PinnacleConstants.Sport.E_SPORTS_KEY;
import static cc.xuloo.pinnacle.PinnacleConstants.Sport.FOOTBALL_KEY;
import static cc.xuloo.pinnacle.PinnacleConstants.Sport.HANDBALL_KEY;
import static cc.xuloo.pinnacle.PinnacleConstants.Sport.HOCKEY_KEY;
import static cc.xuloo.pinnacle.PinnacleConstants.Sport.MIXED_MARTIAL_ARTS_KEY;
import static cc.xuloo.pinnacle.PinnacleConstants.Sport.RUGBY_LEAGUE_KEY;
import static cc.xuloo.pinnacle.PinnacleConstants.Sport.RUGBY_UNION_KEY;
import static cc.xuloo.pinnacle.PinnacleConstants.Sport.SNOOKER_KEY;
import static cc.xuloo.pinnacle.PinnacleConstants.Sport.SOCCER_KEY;
import static cc.xuloo.pinnacle.PinnacleConstants.Sport.TENNIS_KEY;

import org.apache.commons.lang3.StringUtils;

public enum PinnacleSportType {

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
	
	public static PinnacleSportType from(String value) {
		
		if (!StringUtils.isEmpty(value)) {
			if (value.equals(BASKETBALL_KEY)) {
				return BASKETBALL;
			} else if (value.equals(FOOTBALL_KEY)) {
				return FOOTBALL;
			} else if (value.equals(HOCKEY_KEY)) {
				return HOCKEY;
			} else if (value.equals(SOCCER_KEY)) {
				return SOCCER;
			} else if (value.equals(TENNIS_KEY)) {
				return TENNIS;
			} else if (value.equals(CRICKET_KEY)) {
				return CRICKET;
			} else if (value.equals(E_SPORTS_KEY)) {
				return E_SPORTS;
			} else if (value.equals(DARTS_KEY)) {
				return DARTS;
			} else if (value.equals(MIXED_MARTIAL_ARTS_KEY)) {
				return MIXED_MARTIAL_ARTS;
			} else if (value.equals(RUGBY_LEAGUE_KEY)) {
				return RUGBY_LEAGUE;
			} else if (value.equals(RUGBY_UNION_KEY)) {
				return RUGBY_UNION;
			} else if (value.equals(SNOOKER_KEY)) {
				return SNOOKER;
			} else if (value.equals(HANDBALL_KEY)) {
				return HANDBALL;
			}
		}
		
		System.out.println("Unable to create a PinnacleSport from name '" + value + "'");
		
		return NONE;
	}
	
	public static String toString(PinnacleSportType value)	{

		if (value.equals(FOOTBALL)) return FOOTBALL_KEY;
		else if (value.equals(HOCKEY)) return HOCKEY_KEY;
		else if (value.equals(BASKETBALL)) return BASKETBALL_KEY;
		else if (value.equals(SOCCER)) return SOCCER_KEY;
		else if (value.equals(TENNIS)) return TENNIS_KEY;
		else if (value.equals(CRICKET)) return CRICKET_KEY;
		else if (value.equals(E_SPORTS)) return E_SPORTS_KEY;
		else if (value.equals(DARTS)) return DARTS_KEY;
		else if (value.equals(MIXED_MARTIAL_ARTS)) return MIXED_MARTIAL_ARTS_KEY;
		else if (value.equals(RUGBY_LEAGUE)) return RUGBY_LEAGUE_KEY;
		else if (value.equals(RUGBY_UNION)) return RUGBY_UNION_KEY;
		else if (value.equals(SNOOKER)) return SNOOKER_KEY;
		else if (value.equals(HANDBALL)) return HANDBALL_KEY;
		
		return "None";
	}
}
