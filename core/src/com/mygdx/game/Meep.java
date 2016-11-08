package com.mygdx.game;

public class Meep extends Character {

	public Meep(float x, float y, float width, float height, int number , int team) {
		super(x, y, width, height, number, team);
		this.hp = Settings.MEEP_HP;
		this.atk = Settings.MEEP_ATK;
		this.atkRange = Settings.MEEP_ATKRANGE;
		this.walk = Settings.MEEP_WALK;
		this.cost = Settings.MEEP_COST;
		this.skill = "-";
		this.name = "Meep";
	}

	public Meep(float x, float y, float width, float height, int number, int team ,int hp ,int atk, int atkrange, int walk) {
		super(x, y, width, height, number, team);
		this.hp = hp;
		this.atk = atk;
		this.atkRange = atkrange;
		this.walk = walk;
		this.cost = Settings.MEEP_COST;
		this.skill = "-";
		this.name = "Meep";
	}
}
