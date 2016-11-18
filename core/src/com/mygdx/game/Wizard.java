package com.mygdx.game;

public class Wizard extends Character{
	
	public Wizard(float x, float y, float width, float height, int team) {
		super(x, y, width, height, team);
		this.number = Settings.WIZARD_NUMBER;
		this.hp= Settings.WIZARD_HP;
		this.maxHp = Settings.WIZARD_HP;
		this.mana = Settings.WIZARD_MANA;
		this.maxMana = Settings.WIZARD_MANA;
		this.atk = Settings.WIZARD_ATK;
		this.atkRange = Settings.WIZARD_ATKRANGE;
		this.walk = Settings.WIZARD_WALK;
		this.cost = Settings.WIZARD_COST;
		this.skillDetail = Settings.WIZARD_SKILL;
		this.name = "Wizard";
		this.skillRange = Settings.WIZARD_SKILLRANGE;;
	}
	
	@Override
	public void skill() {
		if (this.mana >= Settings.WIZARD_SKILLCOST) {
			World.state = Settings.STATE_SKILLSPAWN;
			World.skillSpawn = Settings.SKULL_NUMBER;
			changeMana(-1 * Settings.WIZARD_SKILLCOST);
		}
	}
}
