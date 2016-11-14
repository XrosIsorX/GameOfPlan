package com.mygdx.game;

public class Wizard extends Character{
	
	public Wizard(float x, float y, float width, float height, int team) {
		super(x, y, width, height, team);
		this.number = Settings.WIZARD_NUMBER;
		this.hp= Settings.WIZARD_HP;
		this.atk = Settings.WIZARD_ATK;
		this.atkRange = Settings.WIZARD_ATKRANGE;
		this.walk = Settings.WIZARD_WALK;
		this.cost = Settings.WIZARD_COST;
		this.skill = "Spawn a SKULL on the target area.";
		this.name = "Wizard";
		this.skillRange = 1;
	}

	public Wizard(float x, float y, float width, float height, int team ,int hp ,int atk, int atkrange, int walk) {
		super(x, y, width, height, team);
		this.number = Settings.WIZARD_NUMBER;
		this.hp = hp;
		this.atk = atk;
		this.atkRange = atkrange;
		this.walk = walk;
		this.cost = Settings.WIZARD_COST;
		this.skill = "Spawn a SKULL on the target area.";
		this.name = "Wizard";
		this.skillRange = 1;
	}
	
	@Override
	public void skill() {
		World.state = Settings.STATE_SKILLSPAWN;
		World.skillSpawn = Settings.SKULL_NUMBER;
	}
}
