package com.mygdx.game;

public class CWizard extends Character{

	public CWizard(float x, float y, float width, float height, int number) 
	{
		super(x, y, width, height, number);
		hp= Settings.WIZARD_HP;
		atk = Settings.WIZARD_ATK;
		atkrank = Settings.WIZARD_ATKRANK;
		walk = Settings.WIZARD_WALK;
		cost = Settings.WIZARD_COST;
		skill = "Spawn a SKULL on the target area.";
		name = "Wizard";
	}
}
