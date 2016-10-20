package com.mygdx.game;

public class CWizard extends Character{

	public CWizard(float x, float y, float width, float height, int name, int team) 
	{
		super(x, y, width, height, name, team);
		hp= Settings.WIZARD_HP;
		atk = Settings.WIZARD_ATK;
		atkrank = Settings.WIZARD_ATKRANK;
		walk = Settings.WIZARD_WALK;
	}

}
