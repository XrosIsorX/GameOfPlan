package com.mygdx.game;

public class Meep extends Character {

	public Meep(float x, float y, float width, float height, int team) {
		super(x, y, width, height, team);
		this.number = Settings.MEEP_NUMBER;
		this.hp = Settings.MEEP_HP;
		this.maxHp = Settings.MEEP_HP;
		this.mana = Settings.MEEP_MANA;
		this.maxMana = Settings.MEEP_MANA;
		this.atk = Settings.MEEP_ATK;
		this.atkRange = Settings.MEEP_ATKRANGE;
		this.walk = Settings.MEEP_WALK;
		this.cost = Settings.MEEP_COST;
		this.skillDetail = "-";
		this.name = "Meep";
	}

}
