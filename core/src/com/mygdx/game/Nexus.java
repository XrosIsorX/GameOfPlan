package com.mygdx.game;

public class Nexus extends Character {

	public Nexus(float x, float y, float width, float height, int number, int team) {
		super(x, y, width, height, number, team);
		hp= Settings.NEXUS_HP;
		atk = Settings.NEXUS_ATK;
		atkRange = Settings.NEXUS_ATKRANGE;
		walk = Settings.NEXUS_WALK;
		cost = Settings.NEXUS_COST;
		skill = "-";
		name = "Nexus";
		
	}
	
	
}
