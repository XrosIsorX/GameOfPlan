package com.mygdx.game;

public class Skull extends Character {

	public Skull(float x, float y, float width, float height, int team) {
		super(x, y, width, height, team);
		this.number = Settings.SKULL_NUMBER;
		this.hp= Settings.SKULL_HP;
		this.atk = Settings.SKULL_ATK;
		this.atkRange = Settings.SKULL_ATKRANGE;
		this.walk = Settings.SKULL_WALK;
		this.cost = Settings.SKULL_COST;
		this.skillDetail = "-";
		this.name = "Skull";
	}

	public Skull(float x, float y, float width, float height, int team ,int hp ,int atk, int atkrange, int walk) {
		super(x, y, width, height, team);
		this.number = Settings.SKULL_NUMBER;
		this.hp = hp;
		this.atk = atk;
		this.atkRange = atkrange;
		this.walk = walk;
		this.cost = Settings.SKULL_COST;
		this.skillDetail = "-";
		this.name = "Skull";
	}
}
