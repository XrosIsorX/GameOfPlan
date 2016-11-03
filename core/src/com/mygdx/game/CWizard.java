package com.mygdx.game;

public class CWizard extends Character{

	public CWizard(float x, float y, float width, float height, int number , int turn) 
	{
		super(x, y, width, height, number , turn);
		hp= Settings.WIZARD_HP;
		atk = Settings.WIZARD_ATK;
		atkRange = Settings.WIZARD_ATKRANGE;
		walk = Settings.WIZARD_WALK;
		cost = Settings.WIZARD_COST;
		skill = "Spawn a SKULL on the target area.";
		skillRange = 1;
		name = "Wizard";
	}
	
	@Override
	public void skill()
	{
		World.state = Settings.STATE_SKILLSPAWN;
		World.skillSpawn = Settings.C_MON2;
	}
}
