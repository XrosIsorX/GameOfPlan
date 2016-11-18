package com.mygdx.game;

public class HpRestore extends PassiveSkill{

	public HpRestore(float x, float y, float width, float height, int team) {
		super(x, y, width, height);
		this.team = team;
		this.number = Settings.HPRESTORE_NUMBER;
		this.skillDetail = Settings.HPRESTORE_SKILL;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void skill() {
		for (Character n : World.ally.characters) {
			n.changeHp(1);
		}
	}
}
