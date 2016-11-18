package com.mygdx.game;

public class Nexus extends Character {

	public Nexus(float x, float y, float width, float height, int team, int number) {
		super(x, y, width, height, team);
		this.number = number;
		this.hp= Settings.NEXUS_HP;
		this.maxHp = Settings.NEXUS_HP;
		this.atk = Settings.NEXUS_ATK;
		this.atkRange = Settings.NEXUS_ATKRANGE;
		this.walk = Settings.NEXUS_WALK;
		this.cost = Settings.NEXUS_COST;
		this.skillDetail = "-";
		this.name = "Nexus";
		
	}
	
	
}
